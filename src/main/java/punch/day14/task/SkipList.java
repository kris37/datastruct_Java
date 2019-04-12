package punch.day14.task;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-04-11 21:46
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class SkipList {
    public static class Node{

        int key;
        Node next;
        Object value;

        public Node(int key, Object value,Node next) {
            this.key = key;
            this.next = next;
            this.value = value;
        }

        public Node(int key, Object value) {
           this(key,value,null);
        }

    }

    /**
     *  index 节点 存储 node 指针，节省数据空间
     */
    private static class IndexNode{
        Node node;
        IndexNode right;
        IndexNode down;

        public IndexNode(Node node, IndexNode right, IndexNode down) {
            this.node = node;
            this.right = right;
            this.down = down;
        }

    }

    /**
     *  第一列 哨兵节点
     */
    private final static class HeadIndexNode extends IndexNode{
        final int levels;
        public HeadIndexNode(Node node, IndexNode right, IndexNode down, int levels) {
            super(node, right, down);
            this.levels = levels;
        }
    }

    //这里是指索引层,而数据层是在 0 层
    private static int MAXLEVEL = 8;
    // 所有 headindexNode中的 node 节点是null 节点即 HeadIndexNode.node =  null
    private HeadIndexNode head = new HeadIndexNode(null,null,null,0);


    /****             insert                      **/
    public void insert(int key,Object value){
        IndexNode pre = findPredecesserIndex(key);
        IndexNode cur = pre.right;
        if(cur != null && cur.node.key == key){
            //update
            cur.node.value = value;
            return;
        }
        //insert into pre.next
        // setNode
        Node node = new Node(key,value,cur == null?null:cur.node);
        if(pre.node != null) pre.node.next = node;
        // get level and setIndex
        int level = getLevels();
        setIndex(level,node);
    }

    private void setIndex(int level,Node node){
        assert node != null;
        if(head.levels < level){
            // 需要 提高层数
            for (int i = head.levels + 1 ; i <= level ; i++) {
               head = new HeadIndexNode(null,null,head,i);
            }
        }
        // 插入索引 from head to level 0
        IndexNode h = head,r ,preUp =null ;
        for (int i = head.levels; i >= 0 ; i--) { //
            r = h.right;
            while (r != null && r.node.key < node.key) {
                h = r;
                r = h.right;
            }
            if(i > level){
                h = h.down;
                continue;
            }
            //
            IndexNode insert = new IndexNode(node, r, null);
            if(preUp != null) preUp.down = insert;
            preUp = insert;
            h.right = insert;
            h = h.down;
        }


    }


    /******** search ************/
    public Object search(int key){
        IndexNode p = head,r;
        for (;;){
            r = p.right;
            while (r != null && r.node.key < key){
                p = r;
                r = p.right;
            }
            if(r != null && r.node.key == key){
                return r.node.value;
            }
            //
            p = p.down;
            if(p == null) return null;
        }

    }


    /**
     * @return 随机数获取最高层数
     */
    public static int getLevels(){
        // 这里 设定 1/2^3 的概率晋升 1/8
        int level = 0;
        while (level < MAXLEVEL) {
            int rnd = ThreadLocalRandom.current().nextInt();
            // a &(-a) 查找最后一位的 1 ,= 0 概率为 1/2 => = 4 概率为 1/8
            if((rnd & (-rnd)) == 4){
                level ++;
            }else {
                break;
            }
        }
        return level;
    }

    /**
     * 查找 < Node 节点的 最后一个IndexNode （maybe HeadIndexNode）
     * @param key
     * @return < key 的最后一个节点IndexNode
     */
    private IndexNode findPredecesserIndex(int key){

        IndexNode p = head,r = p.right;

        for (;;){
            while (r != null && r.node.key < key) {
                p = r;
                r = p.right;
            }
            if(p.down == null){
                // 如果p 是 第一层
                return p;
            }
            p = p.down;
            r = p.right;
        }

    }




















}
