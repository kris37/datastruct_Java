package punch.day2.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-07 17:48
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *
 * <br>
 */
public class Leetcode641_CircularDeque {

    /**
     *  实现一个双端队列
     *  CircularDeque
     *  固定大小
     *  head 和tail
     *  Runtime: 50 ms, faster than 98.26% of Java online submissions for Design Circular Deque.
     * Memory Usage: 39.9 MB, less than 12.20% of Java online submissions for Design Circular Deque.
     *
     */
   public static class MyCircularDeque {

       private int size;
       private int head = 0;
       private int tail = 0;
       private int [] array;
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            this.array = new int[k];
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if(isFull()) return false;
            size++;
            head = back(head);
            if(size == 1){
                tail = head;
            }
            array[head] = value;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if(isFull()) return false;
            size++;
            tail = forward(tail);
            if(size == 1){
                head = tail;
            }
            array[tail] = value;
            return true;

        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            assert size >= 0;
            if(size == 0) return false;

            size --;
            if(size == 0) return true;
            head = forward(head);
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {

            assert size >= 0;
            if(size == 0) return false;

            size --;
            if(size == 0) return true;
            tail = back(tail);
            return true;

        }

        /** Get the front item from the deque. */
        public int getFront() {
            if(size == 0) return -1;
            return array[head];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if(size == 0) return -1;
            return array[tail];

        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return size == 0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return size == array.length;
        }

        /**
         * % 效率堪忧
         * 前进一步
         * @param now
         * @return
         */
        private int forward(int now){

           // assert now >= 0;
            return (now + 1) % array.length;

        }

        /**
         * 退后一步
         * @param now
         * @return
         */
        private int back(int now){
            //assert now >= 0;
            if(now <=0){
                return array.length -1;
            }else {
                return now -1;
            }
        }

    }

}
