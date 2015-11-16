package ba.bitcamp.linked.lists;

public class Neighbor {
	
	public String homeOwnerName;
	public int houseNumber;
	public Neighbor next;
	public Neighbor previous;
	
	/**
	 * Constructor constructs Neighbor object
	 * @param homeOwnerName - owner's name
	 * @param houseNumber - owners house number
	 */
	public Neighbor(String homeOwnerName, int houseNumber){
		this.homeOwnerName = homeOwnerName;
		this.houseNumber = houseNumber;
	}
	
	/**
	 * Method displays owners name and house number
	 */
	public void display(){
		System.out.println(homeOwnerName + ": " + houseNumber + " Ismeta Mujezinovica");
	}
	
	public String toString(){
		return homeOwnerName;
	}
}
