package section_two_basic_thread_synchronization.producer_consumer_synchronized;


import com.sun.tools.javac.comp.Todo;

/**
 * notify()是唤醒这个锁对象监视器中挂起的线程,wait()是将当前线程挂起到当前锁对象的监视器上
 */
public class Main {
    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);
        // TODO: 2019-09-21 当一个对象锁的监视器上挂起了多个线程时,调用notifyAll会出现错误,应该使用自旋的方式决定是否挂起,
        // TODO: 2019-09-23 当线程被唤醒且重新获取锁对象时,会自旋判断是否满足条件决定是否要继续等待.
        Thread thread = new Thread(producer,"线程1");
        Thread thread2 = new Thread(producer,"线程2");
        Thread thread1 = new Thread(consumer);
        thread.start();
        thread1.start();
        thread2.start();
    }
}
