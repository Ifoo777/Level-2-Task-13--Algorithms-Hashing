public class LinearProbingHashTable {


	//Max size is the size of the table
	int maxSize;

	String[] keys;

	String[] values;

	//Set the properties of the Table
	public LinearProbingHashTable(int capacity){
		
		// Capacity is the size of the table but first position starts at 0
		// Max is the size of the table (table end at 1 less because of index)
		maxSize = capacity;

		// Set keys and values table sizes
		keys = new String[maxSize];
		values = new String[maxSize];
	}


	// Function to check if hash table contains a key and return value if it does
	public boolean contains(String key){
		return get(key) != null;
	}

		
	// Function to get hash code of a given key
	// Modulus it by the table size
	private int hash(String key){
		return key.hashCode() % maxSize;
	}

	
	// Function to insert key-value pair
	public void insert(String key, String val){

		// Get the hash value after modulus
		int temporaryPosition = hash(key);

		int i = temporaryPosition;

		do{
			//If the position is available, allocate entries into key and value arrays
			if (keys[i] == null){

				keys[i] = key;
				values[i] = val;
				// return if allocated
				return;
			}

			// If the key is the same as the key in position,replace with new value 
			if (keys[i].equals(key)){
				values[i] = val;
				return;
			}

			// If no return yet, add 1 and test of modulus work for position
			i = (i + 1) % maxSize;
		} //Continue While loop until available position is found 
		while (i != temporaryPosition);

	}

	
	// Function to get value for a given key
	public String get(String key){

		int i = hash(key);
		// While there is more values (not equals null)
		while (keys[i] != null){
			// If equal position to the key
			if (keys[i].equals(key))
				// return value at the position
				return values[i];
			//continue to ++ i and modulus by size
			i = (i + 1) % maxSize;
		}
		// return value null (not found) if key not found that matches
		return null;
	}

	
	// Function to remove key and its value
	public void remove(String key){

		//If does not contain the key, return
		if (!contains(key))
			return;

		// find position key and delete
		int i = hash(key);

		// Search for the correct index position that matches the key by running a while loop
		while (!key.equals(keys[i])) {
			i = (i + 1) % maxSize;
		}

		// Delete the key and value at the found index position
		keys[i] = values[i] = null;

		// Rehash all keys
		// For loop for each position of the array
		// Start at position i which was deleted +1
		for (i = (i + 1) % maxSize; keys[i] != null; i = (i + 1) % maxSize) {

			//Keep place holders for the key and value
			String temporaryPosition1 = keys[i], temporaryPosition2 = values[i];
			//Clear that position of key and value to null
			keys[i] = values[i] = null;
			// Use the insert method to insert the key and value from the temporary place holders into the arrays
			insert(temporaryPosition1, temporaryPosition2);
		}

	}
	

	// Function to print HashTable
	public void printHashTable(){
		
		// Display on console the Hash Table
		System.out.println("\nHash Table: ");
		
		// Display each item pair key and value of the array if its not a null value
		for (int i = 0; i < maxSize; i++) {
			if (keys[i] != null) {
				System.out.println(keys[i] + " " + values[i]);
			}
		}
	}
}

