package punch.day2.task2;

import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-03 15:47
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     1. 基于数组实现顺序栈
 *     2.用链表实现一个链式栈
 *     3.编程模拟实现一个浏览器的前进、后退功能
 *
 * <br>
 */
public class IStack {


    /**
     *  1. 不包含实现栈的自动扩容
     *   简易实现，创建时完成容量设定
     *   不处理异常
     */
    public static class ArrayStack{
        private int [] array;
        private int index = -1;
        public ArrayStack(int cap){
            this.array = new int[cap];
        }

        public void  push(int value){
            // may out bounds
            array[++index] = value;
        }

        public int pop(){
            if(empty()){
                throw new ArrayIndexOutOfBoundsException("ArrayStack is empty");
            }
            index -- ;
            return array[index+1];
        }

        public int size(){
            return index+1;
        }
        public boolean empty(){
            return size() == 0;
        }
    }

    /**
     * 2.基于链表实现
     * 包含方法如上
     */
    public static class ListStack{
        private static class Node{
            Node next = null;
            int value;
            public Node(int value){
                this.value = value;
            }

        }
        private Node head;
        private int size;

        public  ListStack(){
        }

        public void push(int value){
            Node node = new Node(value);
            node.next = head;
            head = node;
            size++;
        }
        public int pop(){
            if(empty()) throw new NoSuchElementException(" ListStack is empty");
            Node res = head;
            head = head.next;
            res.next = null;
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
     *  3 模拟实现浏览器前进后退
     *   思路 两个 stack
     *   stack a 不断push 浏览器访问的路径
     *   当 执行 back 函数 cur = a.pop() && b.push(cur)
     *   执行 前进 cur = b.pop() && a.push(cur)
     */


}
