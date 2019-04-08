package punch.day11.task;


import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     RBtree 实现
 *     参考算法导论 CLRS
 * <br>
 */
public class IRBTree {

    public static enum Color{
        RED,
        BLACK;
    }
    private static class Node{
        int key;
        Object value;
        Node left,right,parent;
        Color color = Color.RED;

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        /**
         *  只将 node 的parent 指针指向 this
         *  this left 指针指向 node
         *  并不处理原 this.left 节点的parent 指针
         * @param node
         */
        public void setLeft(Node node){
            this.left = node;
            if(node != null)node.parent = this;
        }
        /**
         *  只将 node 的parent 指针指向 this
         *  this.right 指针指向 node
         *  并不处理原 this.right 节点的parent 指针
         * @param node
         */
        public void setRight(Node node){
            this.right = node;
            if(node!=null) node.parent = this;
        }

        /**
         *  将 this.left 节点替换为 node 节点，并且处理原节点的指针指向
         * @param node
         */
        public void replaceLeft(Node node){

            if(this.left == null){
                this.setLeft(node);
                return;
            }else if(node == null){
                // 删掉左子树
                this.left.parent = null;
                this.left = null;
                return;
            }
            // node & this.left 都不为 null
            Node leftNode = this.left;
            node.parent = this;
            this.left = node;
            node.setLeft(leftNode.left);
            node.setRight(leftNode.right);
            leftNode.parent = null;
            leftNode.left = null;
            leftNode.right = null;
            leftNode = null;
        }

        public void replaceRight(Node node){

            if(this.right == null){
                this.setRight(node);
                return;
            }else if(node == null){
                // 删掉右子树
                this.right.parent = null;
                this.right = null;
                return;
            }
            // node & this.left 都不为 null
            Node rightNode = this.right;
            node.parent = this;
            this.right = node;
            node.setLeft(rightNode.left);
            node.setRight(rightNode.right);
            rightNode.parent = null;
            rightNode.left = null;
            rightNode.right = null;
            rightNode = null;
        }

    }

    private Node root;
    public void insert(int key,Object value){
        if(root == null){
            root = new Node(key,value);
            root.color = Color.BLACK;
            return;
        }
       insert(key,value,root);
       this.root.color = Color.BLACK;
    }

    private void insert(int key,Object value,Node node){
        Node pre = null;
        while (node != null){
            if(node.key == key){
                node.value = value;
                return;
            }
            pre = node;
            node = node.key > key?node.left:node.right;
        }
        node = new Node(key,value);
        if(pre.key > key){
            pre.setLeft(node);
        }else {
            pre.setRight(node);
        }
        // fix up recolor and rotation
        fixUp(node);
    }

    /**
     *
     * @param node
     * @return node节点的父亲节点
     */
    private Node getParent(Node node){
        if(node == null) return null;
        return node.parent;
    }

    /**
     * 返回节点的颜色 if node == null return Black
     * @param node
     * @return
     */
    private Color getColor(Node node){
        if (node == null) return Color.BLACK;
        return node.color;
    }

    /**
     * 左旋 ，只交换位置，不改变颜色
     * @param node
     */
    private Node  leftRotate(Node node){
        Node rightNode = node.right;
        node.setRight(rightNode.left);
        rightNode.setLeft(node);
        return rightNode;
    }

    private void fixUp(Node node){
        while (node != root && node.color == Color.RED){
            Node parent = getParent(node);
            if(parent.color == Color.BLACK) return ;// 这个限制了 parent 节点如果是 root节点 回直接返回
            // 如果父节点是祖父节点的左节点
            if(parent == parent.parent.left){
                //case 1 祖父节点的右节点 uncle 节点是红色节点,则将 祖父节点的黑色下沉,
                // grandParent Black => RED parent & uncle  RED(说明 uncle 红色不可能为 null) => Black
                if(getColor(parent.parent.right) == Color.RED){
                    parent.parent.color = Color.RED;
                    parent.color = Color.BLACK;
                    parent.parent.right.color = Color.BLACK;
                    node = parent.parent;
                }else {
                    // 进入到此处说明 uncle 节点为黑色(maybe null)
                    if(node == parent.right){
                        //case 2 多旋转一次 parent is left but node is right 将node 旋转至与 parent & grandparent 一条线
                        Node grandParent = parent.parent;
                        node = parent;
                        parent = leftRotate(parent);
                        grandParent.setLeft(parent);
                    }
                    node.parent.color = Color.BLACK;
                    parent.parent.color = Color.RED;
                    // case 3
                   // node = rightRotate(parent.parent);
                }

            }else {
                // anti case 1
            }

        }
        return ;
    }
}
