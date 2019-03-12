package punch.day2.task2;

import org.junit.Test;


/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-03-03 19:49
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class IQueueTest {

    @Test
    public void testArrayQueue(){
        IQueue.ArrayQueue arrayQueue = new IQueue.ArrayQueue(64);
        for (int i = 0; i < 64 ; i++) {
            arrayQueue.add(i);
        }
        while (!arrayQueue.empty()) {
            System.out.print(arrayQueue.remove() + " -> ");
        }
    }


    @Test
    public void testListQueue(){
        IQueue.ListQueue listQueue = new IQueue.ListQueue();

        for (int i = 0; i < 64 ; i++) {
            listQueue.add(i);
        }
        while (!listQueue.empty()) {
            System.out.print(listQueue.remove() + " -> ");
        }
    }


    @Test
    public void testCycleQueue(){
        IQueue.CycleQueue cycleQueue = new IQueue.CycleQueue(16);


        for (int i = 0; i < 64 ; i++) {
            cycleQueue.add(i);
            if(i >0 && i % 13 == 0){
                while (!cycleQueue.empty()) {
                    System.out.print(cycleQueue.remove() + " -> ");
                }
                System.out.println(" -> ");
            }
        }

        while (!cycleQueue.empty()) {
            System.out.print(cycleQueue.remove() + " -> ");
        }

    }




}