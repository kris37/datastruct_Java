package punch.day4.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-03-07 09:07
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *    读写锁
 * <br>
 */
public class ShareLock {

    ReadWriteLock rwlock = new ReentrantReadWriteLock();
    //读写锁共享锁

}
