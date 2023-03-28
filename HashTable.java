public class HashTable {

	public static void main(String[] args){

		// Create the Linear Probing Hash Table
		// Size 9
		LinearProbingHashTable lpht = new LinearProbingHashTable(9);


		// Key and Value pairs to insert
		lpht.insert("5", "Five");
		lpht.insert("9", "Nine");
		lpht.insert("3", "Three");
		lpht.insert("1", "One");
		
		//Display Hash table
		System.out.println("Current Hash Table");		
		lpht.printHashTable();

		//Delete entry by key
		lpht.remove("1");

		// Display hash table on console after deletion
		System.out.println("\nHash table after deleting one or more elements");
		lpht.printHashTable();

	}

}

