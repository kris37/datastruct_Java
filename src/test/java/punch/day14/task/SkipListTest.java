package punch.day14.task;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-04-12 11:11
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class SkipListTest {
    @Test
    public void testGetLevels(){

        HashMap<Integer, Integer> map = new HashMap<>(16);

        for (int i = 0;i < 8000000;i++) {
            map.merge(SkipList.getLevels(),1,(oldValue,newValue) -> oldValue + newValue );
        }
        System.out.println(map);
    }

    @Test
    public void TestSkipList() throws InterruptedException {
        SkipList skipList = new SkipList();

        for (int i = 0;i < 10000000;i+=2) {
            skipList.insert(i, i);
        }

        for (int i = 0; i < 4000 ; i++) {
            if((i&1) == 0){
                Assert.assertEquals(skipList.search(i),i);
            }else {
                Assert.assertEquals(skipList.search(i),null);
            }

        }
    }

}