package punch.day1.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-06 17:46
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     判断单向链表是否有环
 *     双指针法
 * <br>
 */
public class Leetcode141_CycleList {

   private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public boolean hasCycle(ListNode head) {
        ListNode quick  = head;
        ListNode slow  = head;
        while (quick != null && quick.next !=null){

            quick = quick.next.next;
            slow = slow.next;
            if(quick == slow) return true;
        }
        return false;
    }
}
