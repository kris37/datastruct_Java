package punch.day14.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     reverse k groups
 * <br>
 */
public class Leetcode25_ReverseNodesKGroup {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head,curStart = head,curEnd = null,lastEnd = null,newHead = head;
        boolean first = true;
        int count = 0;
        while (cur != null){
            curStart = cur;
            count = 0;
            while (count < k && cur != null){
                count ++;
                curEnd = cur;
                cur = cur.next;
            }
            if(count < k){
              if(lastEnd != null) lastEnd.next = curStart;
              break;
            }
            // process
            curEnd.next = null;
            reverse(curStart);// 翻转 首位调换
            if(first){
                newHead = curEnd;
                first = false;
            }
            if(lastEnd != null) lastEnd.next = curEnd;
            lastEnd = curStart;
        }
        return newHead;
    }


    /**
     *
     * @param node
     * @return new head
     */
    private ListNode reverse(ListNode node){
        ListNode cur = node,pre = null;
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