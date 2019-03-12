package punch.day1.task1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-02-27 17:17
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class IArrayTest {
    @Test
    public void testArrayGrow(){
            IArray.IArrayList<Integer> ilist = new IArray.IArrayList<Integer>();

            for (int i = 0; i < 100 ; i++) {
                ilist.add(i);
                System.out.println("input i "+ilist.size());
            }
            ilist.set(200,200);
            System.out.println(" "+ilist.size());
            System.out.println(ilist.get(160));
    }
    @Test
    public void testSortedArray(){
        IArray.FixSortedArray fixSortedArray = new IArray.FixSortedArray(10);

        int [] array = {10,1,2,5,3,4,9,7,11,15,8,16,0};
        for (int i : array) {
            //System.out.println("nums "+i);
            fixSortedArray.insert(i);
            System.out.println(fixSortedArray.toString());
        }

    }

    @Test
    public void testMerge(){
        int [] a = {0,1,2,3,3,4,4,5,5,6,7,7,8};
        int [] b = {0,3,4,5,6,7,8,9,9,9,10,11,12};
        int[] ints = IArray.mergeSortedArray(a, b);
        for (int anInt : ints) {
            System.out.print(anInt + "->");
        }
    }

}