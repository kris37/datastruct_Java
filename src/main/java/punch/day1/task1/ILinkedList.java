package punch.day1.task1;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-02-28 16:42
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     1. 单向链表
 *     2. 循环链表
 *     3.双向链表
 *     支持增删操作 add() remove()
 *
 *     4.reverse SingleList
 *     5. merge
 *     6. linklist mid node
 * <br>
 */
public class ILinkedList {
     static class Node{
        Node next = null;
        int value;
        public Node(int value){
            this.value = value;
        }
    }

     static class DNode extends Node{
        Node bef = null;
        public DNode(int value) {
            super(value);
        }
    }

    /**
     *  1 SingleLinkedList
     */

    public static class SingleList {

        private int size = 0;
        private Node head = null;
        private Node tail = null;
        public void add( int node){
            if(head == null){
                head = new Node(node);
                tail = head;
            }else{
                tail.next = new Node(node);
                tail = tail.next;
            }
            size++;
        }
        public Node removeFirst(){
            if (head == null) return null;

            Node node = head.next;
            head = head.next;
            if(head ==null) tail = null;
            size--;
            return node;
        }

        public Node getHead() {
            return head;
        }

        /**
         * 4 单链表反转
         */
        public void reverse(){
            tail  = head;
            head = reverseByRecursive(head,null);
        }
        private static Node reverseByRecursive(Node head,Node pre){
            if(head.next == null){
                head.next = pre;
                return head;
            }
            Node next = head.next;
            head.next = pre;

            return reverseByRecursive(next,head);
        }
        private static Node reverseByLoop(){
            //todo by loop
            return null;
        }

        /**
         * 5 merge 有序链表
         */
        public static Node sortedListMerge(Node a, Node b){
            Node dummy = new Node(0);
            Node tail = dummy;
            while (a !=null || b !=null){
                if(cmp(a,b) == 0){

                    tail.next = a;
                    a = a.next;
                }else {
                    tail.next = b;
                    b = b.next;
                }
                tail = tail.next;
            }
            return dummy.next;
        }

        private static  int cmp(Node x, Node y){
           if(x ==null || y ==null){
               return x==null?1:0;
           }else{
               return x.value <= y.value?0:1;
           }
        }
        /**
         * 6 findMid
         * double pointer
         */
        public static Node findMid(Node node){
            if(node == null|| node.next == null){
                return node;
            }
            //
            Node quick = node;
            Node slow = node;
            while (quick !=null && quick.next!=null){
                quick = quick.next.next;
                slow = slow.next;
            }
            return slow;
        }

    }

}
