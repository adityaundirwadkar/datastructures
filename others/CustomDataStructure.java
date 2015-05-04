package others;

import java.util.*;

/*

 Design a data structure that supports insert, delete, search and getRandom in constant time.
 Design a data structure that supports following operations in Θ(1) time.

 insert(x): Inserts an item x to the data structure if not already present.
 remove(x): Removes an item x from the data structure if present.
 search(x): Searches an item x in the data structure.
 getRandom(): Returns a random element from current set of elements  
 */

public class CustomDataStructure {

	private ArrayList<Integer> internalStorage; // Generic arraylist to store
												// actual elements.
	private HashMap<Integer, Integer> internalMap;
	private int size;

	/**
	 * @return the internalMap
	 */
	public HashMap<Integer, Integer> getInternalMap() {
		return internalMap;
	}

	/**
	 * @param internalMap
	 *            the internalMap to set
	 */
	public void setInternalMap(HashMap<Integer, Integer> internalMap) {
		this.internalMap = internalMap;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	public CustomDataStructure() {
		// TODO Auto-generated constructor stub
		// Initialize all of the members.
		this.internalStorage = new ArrayList<Integer>();
		this.setInternalMap(new HashMap<Integer, Integer>());
		this.setSize(internalStorage.size());
	}

	// insert(x): Inserts an item x to the data structure if not already
	// present.
	public boolean insert(int x) {
		// either the value is present
		if (!this.getInternalMap().containsKey(x)) {
			// We do not have this key.
			this.internalStorage.add(x);
			this.internalMap.put(x, this.size);
			this.size++;
			return true;
		} else {
			return false;
		}
	}

	// remove(x): Removes an item x from the data structure if present.
	@SuppressWarnings("null")
	public int remove(int x) {
		if (this.getInternalMap().containsKey(x)) {
			// 1. Get index of the current key.
			// 2. Get last key from internalStorage.
			// 3. Replace the last key's index in both internalStorage and
			// internalMap
			// 4. Remove current key from the internalMap.

			int value = this.getInternalMap().remove(x); // remove from hashmap
			int newKey = this.internalStorage.remove(this.size-1); // Remove last
																	// element
																	// from the
																	// arraylist.
			this.getInternalMap().put(newKey, value); // Add last element of the
														// arraylist to the
														// hashmap with x's
														// index.
			this.internalStorage.remove(value); // Remove x from the arraylist.
			this.internalStorage.add(value, newKey); // Replace x with last
														// element.
			this.size--;
			return x;
		} else
			return ((Integer) null);
	}

	// search(x): Searches an item x in the data structure.
	public boolean search(int x) {
		return this.internalMap.containsKey(x);
	}

	// getRandom(): Returns a random element from current set of elements
	public int getRandom() {
		Random rand = new Random();
		return this.internalStorage.get(rand.nextInt(this.size));
	}
	
	public static void main(String[] args){
		CustomDataStructure ds = new CustomDataStructure();
        ds.insert(10);
        ds.insert(20);
        ds.insert(30);
        ds.insert(40);
        System.out.println(ds.search(30));
        ds.remove(20);
        ds.insert(50);
        System.out.println(ds.search(50));
        System.out.println(ds.getRandom());
	}
}
