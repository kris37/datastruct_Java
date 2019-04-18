package punch.day15.task;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-04-15 21:22
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     bitset 实现
 * <br>
 */
public class IBitSet {
    private int [] bytes;
    private int bits;
    public IBitSet(int bits){
        this.bits = bits;
        this.bytes = new int[(bits >> 5) + 1];
    }
    public void set(int bit){
        if(bit >= bits) return;
        int index = bit >> 5;
        int bitIndex = bit & ((1 << 5)-1);
        bytes[index] = bytes[index] | (1 << bitIndex);
    }

    public boolean getBit(int bit){
        //todo
        return true;
    }
}
