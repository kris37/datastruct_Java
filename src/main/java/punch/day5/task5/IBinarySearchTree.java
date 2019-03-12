package punch.day5.task5;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-10 22:35
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class IBinarySearchTree {
    //
    private static class Node{
        private int key;
        private Node left;
        private Node right;

        public Node(int key) {
            this(key,null,null);
        }

        public Node(int key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }

    private Node root = null;

    public void insert(int key){
        root = insert(key,root);
    }

    /**
     *  递归实现
     * @param key
     * @param cur
     * @return
     */
    private Node insert(int key,Node cur){
        if(cur == null){
            cur =  new Node(key);
        } else if(cur.key > key){
            cur.left = insert(key,cur.left);
        }else if (cur.key < key){
            cur.right = insert(key,cur.right);
        }
        return cur;
    }

    /**
     *  by loop
     * @param key
     */
    private void insertByLoop(int key){
        Node cur = root;
        Node pre = null;
        while (cur != null){
            pre = cur;
            if(cur.key == key){
                return;
            }else if(cur.key < key){
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        cur = new Node(key);
        if(pre == null) return;
        if(pre.key > key){
            pre.left = cur;
        }else {
            pre.right = cur;
        }
    }


    /**
     *
     * @param key
     * @return
     */
    public  Node delete(int key){
        Node res = search(key);
        if(res == null) return null;
        root = delete(key,root);
        return res;
    }

    /**
     *  key 这里一定存在
     * @param key
     * @param cur
     * @return
     */
    private Node delete(int key, Node cur){
        if(cur.key == key){
            return replaceByChild(cur);
        }else if(cur.key > key){
            cur.left = delete(key,cur.left);
        }else {
            cur.right = delete(key,cur.right);
        }
        return cur;
    }

    /**
     *
     * @param node
     * @return
     */
    private Node replaceByChild(Node node){
        // node 是要删除掉的
        if(node.left == null || node.right == null){
            if(node.left == null){
               Node res = node.right;
               node.right = null;
               return res;
            }else {
                Node res = node.left;
                node.left = null;
                return res;
            }

        }
        // 左右都不为null delete 左子树的最大节点替
         return findAndDeleteMaxNode(node.left);

    }

    private Node findAndDeleteMaxNode(Node node){
        // 查找当前node 左子树中的最大Node
        Node cur = node;
        while (cur.right != null && cur.right.right != null){
            cur = cur.right;
        }
       if(cur.right == null) {
           return cur;
       }else {
           Node res = cur.right;
           cur.right = cur.right.left;
           res.left = node;
           return res;
       }
    }

    public Node search(int key){
        Node cur = root;
        while (cur != null){
            if(cur.key == key) return cur;
            cur = cur.key > key? cur.left:cur.right;
        }
        return null;
    }

    //前驱结点：节点val值小于该节点val值并且值最大的节点
    //后继节点：节点val值大于该节点val值并且值最小的节点
    public Node searchNext(int key){

        Node cur = root;
        while (cur.left != null){

        }
        return null;
    }

    /**
     * 找到 cur.key == key  find cur.left 左子树的最大值 or 找到
     * @param key
     * @param node
     * @return
     */
    private Node searchNext(int key,Node node){
        // todo no parent pointer how to find
        return null;
    }

    public Node searchPre(int key){
    //todo no parent pointer how to find
        return null;
    }

    /**
     * leetcode norecursive inordertravel
     * public List<Integer> inorderTraversal(TreeNode root) {
     *     List<Integer> list = new ArrayList<Integer>();
     *
     *     Stack<TreeNode> stack = new Stack<TreeNode>();
     *     TreeNode cur = root;
     *
     *     while(cur!=null || !stack.empty()){
     *         while(cur!=null){
     *             stack.add(cur);
     *             cur = cur.left;
     *         }
     *         cur = stack.pop();
     *         list.add(cur.val);
     *         cur = cur.right;
     *     }
     *
     *     return list;
     * }
     */


    public List<Node> inorderTravelByStack(){
        LinkedList<Node> stack = new LinkedList<>();
        List<Node>  ressult = new LinkedList<Node>();
        if(root == null) return stack;
        Node cur = root;

        while (cur!= null || !stack.isEmpty()) {
            // 一直入stack
           // if(cur == null) cur = stack.pop();
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.pop();
                ressult.add(cur);
                cur = cur.right;
            }
        }
        return ressult;
    }

    /**
     *  no recursive
     */
    public List<Node> preTravelByStack(){
        LinkedList<Node> stack = new LinkedList<>();
        List<Node>  result = new LinkedList<Node>();
        if(root == null) return result;
        stack.push(root);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            result.add(pop);
            if(pop.right !=null) stack.push(pop.right);
            if(pop.left!=null) stack.push(pop.left);
        }
        return result;
    }

    /**
     * todo
     * no recursive
     *
     */
    public void postrTravelByStack(){

    }

}
