package punch.day14.leetcode;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     判断是否是完全二叉树
 *     1。 按层遍历 判断中间是否有null
 * <br>
 */
public class Leetcode958_CheckCompletenessOfBST {

      public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
      }

    public boolean isCompleteTree(TreeNode root) {
        if(root == null ) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean firstNil = true;
        while (queue.peek()!=null){
            TreeNode poll = queue.poll();
            queue.add(poll.left);
            queue.add(poll.right);
        }
        while (!queue.isEmpty() && queue.peek() == null){
            queue.poll();
        }
        return queue.isEmpty();
    }

}
