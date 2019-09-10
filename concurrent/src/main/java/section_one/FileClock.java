package section_one;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class FileClock implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(LocalDate.now());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("this thread has been interrupted");
            }
        }
    }
}
