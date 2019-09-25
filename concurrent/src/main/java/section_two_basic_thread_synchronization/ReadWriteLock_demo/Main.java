package section_two_basic_thread_synchronization.ReadWriteLock_demo;

/**
 * Class ReadWriteLock offer readLock() and writer writerLock() method which can sign
 * operation read and write. 当写入锁中没有线程执行时,读取锁可以进行多线程同时读取,当写入锁
 * 中有线程运行时,读取锁中的代码块会阻塞直至写入锁中操作完成.
 * 当读取锁存在于多处时,一处多线程同时执行读取操作好像会阻塞别处呢?
 *
 * 锁机制的公平性问题:
 * The constructor of the ReentrantLock and ReentrantReadWriteLock classes admits
 * a boolean parameter named fair that allows you to control the behavior of both classes. The false value is the
 * default value and it's called the non-fair mode. In this mode, when there are some threads waiting for a lock
 * (ReentrantLock or ReentrantReadWriteLock) and the lock has to select one of them to get the access to the critical
 * section, it selects one without any criteria. The true value is called the fair mode. In this mode, when there are
 * some threads waiting for a lock (ReentrantLock or ReentrantReadWriteLock) and the lock has to select one to get
 * access to a critical section, it selects the thread that has been waiting for the most time. Take into account
 * that the behavior explained previously is only used with the lock() and unlock() methods. As the tryLock() method
 * doesn't put the thread to sleep if the Lock interface is used, the fair attribute doesn't affect its functionality.
 */
public class Main {
    public static void main(String[] args) {
        PricesInfo pricesInfo = new PricesInfo();
        Reader[] readers = new Reader[5];
        Thread[] threadsReader = new Thread[5];
        for (int i=0; i<5; i++){
            readers[i]=new Reader(pricesInfo);
            threadsReader[i]=new Thread(readers[i]);
        }
        Writer writer = new Writer(pricesInfo);
        Thread thread1 = new Thread(writer, "writer");
        for (int i=0; i<5; i++){
            threadsReader[i].start();
        }
        thread1.start();
    }
}
