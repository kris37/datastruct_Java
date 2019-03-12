package punch.day2.task2;

import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-03 18:57
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     队列
 * 1.用数组实现一个顺序队列
 * 2. 用链表实现一个链式队列
 * 3. 实现一个循环队列
 * <br>
 */
public class IQueue {
    /**
     * 1. 数组实现
     */
    public static class ArrayQueue{
        private int [] array;
        private int size = 0;
        public ArrayQueue(int cap){
            this.array = new int[cap];
        }

        public void  add(int value){
            // may out bounds
            array[size++] = value;
        }

        public int remove(){
            if(empty()){
                throw new ArrayIndexOutOfBoundsException("ArrayStack is empty");
            }
            int value = array[0];
            size --;
            if(size >0) System.arraycopy(array,1,array,0,size);
            return value;
        }

        public int size(){
            return size;
        }
        public boolean empty(){
            return size() == 0;
        }
    }

    /**
     * 2 实现链式队列
     */
    public static class ListQueue{
        private static class Node{
            Node next = null;
            int value;
            public Node(int value){
                this.value = value;
            }

        }
        private Node head;
        private Node tail;
        private int size;

        public void add(int value){
            Node node = new Node(value);
            if(tail == null){
                tail = node;
                head = tail;
            }else {
                tail.next = node;
                tail = tail.next;
            }
            size++;
        }
        public int remove(){
            if(empty()) throw new NoSuchElementException(" ListStack is empty");
            Node res = head;
            head = head.next;
            res.next = null;
            if(head ==null) tail = null;
            size --;
            return res.value;
        }

        public int size(){
            return size;
        }

        public boolean empty(){
            return size == 0;
        }
    }


    /**
     *  3。 实现循环队列
     *   定义一个固定大小的数组
     *   a) add 若数组满 则覆盖最早的插入元素
     */

    public static class CycleQueue{

        private int[] array;
        private int size = 0;
        private int head;
        private int tail;
        public CycleQueue(int cap){
            this.array = new int[cap];
        }
        public void add(int value){
            if(isFull()){
                head = cycleFoward(head);
            }else {
                size ++;
            }
            array[tail] =value;
            tail = cycleFoward(tail);

        }

        public int remove(){
            if(empty()) throw new NoSuchElementException("CycleQueue is empty!");
            int value = array[head];
            head = cycleFoward(head);
            size--;
            return value;
        }

        private int cycleFoward(int cur){
            return  (cur + 1) % array.length;
        }
        private boolean isFull(){
            return size == array.length;
        }

        public boolean empty(){
            return size == 0;
        }

    }
}
