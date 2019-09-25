package section_two_basic_thread_synchronization.producer_consumer_lock_demo;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * newCondition意味着在reentrantLock的基础上重新建立器两个队列,在线程调用某个condition的
 * await()方法时,会将该线程挂在此队列中,并同时释放reentrantLock,当其他线程调用该condition
 * 的signal()方法或者signalAll()方法时,会将此线程中的线程唤醒,
 * 在读写锁中,同时可以使用condition.
 * {@link ReentrantLock}
 */
public class Buffer {
    private LinkedList<String> buffer;
    private int maxSize;
    private ReentrantLock lock;
    private Condition lines;
    private Condition space;
    private boolean pendingLines;

    public Buffer(int maxSize) {
        this.maxSize=maxSize;
        buffer=new LinkedList<>();
        lock=new ReentrantLock();
        lines=lock.newCondition();
        space=lock.newCondition();
        pendingLines=true;
    }
    public void insert(String string){
        lock.lock();
        try {
        while (buffer.size()==maxSize){
            space.await();
        }
        buffer.offer(string);
        System.out.printf("%s: Inserted Line: %d\n", Thread.currentThread().getName(),buffer.size());
        lines.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public String get(){
        lock.lock();
        String line =null;
        try {
            while ((buffer.size() == 0) &&(hasPendingLines())){
                lines.await();
            }
            if (hasPendingLines()) {
                line = buffer.poll();
                System.out.printf("%s: Inserted Line: %d\n", Thread.
                        currentThread().getName(),buffer.size());
                space.signalAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return line;
    }
    public void setPendingLines(boolean pendingLines) {
        this.pendingLines=pendingLines;
    }
    public boolean hasPendingLines() {
        return pendingLines || buffer.size()>0;
    }
}
