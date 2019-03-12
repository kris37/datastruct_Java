package punch.day4.task4;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-08 09:48
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * 散列表
 * 1。（拉链法）|链表法解决冲突（HashMap 使用的解决方法）
 * 2。（开放地址法）|线性探测法（遇到冲突from  cur to end遍历 find first empty site）
 *  简易版实现，不实现扩容逻辑,不判断负载因子,链表不采用红黑树【JDK8采用红黑树】实现
 *  内容采用int
 * <br>
 */
public class IHashMap {
    private static class Node{
        private int k;
        private int v;
        private Node next  = null;
        public Node(int k ,int v){
            this.k = k;
            this.v = v;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (k != node.k) return false;
            return v == node.v;
        }

        @Override
        public int hashCode() {
            int result = k;
            result = 31 * result + v;
            return result;
        }
    }

    private Node[] array;
    private int size;

    public IHashMap(int cap){
        array =  new Node[cap];
    }

    public void put(int k ,int v){
        int index  = hash(k);
        if(array[index] == null){
            array[index] = new Node(k,v);
            size ++;
        }else {
            Node cur =  array[index];
            while (cur != null && cur.k != k ){
                cur = cur.next;
            }
            if(cur == null){
                //放在头部
                Node node = new Node(k, v);
                node.next = array[index];
                array[index] = node;
                size ++;
            }else {
                cur.v = v;
            }
        }
    }

    /**
     *  不存在则返回 -1
     *  否则返回 v
     * @param k
     * @return
     */
    public int get(int k){
        int index  = hash(k);
        Node cur = array[index];
        while (cur!=null && cur.k!=k){
            cur = cur.next;
        }
        if(cur == null) return -1;
        return cur.v;
    }

    /**
     *  不存在则返回 -1
     *  否则返回 v
     * @param k
     * @return
     */
    public int remove(int k){
        int index = hash(k);
        Node cur = array[index];
        Node pre = null;
        while (cur!=null && cur.k!= k){
            pre = cur;
            cur = cur.next;
        }
        if(cur ==null) return  -1;
        // remove 当前节点
       if(pre == null){
           array[index] = cur.next;
           cur.next = null;
           size--;
           return  cur.v;
       }else {
           size --;
           pre.next = cur.next;
           cur.next = null;
           return cur.v;
       }

    }

    private int hash(int v){
        return Math.abs(v) % array.length;
    }

    public int size(){
        return size;
    }




    public static void  main(String [] args){
        IHashMap iHashMap = new IHashMap(60);

        for (int i = 0; i < 1000; i++) {
            iHashMap.put(i,i);
        }
        System.out.println("size:"+iHashMap.size());
        for (int i = 0; i < 1000 ; i+=30) {
            System.out.println("get k:"+i +" is " +iHashMap.get(i));
            System.out.println("remove k :" + i + " v: "+iHashMap.remove(i));
            System.out.println(iHashMap.size());
        }
    }

}
