package punch.day11.task;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     实现 AVL 树
 *     insert
 *     delete
 *     search
 *     [left_rotate,right_rotate,height,size]
 *
 * <br>
 */
public class IAVLTree {
    public static class Node{
        int key;
        Object value;
        int height;
        int size;
        Node left;
        Node right;

        public Node(int key, Object value, int height, int size) {
            this.key = key;
            this.value = value;
            this.height = height;
            this.size = size;
        }

        public Node(int key, Object value) {
            this(key,value,1,1);
        }
    }
    private Node root;

    private int getSize(Node node){
        return node ==null?0:node.size;
    }

    /**
     * 重新计算 node 的size 数值
     * @param node
     * @return
     */
    private int reComputeSize(Node node){
        return node ==null?0:
                getSize(node.left) + getSize(node.right) + 1;
    }


    private int getHeight(Node node){
        return node == null?0:node.height;
    }
    private int reComputeHeight(Node node){
        return node == null?0:
                Math.max(getHeight(node.left) ,getHeight(node.right)) +1;

    }

    /**
     *  from node to leaf node 重建所有子树的node size
     * @param node
     * @return
     */
    private int reBuildSize(Node node){
        if(node == null ) return 0;
        node.size = reBuildSize(node.left) + reBuildSize(node.right) +1;
        return node.size;
    }

    /**
     *  from node to leaf node  重建所有子树高度
     * @return
     */
    private int reBuildHeight(Node node){
        if(node == null) return 0;
        node.height = Math.max(reBuildHeight(node.left),reComputeHeight(node.right)) +1;
        return node.height;
    }
    /**
     * 左旋o                           r
     *                     o         /  \
     *      *               \        o   s
     *      *                r       \
     *      *               /\       t
     *      *               t s
     *
     * @return
     */
    private Node leftRotate(Node node){
            Node cur = node.right;
            node.right = cur.left;
            cur.left = node;
            // size
            node.size =reComputeSize(node);
            cur.size = reComputeSize(cur);
            // height
            node.height = reComputeHeight(node);
            cur.height = reComputeHeight(cur);
            return cur;
    }

    private Node rightRotate(Node node){
        Node cur = node.left;
        node.left = cur.right;
        cur.right = node;
        // size
        node.size =reComputeSize(node);
        cur.size = reComputeSize(cur);
        // height
        node.height = reComputeHeight(node);
        cur.height = reComputeHeight(cur);
        return cur;
    }


    public int size(){
        return root == null?0:root.size;
    }

    public boolean isBalance(Node node){

        return node == null || Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1;
    }



    public void insert(int key,Object value){
        this.root = insert(key,value,root);
    }
    /**
     * 递归方式处理
     * 可以同时处理 height size
     * @param key
     * @param value
     * @param node
     * @return
     */
    private Node insert(int key,Object value,Node node) {
        if(node == null) return new Node(key,value);
        if(node.key == key){
            node.value = value;
            return node;
        }
        if(node.key > key){
            node.left = insert(key,value,node.left);
        }else {
            node.right = insert(key,value,node.right);
        }
        if(!isBalance(node)){
            // 旋转 is recompute
            return getHeight(node.left) > getHeight(node.right)?
                    rightRotate(node):leftRotate(node);
        }
        // recompute size and height
        node.height = reComputeHeight(node);
        node.size = reComputeSize(node);
        return node;
    }

    /**
     *
     * @param v
     */
    public void delete(int v) {
        if(search(v) == null) return;
        this.root = delete(v,root);
    }

    /**
     *  delete 如果 v 左右存在 null 则 返回不为null 的子节点 向上平衡重新计算height size 等
     *   否则 根据 v.left.height v.right.height 找出树较高的节点 找到 node = if(node is left delete max(left) else delete min(right))
     *   replace  v with node
     *
     * @param
     * @param node
     * @return
     */
    private Node delete(int key ,Node node){
        if(node.key == key){
            if(node.left == null || node.right == null){

                Node cur = node.left == null ? node.right:node.left;
                node.left = node.right = null;
                node = cur;
            }else {
                node =  replaceWithLeftMax(node);
            }
        }else if(node.key > key){
            node.left = delete(key,node.left);
        }else{
            node.right = delete(key,node.right);
        }
        if(node == null) return null;
        if(!isBalance(node)){
            // 旋转 is recompute
            return getHeight(node.left) > getHeight(node.right)?
                    rightRotate(node):leftRotate(node);
        }
        node.height = reComputeHeight(node);
        node.size = reComputeSize(node);
        return node;
    }

    /**
     *  remove a and replace by max(subtree(b))
     *      a             e
     *    /  \           / \
     *   b    c     =>  b   c
     *  / \  / \       /    /\
     * d  e  f g      d    f  g
     *
     *
     * @param node
     * @return
     */
    private Node replaceWithLeftMax(Node node){
        Node cur = node.left;
        node.left = null;
        if(cur.right == null){
            // return cur;
            cur.right = node.right;
            cur.size = reComputeSize(cur);
            cur.height = reComputeHeight(cur);
            return cur;
        }
        Node subRoot = removeMMaxNode(cur);
        subRoot.left = cur;
        subRoot.right = node.right;
        subRoot.size = reComputeSize(subRoot);
        subRoot.height = reComputeHeight(subRoot);
        return subRoot;
    }
    // 不会出现 node = null 的情况
    private Node removeMMaxNode(Node node){
        Node subRoot = node;
      if( node.right.right == null){
            subRoot = node.right;
            node.right = null;
        }else{
            subRoot =  removeMMaxNode(node.right);
        }
        node.size = reComputeSize(node);
        node.height = reComputeSize(node);
        return subRoot;
    }
    private Node replaceWithRightMin(Node node){

        return null;
    }

    public Object search(int v) {
        Node cur = root;
        while (cur != null){
            if(cur.key == v) return cur.value;
            cur = cur.key > v?cur.left:cur.right;
        }
        return null;
    }

    public static void main(String [] args){

    }

}
