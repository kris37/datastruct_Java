package punch.day2.task2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-03-03 19:12
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *
 * <br>
 */
public class IStackTest {

    @Test
    public void testArrayStack(){
        IStack.ArrayStack arrayStack = new IStack.ArrayStack(64);
        for (int i = 0; i < 64 ; i++) {
            arrayStack.push(i);
        }
        while (!arrayStack.empty()) {
            System.out.print(arrayStack.pop() + " -> ");
        }
    }
    @Test
    public void testListStack(){
        IStack.ListStack listStack = new IStack.ListStack();
        for (int i = 0; i < 64 ; i++) {
            listStack.push(i);
        }
        while (!listStack.empty()) {
            System.out.print(listStack.pop() + " -> ");
        }

    }
}