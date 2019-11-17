package section_two_basic_thread_synchronization.test_my_lock;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.concurrent.locks.LockSupport;

@Data
public class MyLock {
    private volatile int state = 0;
    private Deque<Thread> threadDeque ;

    public void  lock(){
        int state = getState();
        if (threadDeque.size()!=0||!cas(state,1)){
            if (Objects.isNull(threadDeque)){
                threadDeque = new ArrayDeque<>();
            }
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
