package Exercise1;

import java.util.ArrayList;
import java.util.Comparator;

import Lab.AbstractSortedMap;
import Lab.BalanceableBinaryTree;
import Lab.Entry;
import Lab.Position;

/* An implementation of a sorted map using a binary search tree. */
public class TreeMap<K,V> extends AbstractSortedMap<K,V> {
    protected BalanceableBinaryTree<K,V> tree = new BalanceableBinaryTree<>();

    /* Constructors */
    public TreeMap() {
        super();                    // natural ordering of keys
        tree.addRoot(null);         // create sentinel leaf as root
    }
    public TreeMap(Comparator<K> comp) {
        super(comp);               // custom comparator
        tree.addRoot(null);        // sentinel leaf
    }

    /* Returns the number of entries in the map. */
    public int size() {
        return (tree.size() - 1) / 2;  // only internal nodes count
    }

    /* Utility to insert a new entry at a leaf. */
    private void expandExternal(Position<Entry<K,V>> p, Entry<K,V> entry) {
        tree.set(p, entry);
        tree.addLeft(p, null);      // add sentinel leaves
        tree.addRight(p, null);
    }

    /* Shorthand for underlying tree operations (e.g., root()). */
    protected Position<Entry<K,V>> root() { return tree.root(); }

    
    /* Primary Map Operations (Code Fragment 11.4) */
    public V get(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        rebalanceAccess(p);
        return isExternal(p) ? null : p.getElement().getValue();
    }

    public V put(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K,V> newEntry = new MapEntry<>(key, value);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        if (isExternal(p)) {
            expandExternal(p, newEntry);
            rebalanceInsert(p);
            return null;
        } else {
            V old = p.getElement().getValue();
            set(p, newEntry);
            rebalanceAccess(p);
            return old;
        }
    }

    public V remove(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        if (isExternal(p)) {
            rebalanceAccess(p);
            return null;
        } else {
            V old = p.getElement().getValue();
            if (isInternal(left(p)) && isInternal(right(p))) {
                Position<Entry<K,V>> replacement = treeMax(left(p));
                set(p, replacement.getElement());
                p = replacement;
            }
            Position<Entry<K,V>> leaf = (isExternal(left(p)) ? left(p) : right(p));
            remove(leaf);
            remove(p);
            rebalanceDelete(sibling(leaf));
            return old;
        }
    }

    /* Sorted Map Operations (Code Fragment 11.5) */
    protected Position<Entry<K,V>> treeMax(Position<Entry<K,V>> p) {
        Position<Entry<K,V>> walk = p;
        while (isInternal(walk)) walk = right(walk);
        return parent(walk);  // parent of the rightmost leaf
    }

    public Entry<K,V> lastEntry() {
        return isEmpty() ? null : treeMax(root()).getElement();
    }

    public Entry<K,V> floorEntry(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        if (isInternal(p)) return p.getElement();
        while (!isRoot(p)) {
            if (p == right(parent(p))) return parent(p).getElement();
            else p = parent(p);
        }
        return null;
    }

    /* Iteration Support (Code Fragment 11.6) */
    public Iterable<Entry<K,V>> entrySet() {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>(size());
        for (Position<Entry<K,V>> p : tree.inorder())
            if (isInternal(p)) buffer.add(p.getElement());
        return buffer;
    }

    public Iterable<Entry<K,V>> subMap(K fromKey, K toKey) {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>(size());
        if (compare(fromKey, toKey) < 0) subMapRecurse(fromKey, toKey, root(), buffer);
        return buffer;
    }

    private void subMapRecurse(K fromKey, K toKey, Position<Entry<K,V>> p, 
                              ArrayList<Entry<K,V>> buffer) {
        if (isInternal(p)) {
            if (compare(p.getElement(), fromKey) < 0) {
                subMapRecurse(fromKey, toKey, right(p), buffer);
            } else {
                subMapRecurse(fromKey, toKey, left(p), buffer);
                if (compare(p.getElement(), toKey) < 0) {
                    buffer.add(p.getElement());
                    subMapRecurse(fromKey, toKey, right(p), buffer);
                }
            }
     
        }
    }
    
