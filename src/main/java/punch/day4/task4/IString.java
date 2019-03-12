package punch.day4.task4;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-03-08 18:07
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     1. 实现 [a~z]字符集的  trie 树
 *     2.朴素字符串匹配算法
 * <br>
 */
public class IString {

    static class Node{
        private char[] array;
        private Node next;
        public Node(char [] array){
            this.array = array;
        }

    }

    static class ITrie{
        Node head = new Node(null);
        public ITrie(String [] list){
            for (String s : list) {
                char[] chars = s.toCharArray();
                Node cur = head;
                for (char c : chars) {
                    if(cur.next
                            == null){
                        Node node = new Node(new char[26]);
                        cur.next = node;
                    }
                    cur.next.array[c - 97] =c;
                    cur = cur.next;
                }
            }
        }
    }

    /**
     *
     * @param main
     * @param sub
     * @return sub in main  ?
     */
    public static boolean search(String main,String sub ){
        if(sub.length() > main.length()) return false;
        //todo dynamic match
        return true;
    }
}
