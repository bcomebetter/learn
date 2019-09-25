package section_two_basic_thread_synchronization.lock_reentrantLock;
/**
 * The ReentrantLock class also allows the use of recursive calls.
 * When a thread has the control of a lock and makes a recursive call,
 * it continues with the control of the lock, so the calling to the lock() method
 * will return immediately and the thread will continue with the execution of
 * the recursive call. Moreover, we can also call other methods.
 * there also provider tryLock() method,this method return false when fail to
 * obtain a lock, we can use it in if clause.
 */
public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue=new PrintQueue();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job(printQueue),"Thread"+i);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
