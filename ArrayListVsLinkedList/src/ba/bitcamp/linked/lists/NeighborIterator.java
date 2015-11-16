package ba.bitcamp.linked.lists;
/**
 * NeighborIterator provides an easy way to cycle trough all the objects in a LinkedList
 * @author Emina
 *
 */
public class NeighborIterator {

	Neighbor currentNeighbor;
	Neighbor previousNeighbor;
	DoubleEndedLinkedList theNeighbors;
	
	/**
	 * Constructor 
	 * @param theNeighbors
	 */
	public NeighborIterator(DoubleEndedLinkedList theNeighbors){
		this.theNeighbors = theNeighbors;
		currentNeighbor = theNeighbors.firstLink;
		previousNeighbor = theNeighbors.lastLink;
	}
	
	/**
	 * Method checks if there is next neighbor in the list
	 * @return true if element in linked list has next neighbor, otherwise return false
	 */
	public boolean hasNext(){
		if(currentNeighbor.next != null){
			return true;
		}else{
			return false;
		}
	}
	
	public Neighbor next(){
		if(hasNext()){
			previousNeighbor = currentNeighbor;
			currentNeighbor = currentNeighbor.next;
			return currentNeighbor;
		}
		return null;
	}
	
	/**
	 * Remove method is used to remove element from linked list
	 */
	public void remove(){
		if(previousNeighbor == null){
			theNeighbors.firstLink = currentNeighbor.next;
		}else{
			previousNeighbor.next = currentNeighbor.next;
			
			if(currentNeighbor.next == null){
				//assign first link as the current link
				currentNeighbor = theNeighbors.firstLink;
				previousNeighbor = null;
			}else{
				currentNeighbor = currentNeighbor.next;
			}
		}
	}
}
