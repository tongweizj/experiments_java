package Lab;
/**
 * 可平衡二叉搜索树（继承自LinkedBinaryTree）
 * 提供平衡操作支持（如AVL树、伸展树等）
 */
public class BalanceableBinaryTree<K,V> extends LinkedBinaryTree<Entry<K,V>> {

    //------------------------ 嵌套BSTNode类 ------------------------
    /**
     * 扩展的二叉树节点，增加aux字段用于平衡信息存储
     * @param <E> 节点元素类型
     */
    protected static class BSTNode<E> extends Node<E> {
        int aux = 0;  // 平衡辅助字段（存储高度/颜色等）

        BSTNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
            super(e, parent, left, right);
        }

        // aux字段访问方法
        int getAux() { return aux; }
        void setAux(int value) { aux = value; }
    }
    //----------------------- 结束嵌套类 ---------------------------

    //--------------------- 平衡相关操作方法 ------------------------
    /**
     * 获取节点的平衡辅助值
     * @param p 目标位置
     * @return aux值
     * @throws IllegalArgumentException 如果位置无效
     */
    public int getAux(Position<Entry<K,V>> p) {
    	return ((BSTNode<Entry<K,V>>)p).getAux( );
    }

    /**
     * 设置节点的平衡辅助值
     * @param p 目标位置
     * @param value 要设置的aux值
     * @throws IllegalArgumentException 如果位置无效
     */
    public void setAux(Position<Entry<K,V>> p, int value) {
    	((BSTNode<Entry<K,V>>)p).setAux(value);
    }

    //--------------------- 覆盖的工厂方法 --------------------------
    /**
     * 创建BST节点（覆盖父类方法）
     * @return 新建的BSTNode实例
     */
    @Override
    protected Node<Entry<K,V>> createNode(Entry<K,V> e, 
                                        Node<Entry<K,V>> parent,
                                        Node<Entry<K,V>> left, 
                                        Node<Entry<K,V>> right) {
        return new BSTNode<>(e, parent, left, right);
    }

    /**
     * 平衡二叉树旋转操作实现
     * 提供节点重连接(relink)、单旋转(rotate)和三节点重构(restructure)功能
     */

        //------------------------ 节点重连接操作 ------------------------
        /**
         * 重新连接父子节点关系
         * @param parent 父节点
         * @param child 子节点
         * @param makeLeftChild 是否作为左孩子连接
         */
        private void relink(Node<Entry<K,V>> parent, 
                          Node<Entry<K,V>> child,
                          boolean makeLeftChild) {
            // 设置子节点的父引用
            child.setParent(parent);
            
            // 根据方向连接为左或右孩子
            if (makeLeftChild) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }

        //------------------------ 单旋转操作 --------------------------
        /**
         * 将位置p的节点上旋到其父节点位置
         * @param p 要旋转的节点位置
         * @throws IllegalArgumentException 如果节点无效或没有父节点
         */
        public void rotate(Position<Entry<K,V>> p) {
            Node<Entry<K,V>> x = validate(p);
            Node<Entry<K,V>> y = x.getParent();  // 必须存在父节点
            Node<Entry<K,V>> z = y.getParent(); // 祖父节点(可能为null)

            // 1. 处理x与祖父z的关系
            if (z == null) {
                root = x;        // x成为新根
                x.setParent(null);
            } else {
                // 将x连接到z原来y的位置
                relink(z, x, y == z.getLeft()); 
            }

            // 2. 旋转x和y，处理中间子树
            if (x == y.getLeft()) { // 左孩子情况
                relink(y, x.getRight(), true);  // x的右子树变为y的左子树
                relink(x, y, false);           // y变为x的右孩子
            } else {                // 右孩子情况
                relink(y, x.getLeft(), false); // x的左子树变为y的右子树
                relink(x, y, true);           // y变为x的左孩子
            }
        }

        //----------------------- 三节点重构操作 ------------------------
        /**
         * 对x及其父节点、祖父节点进行三节点重构
         * @param x 要重构的节点位置
         * @return 重构后子树的根节点
         */
        public Position<Entry<K,V>> restructure(Position<Entry<K,V>> x) {
            Position<Entry<K,V>> y = parent(x);
            Position<Entry<K,V>> z = parent(y);
            
            // 判断对齐方式（是否同方向）
            boolean sameAlignment = (x == right(y)) == (y == right(z));
            
            if (sameAlignment) {  // 同方向排列 -> 单旋转
                rotate(y);       // 对y进行单旋转
                return y;        // y成为新根
            } else {             // 反方向排列 -> 双旋转
                rotate(x);       // 对x进行两次旋转
                rotate(x);
                return x;        // x成为新根
            }
        }
    }

