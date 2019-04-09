package punch.day14.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *
 * <br>
 */
public class Leetcode206_ReverseList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
//        ListNode dummy = new ListNode(0);
//        reverseByRecursive(head,dummy).next = null;
//        ListNode res = dummy.next;
//        dummy.next = null;
//        return res;
        return reverseByLoop(head);
    }

    /**
     * 采用递归的方式解决
     * @param head
     * @return
     */
    private ListNode reverseByRecursive(ListNode head,ListNode dummy){
        if(head == null) return dummy;
        ListNode pre = reverseByRecursive(head.next,dummy);
        pre.next = head;
        return head;
    }

    /**
     *  dummy node
     *  by loop
     * @param head
     * @return
     */
    private ListNode reverseByLoop(ListNode head){
        ListNode pre = null;
        ListNode cur = head;

        while (cur.next != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        cur.next = pre;
        return cur;
    }
}
