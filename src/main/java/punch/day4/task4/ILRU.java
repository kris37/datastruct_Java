package punch.day4.task4;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 *
 * @version punch
 * Date: 2019-03-08 13:34
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     LRU算法 LeastRecenntlyUnsed 最久未使用
 *
 *    可以参考实现 @link{java.util.LinkedHashMap}
 *    基于HashMap 在Node中加入 before,afer 指针进行处理
 *
 *
 *
 * <br>
 */
public class ILRU {

   private static class Node<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;
        Node<K,V> before;
        Node<K,V> after;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        @Override
        public final String toString() { return key + "=" + value; }

        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?, ?> node = (Node<?, ?>) o;
            if (!key.equals(node.key)) return false;
            if (!value.equals(node.value)) return false;
            return true;
        }
    }


    private Node head;
    private Node end;



    // 重要方法更新链表的顺序

    private Node unlink(Node cur){
        if(cur == null) return null;

        if(cur.next == null ||
                cur.before == null){

            if(cur.before == null
                    && cur.next == null){
                head = end = null;
            }else if(cur.before == null){
                // head 节点
                head = cur.next;
                head.before = null;
                cur.next = null;
            }else {
                //cur.end ==null
                end = cur.before;
                end.next = null;
                cur.before = null;
            }
            return cur;

        }else{
            // 中间节点
            Node  pre =  cur.before;
            Node next = cur.next;
            cur.before = null;
            cur.after = null;
            pre.next = next;
            next.before = pre;
            return cur;
        }

    }


}
