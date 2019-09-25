package section_two_basic_thread_synchronization.test_my_lock;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class MyLock extends ReentrantLock {
    private volatile int state = 0;
    private Deque<Thread> threadDeque = new ArrayDeque<>();

    public void  lock(){
        int state = getState();
        if (threadDeque.size()!=0||!cas(state,1)){
            threadDeque.addFirst(Thread.currentThread());
            LockSupport.park();
        }
    }
    public void unlock(){
        state = 0;
        //唤醒线程
        if (threadDeque.size()>0)
        LockSupport.unpark(threadDeque.getFirst());
    }

    private  boolean cas(int a, int i) {
        if (a==0){
            state=i;
            return true;
        }
        return false;
    }
}
