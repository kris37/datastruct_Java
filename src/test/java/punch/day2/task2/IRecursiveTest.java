package punch.day2.task2;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-03-04 09:51
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class IRecursiveTest {

    @Test
    public void testFullArranged(){
        int [] nums = {1,1,3};
        List<List<Integer>> lists = IRecursive.fullyArranged(nums);
        System.out.print(lists.toString());
    }

}