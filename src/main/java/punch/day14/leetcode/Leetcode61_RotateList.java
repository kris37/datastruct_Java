package punch.day14.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class Leetcode61_RotateList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 遍历第一次
     * 如果 k 大于 整个链表的长度
     * k %= len
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(k <= 0 || head == null) return head;
        int len = 1,gap = 0;
        ListNode cur = head,slow = head;
        while (cur.next != null){
            if( gap < k){
                gap ++;
            }else {
                slow = slow.next;
            }
            cur = cur.next;
            len ++;
        }
        // 处理
        if(k >= len){
            k %= len;
            return rotateRight(head,k);
        }
        // 直接处理 slow  is the end node， slow.next is newhead,cur  concat the old head;
        cur.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

}
