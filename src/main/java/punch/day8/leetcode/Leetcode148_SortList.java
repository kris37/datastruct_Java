package punch.day8.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-03-29 09:11
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *    对单/双向链表进行排序
 *    要求O(NlgN) 避免最坏能是 O(N^2)
 *      空间复杂度O(1)
 *
 *     quickSort 链表中很难快速查询位置/且最坏O(N^2)
 *     堆排序也是一样问题
 *     所以归并排序最适合链表排序
 * <br>
 */
public class Leetcode148_SortList {

    /**
     * 单向链表
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next ==null) return head;
        return divide(head);
    }

    private ListNode divide(ListNode head){

        if(head.next == null) return head;
        if( head.next.next == null){
            if(head.val > head.next.val) {
                ListNode nHead = head.next;
                head.next = null;
                nHead.next = head;
                return nHead;
            }
            return head;
        }
        // 对于单向链表进行快慢法查找midnode
        ListNode fast = head;
        ListNode slow = head;
        ListNode preSlow = null;
        while (fast!= null && fast.next != null){
            preSlow = slow;
            slow = slow.next;
            fast  = fast.next.next;
        }
        //[head,slow),[slow,end]
        preSlow.next = null;
        ListNode divide1 = divide(head);
        ListNode divide2 = divide(slow);

        return mergeSort(divide1,divide2);
    }


    /**
     *  双指针法
     * @param x
     * @param y
     * @return
     */
    private ListNode mergeSort(ListNode x,ListNode y) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (x != null && y != null) {
            if (x.val <= y.val) {
                tail.next = x;
                x = x.next;
            } else {
                tail.next = y;
                y = y.next;
            }
            tail = tail.next;
        }
        tail.next = y != null ? y : x;
        tail = dummy.next;
        dummy.next = null;
        return tail;
    }


}
