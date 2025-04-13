package Exercise1;

import java.util.Comparator;

import Lab.AbstractSortedMap;
import Lab.BalanceableBinaryTree;
import Lab.Entry;
import Lab.Position;

/**
 * An implementation of a sorted map using a binary search tree.
 * 
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class TreeMap<K,V> extends AbstractSortedMap<K,V> {
    
    /**
     * The underlying tree structure for storing entries.
     * Uses a specialized BalanceableBinaryTree implementation.
     */
    protected BalanceableBinaryTree<K,V> tree = new BalanceableBinaryTree<>();
    
    /**
     * Constructs an empty map using the natural ordering of keys.
     */
    public TreeMap() {
        super(); // Invoke AbstractSortedMap constructor
        tree.addRoot(null); // Create a sentinel leaf as root
    }
    
    /**
     * Constructs an empty map using the given comparator to order keys.
     * 
     * @param comp the comparator that will be used to order keys
     */
    public TreeMap(Comparator<K> comp) {
        super(comp); // Invoke AbstractSortedMap constructor with comparator
        tree.addRoot(null); // Create a sentinel leaf as root
    }
    
    /**
     * Returns the number of entries in the map.
     * 
     * @return the number of entries in the map
     */
    public int size() {
        // Only internal nodes have entries (subtract 1 for sentinel and divide by 2)
        return (tree.size() - 1) / 2;
    }
    
    /**
     * Utility method used when inserting a new entry at a leaf of the tree.
     * 
     * @param p the position where the new entry will be inserted
     * @param entry the entry to be inserted
     */
    private void expandExternal(Position<Entry<K,V>> p, Entry<K,V> entry) {
        tree.set(p, entry); // Store new entry at position p
        tree.addLeft(p, null); // Add new sentinel leaf as left child
        tree.addRight(p, null); // Add new sentinel leaf as right child
    }
    
    /**
     * Shorthand method to get the root of the underlying tree.
     * 
     * @return the root position of the tree
     */
    protected Position<Entry<K,V>> root() {
        return tree.root();
    }
    
    /**
     * Searches for a key in the subtree rooted at the given position.
     * 
     * @param p the root position of the subtree to search
     * @param key the key to search for
     * @return the position containing the key, or the terminal leaf if not found
     */
    private Position<Entry<K,V>> treeSearch(Position<Entry<K,V>> p, K key) {
        if (isExternal(p))
            return p; // Key not found; return the final leaf
        
        int comp = compare(key, p.getElement());
        if (comp == 0)
            return p; // Key found; return its position
        else if (comp < 0)
            return treeSearch(left(p), key); // Search left subtree
        else
            return treeSearch(right(p), key); // Search right subtree
    }

	@Override
	public Entry<K, V> firstEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<K, V> lastEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<K, V> ceilingEntry(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<K, V> floorEntry(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<K, V> lowerEntry(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<K, V> higherEntry(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Entry<K, V>> subMap(K fromKey, K toKey) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
    
    // Additional utility methods would be implemented here:
    // protected Position<Entry<K,V>> left(Position<Entry<K,V>> p)
    // protected Position<Entry<K,V>> right(Position<Entry<K,V>> p)
    // protected Position<Entry<K,V>> parent(Position<Entry<K,V>> p)
    // protected boolean isExternal(Position<Entry<K,V>> p)
    // protected boolean isInternal(Position<Entry<K,V>> p)
    // protected Entry<K,V> set(Position<Entry<K,V>> p, Entry<K,V> e)
}