    /**
     * Checks if a given position in the tree is an internal node.
     * Internal nodes have at least one child (in BSTs, they store actual entries).
     *  * 检查树中的给定位置是否为内部节点。
     *  * 内部节点至少有一个子节点（在二叉搜索树中，它们存储实际的条目）。
     */
    protected boolean isInternal(Position<Entry<K,V>> p) throws IllegalArgumentException {
        return tree.isInternal(p);  // Delegates to the underlying tree's implementation
    }

    /**
     * Checks if a position is an external node (leaf/sentinel).
     * 检查树中给定位置是否为一个外部节点。
     * 内部节点至少拥有一个子节点（在二叉搜索树中，它们存储实际的键值对条目）。
     */
    protected boolean isExternal(Position<Entry<K,V>> p) throws IllegalArgumentException {
        return !isInternal(p);
    }

    /**
     * Gets the left child of a position.
     */
    protected Position<Entry<K,V>> left(Position<Entry<K,V>> p) throws IllegalArgumentException {
        return tree.left(p);  // Assumes BalanceableBinaryTree provides this method
    }

    /**
     * Gets the right child of a position.
     */
    protected Position<Entry<K,V>> right(Position<Entry<K,V>> p) throws IllegalArgumentException {
        return tree.right(p);
    }

    /**
     * Gets the parent of a position.
     */
    protected Position<Entry<K,V>> parent(Position<Entry<K,V>> p) throws IllegalArgumentException {
        return tree.parent(p);
    }

    /**
     * Gets the sibling of a position.
     */
    protected Position<Entry<K,V>> sibling(Position<Entry<K,V>> p) throws IllegalArgumentException {
        return tree.sibling(p);
    }
    /** Returns true if position p is the root of the tree. */
    protected boolean isRoot(Position<Entry<K,V>> p) {
        return p == root();  // root() 是 TreeMap 中已定义的辅助方法
    }
    /** Replaces the entry at position p with newEntry. */
    protected void set(Position<Entry<K,V>> p, Entry<K,V> newEntry) {
        tree.set(p, newEntry);  // 假设 BalanceableBinaryTree 提供 set 方法
    }
    
    /** Removes the node at position p from the tree. */
    protected void remove(Position<Entry<K,V>> p) throws IllegalArgumentException {
        if (isInternal(left(p)) && isInternal(right(p))) {
            // Case: p has two internal children
            Position<Entry<K,V>> replacement = treeMax(left(p));
            set(p, replacement.getElement());
            p = replacement;  // 实际删除的是 replacement 节点
        }
        // 此时 p 至多有一个内部子节点
        Position<Entry<K,V>> leaf = isExternal(left(p)) ? left(p) : right(p);
        Position<Entry<K,V>> sib = sibling(leaf);
        tree.remove(leaf);  // 移除叶子（哨兵节点）
        tree.remove(p);     // 移除 p，sib 会取代 p 的位置
        rebalanceDelete(sib);  // 平衡钩子
    }

    

    // Stubs for balanced search tree operations (subclasses can override)
    /**
     * Rebalances the tree after an insertion of specified position.  This
     * version of the method does not do anything, but it can be
     * overridden by subclasses.
     * @param p the position which was recently inserted
     */
    protected void rebalanceInsert(Position<Entry<K,V>> p) { }

    /**
     * Rebalances the tree after a child of specified position has been
     * removed.  This version of the method does not do anything, but it
     * can be overridden by subclasses.
     * @param p the position of the sibling of the removed leaf
     */
    protected void rebalanceDelete(Position<Entry<K,V>> p) { }

