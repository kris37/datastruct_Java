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
     *  从 node 节点
     * @param node
     */
    private void reComputeHeightFromtoRoot(Node node){

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
        return Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1;
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
     *  todo
     * @param v
     */
    public void delete(int v) {
        if(search(v) == null) return;
        this.root = delete(v,root);
    }

    private Node delete(int v ,Node node){

        //todo
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
