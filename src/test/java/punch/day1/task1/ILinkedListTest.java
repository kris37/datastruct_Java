package punch.day1.task1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-02-28 18:12
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class ILinkedListTest {
    @Test
    public void testSingleListReverse(){
        ILinkedList.SingleList singleList = new ILinkedList.SingleList();

        for (int i = 0; i < 20; i++) {
            singleList.add(i);
        }

        singleList.reverse();
        ILinkedList.Node head = singleList.getHead();

        while (head !=null){
            System.out.print(head.value +"->");
            head = head.next;
        }


    }

    @Test
    public void testSortedListMerge(){
        ILinkedList.SingleList a = new ILinkedList.SingleList();
        ILinkedList.SingleList b = new ILinkedList.SingleList();
        for (int i = 0; i < 20; i++) {
            a.add(i);
        }

        ILinkedList.Node mid = ILinkedList.SingleList.findMid(a.getHead());
        System.out.println(mid.value);

        for (int i = -2; i < 50; i+=2) {
            b.add(i);
        }

        ILinkedList.Node node = ILinkedList.SingleList.sortedListMerge(a.getHead(), b.getHead());

        while (node !=null){
            System.out.print(node.value + "->");
            node = node.next;
        }




    }

}