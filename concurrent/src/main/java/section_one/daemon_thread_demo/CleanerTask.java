package section_one.daemon_thread_demo;

import lombok.extern.slf4j.Slf4j;
import section_one.entity.Event;

import java.util.Date;
import java.util.Deque;


/**
 * You only can call the setDaemon() method before you call the start() method.
 * Once the thread is running, you can't modify its daemon status.
 * You can use the isDaemon() method to check if a thread
 * is a daemon thread (the method returns true) or
 * a user thread (the method returns false).
 */
public class CleanerTask extends Thread {
    private Deque<Event> deque;
    public CleanerTask(Deque<Event> deque) {
        this.deque = deque;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        long difference;
        boolean delete;
        if (deque.size()==0){
            return;
        }
        delete =false;
        do {
            Event event = deque.getLast();
            difference = date.getTime() - event.getDate().getTime();
            if (difference>10000){
                System.out.println("Cleaner:"+event.getEvent());
                deque.removeLast();
                delete=true;
            }
        }while (difference>10000);
        if (delete){
            System.out.println("Cleaner: Size of the queue:"+deque.size());
        }
    }
}