    /**
     * Rebalances the tree after an access of specified position.  This
     * version of the method does not do anything, but it can be
     * overridden by a subclasses.
     * @param p the Position which was recently accessed (possibly a leaf)
     */
    protected void rebalanceAccess(Position<Entry<K,V>> p) { }
	@Override
	public Entry<K, V> firstEntry() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Entry<K, V> ceilingEntry(K key) throws IllegalArgumentException {
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
	  // remainder of class is for debug purposes only
	  /** Prints textual representation of tree structure (for debug purpose only). */
	  protected void dump() {
	    dumpRecurse(root(), 0);
	  }
	  
	  /** This exists for debugging only */
	  private void dumpRecurse(Position<Entry<K,V>> p, int depth) {
	    String indent = (depth == 0 ? "" : String.format("%" + (2*depth) + "s", ""));
	    if (isExternal(p))
	      System.out.println(indent + "leaf");
	    else {
	      System.out.println(indent + p.getElement());
	      dumpRecurse(left(p), depth+1);
	      dumpRecurse(right(p), depth+1);
	    }
	  }
	/* Recursive search for a key in the subtree rooted at p. */
//  private Position<Entry<K,V>> treeSearch(Position<Entry<K,V>> p, K key) {
//      if (isExternal(p)) return p;       // key not found (leaf)
//      int comp = compare(key, p.getElement());
//      if (comp == 0) return p;           // exact match
//      else if (comp < 0) return treeSearch(left(p), key);  // search left
//      else return treeSearch(right(p), key);               // search right
//  }
  /* Searches for a key in the subtree rooted at p using a loop (non-recursive). */
  private Position<Entry<K,V>> treeSearch(Position<Entry<K,V>> p, K key) {
      while (true) {
          if (isExternal(p)) {
              return p;  // Key not found: return the leaf node
          }
          
          int comp = compare(key, p.getElement());
          if (comp == 0) {
              return p;  // Exact match found
          } else if (comp < 0) {
              p = left(p);  // Search left subtree
          } else {
              p = right(p); // Search right subtree
          }
      }
  }
  

  private static <K,V> void testSearch(TreeMap<K,V> map, K key, String msg) {
      Position<Entry<K,V>> pos = map.treeSearch(map.root(), key);
      if (map.isInternal(pos)) {
          System.out.printf("%s: Found %s -> %s\n", 
              msg, key, pos.getElement().getValue());
      } else {
          System.out.printf("%s: %s not found (reached leaf)\n", msg, key);
      }
  }

  private static <K,V> void printTreeStructure(TreeMap<K,V> map, 
          Position<Entry<K,V>> p, int depth) {
	  
	  // 如果节点为空或是外部节点则返回
	  // Return if node is null or external
      if (p == null || !map.isInternal(p)) return;

      // 右子树（上）
      // Right subtree (top)
      printTreeStructure(map, map.right(p), depth + 1);

      // 当前节点
      // Current node
      for (int i = 0; i < depth; i++) System.out.print("    ");
      System.out.println(p.getElement().getKey());

      // 左子树（下）
      // Left subtree (bottom)
      printTreeStructure(map, map.left(p), depth + 1);
  }
  public static void main(String[] args) {
      // 创建类似图11.7的线性高度树（键按递增顺序插入）
	  // Create linear-height tree similar to Figure 11.7 (keys inserted in increasing order)
      TreeMap<Integer, String> linearHeightTree = new TreeMap<>();
      
      // 插入键1-7（如图11.7所示）
      // Insert keys 1-7 (as shown in Figure 11.7)
      for (int i = 1; i <= 7; i++) {
          linearHeightTree.put(i, "Value" + i);
      }

      // Test treeSearch()
      testSearch(linearHeightTree, 3, "Found existing key 3");   // 应找到
      testSearch(linearHeightTree, 5, "Found existing key 5");   // 应找到
      testSearch(linearHeightTree, 0, "Search non-existing key 0"); // 应返回叶子节点
      testSearch(linearHeightTree, 8, "Search non-existing key 8"); // 应返回叶子节点

      // Print tree structure
      System.out.println("\nTree Structure:");
      printTreeStructure(linearHeightTree, linearHeightTree.root(), 0);
  }

}