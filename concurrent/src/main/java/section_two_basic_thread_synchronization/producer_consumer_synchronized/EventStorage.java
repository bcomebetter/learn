package section_two_basic_thread_synchronization.producer_consumer_synchronized;

import java.util.Date;
import java.util.LinkedList;

/**
 * You have to keep checking the conditions and calling the wait() method
 * in a while loop.You can't continue until the condition is true.
 */
public class EventStorage {
    private int maxSize;
    private LinkedList<Date> storage;
    public EventStorage(){
        maxSize=10;
        storage=new LinkedList<>();
    }
    public synchronized void set(){
        while (storage.size()==maxSize){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.offer(new Date());
        System.out.println("Set:"+storage.size()+Thread.currentThread().getName());
        notifyAll();
    }
    public synchronized void get(){
        while (storage.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Get: %d: %s",storage.
                size(),storage.poll());
        System.out.println("Set:"+storage.size());
        notifyAll();
    }
}
