package punch.day5.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.

 * @version punch
 * Date: 2019-03-11 18:53
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class Leetcode94_BSTInorderTravel {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer>  result = new LinkedList<Integer>();
        if(root == null) return result;
        TreeNode cur = root;

        while (cur!= null || !stack.isEmpty()) {
            // 一直入stack
            // if(cur == null) cur = stack.pop();
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }
}
