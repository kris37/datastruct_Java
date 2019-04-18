package punch.day16.task;

import sun.misc.Contended;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-04-16 16:40
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     CAS queue
 *     Contended 避免cahce line 伪共享内存
 * <br>
 */

@Contended
public class CASQueue {


    private volatile long head ,tail, cur = 0L;
    private final int length;

    private Object [] queue ;

    public CASQueue(int size) {
        // length 必须为 2 ^ N
        this.length = (size & (-size)) << 1;
        this.queue = new Object[this.length];
    }

    /**
     *  模拟实现cas
     * @param now
     * @param old
     * @param update
     * @return
     */
    private synchronized boolean  ICAS(Object now,Object old,Object update){
            if(now == old){
                now = update;
                return true;
            }
            return false;
    }

    private long getNext(){
        long p,update;
        do {
            p = this.tail;
            update = p + 1;
        }while (!ICAS(tail,p,update));
        return p;

    }

    public boolean enQueue(Object obj){
        long in = getNext(),now = in -1 ;
        // 先入队 ，再更新 cur ,cur 是 整个队列读写的边界
        queue[(int)(in&(length -1))] = obj;
        // 可以更新 cur 了
        // cur 每次只 +1 只有 in = cur + 1 才可以更新 cur 避免其他入队的数据 更新到自己的
        for (;!ICAS(cur,now,in);){

        }
        return true;
    }

}
