package section_one;

import java.util.concurrent.TimeUnit;

public class FileClockTest {
    public static void main(String[] args) {
        FileClock clock = new FileClock();
        Thread thread = new Thread(clock);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
