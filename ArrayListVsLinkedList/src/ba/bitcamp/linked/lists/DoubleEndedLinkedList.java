package ba.bitcamp.linked.lists;


/**
 * Double linked list has a reference to the first and last node in the list
 * @author Emina
 *
 */
public class DoubleEndedLinkedList {
	Neighbor firstLink;
	Neighbor lastLink;
	
	/**
	 * display method will display the list as long as there is Neighbor in the list
	 */
	public void display(){
		Neighbor theLink = firstLink;
		while(theLink != null){
			theLink.display();
			System.out.println("Next Link: " + theLink.next);
			theLink = theLink.next;
			System.out.println("****************************");
		}
	}
	
	/**
	 * Method checks if list is empty
	 * @return null 
	 */
	public boolean isEmpty(){
		return(firstLink == null);
	}
	
	/**
	 * Method inserts Neighbors in order based on house number
	 * @param homeOwnerName - owners name
	 * @param houseNumber - owners house number
	 */
	public void insertInOrder(String homeOwnerName, int houseNumber){
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);
		//hold the last Neighbor searched so we can change its value for next if we input a new Neighbor
		Neighbor previousNeighbor = null;
		Neighbor currentNeighbor = firstLink;
		
		while((currentNeighbor != null) && (houseNumber > currentNeighbor.houseNumber)){
			previousNeighbor = currentNeighbor;
			currentNeighbor = currentNeighbor.next;
		}
		if(previousNeighbor == null){
			firstLink = theNewLink;
		}else{
			previousNeighbor.next = theNewLink;
		}
		theNewLink.next = currentNeighbor;
	}
	
	/**
	 * Method inserts Neighbor to the first position in Linked List
	  * @param homeOwnerName - owners name
	 * @param houseNumber - owners house number
	 */
	public void insertInFirstPosition(String homeOwnerName, int houseNumber){
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);
		//if there are no items in the list, add the new Link to lastLink in the LinkedList
		if(isEmpty()){
			lastLink = theNewLink;
		}else{
			firstLink.previous = theNewLink;
		}
		theNewLink.next = firstLink;
		firstLink = theNewLink;
	}
	
	/**
	 * Method inserts Neighbor to the last position in Linked List
	  * @param homeOwnerName - owners name
	 * @param houseNumber - owners house number
	 */
	public void insertInLastPosition(String homeOwnerName, int houseNumber){
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);
		if(isEmpty()){
			firstLink = theNewLink;
		}else{
			lastLink.next = theNewLink;
			theNewLink.previous = lastLink;
		}
		lastLink = theNewLink;
	}
	
	/**
	 * Method inserts neighbor after provided key
	 * @param homeOwnerName - house owner name
	 * @param houseNumber - owner's house number
	 * @param key - provided key
	 * @return
	 */
	public boolean insertAfterProvidedKey(String homeOwnerName, int houseNumber, int key){
		Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);
		//search list from firstLink
		Neighbor currentNeighbor = firstLink;
		//while the currentHouseNumber is not the key keep looking
		while(currentNeighbor.houseNumber != key){
			currentNeighbor = currentNeighbor.next;
			if(currentNeighbor == null){
				return false;
			}
		}
		if(currentNeighbor == lastLink){
			theNewLink.next = null;
			lastLink = theNewLink;
		}else{
			theNewLink.next = currentNeighbor.next;
			currentNeighbor.next.previous = theNewLink;
		}
		theNewLink.previous = currentNeighbor;
		currentNeighbor.next = theNewLink;
		return true;
	}

	public static void main(String[] args) {

		DoubleEndedLinkedList list = new DoubleEndedLinkedList();
		System.out.println("Insert in first position...");
		list.insertInFirstPosition("Ada", 12);
		list.insertInFirstPosition("Ema", 1);
		list.insertInFirstPosition("Ed", 5);
		list.insertInFirstPosition("Omar", 21);
		list.display();
		
		System.out.println();
		
		System.out.println("Insert in order...");
		list.insertInOrder("Ada", 12);
		list.insertInOrder("Ema", 1);
		list.insertInOrder("Ed", 5);
		list.insertInOrder("Omar", 21);
		list.display();
		
		list.insertAfterProvidedKey("Donna", 2, 5);
		list.display();
		
		NeighborIterator neighborIterator = new NeighborIterator(list);
		neighborIterator.currentNeighbor.display();
		System.out.println(neighborIterator.hasNext());
		neighborIterator.next();
		neighborIterator.currentNeighbor.display();
		neighborIterator.remove();
		neighborIterator.currentNeighbor.display();
		neighborIterator.remove();
		neighborIterator.currentNeighbor.display();
		neighborIterator.previousNeighbor.display();
	}

}
