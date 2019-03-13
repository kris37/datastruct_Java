package punch.day3.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * @version punch
 * Date: 2019-03-13 09:21
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *    数据流中的中位数 动态算法
 *    或者变种 求 n% 的数据
 *    max(maxheap) <= min(minheap) and 0 <= maxheap.size() - minheap.size() <= 1;
 *    思路 maxheap 保存 if n 是偶数 n & 1 == 0
 *        minheap
 * <br>
 */
public class leetcode295_MedianDataStream {
    private PriorityQueue<Integer> maxHeap
            = new PriorityQueue<Integer>(Collections.reverseOrder());

    private PriorityQueue<Integer> minHeap
            = new PriorityQueue<Integer>();
    private int total = 0;

    /** initialize your data structure here. */
    public leetcode295_MedianDataStream() {

    }

    public void addNum(int num) {
        if(maxHeap.size()
                - minHeap.size()  == 0){
            // 加入到大顶堆,num 判断是否 <= min(minHeap)
            if(minHeap.size() ==0
                    || num <= minHeap.peek()){
                maxHeap.add(num);
            }else {
                //
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }

        }else {
            // 加入到小顶堆
            if(maxHeap.peek() <= num){
                minHeap.add(num);
            }else {
                // move maxHeap max to minHeap
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }

        }
        total++;
    }

    public double findMedian() {
        return (total & 1) == 0 ? (maxHeap.peek() + minHeap.peek())/2.0d : maxHeap.peek().doubleValue();
    }


}
