package punch.day1.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-06 17:55
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     合并 k个有序链表
 * <br>
 */
public class Leetcode23_MergeKLists {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {

        // 优先队列 k 大小的 进行push pop
        // 时间复杂度 n*lgK
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        // 将每个 head 入堆
        for (ListNode node : lists) {
            if(node != null) queue.add(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (queue.size() > 0){
            ListNode poll = queue.poll();
            tail.next = poll;
            tail = tail.next;
            if(poll == null) continue;
            queue.add(poll.next);
        }
        return dummy.next;
        //

    }
}
