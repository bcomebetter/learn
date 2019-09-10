package section_one;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

/**
 */
public class NetworkConnectionsLoader implements Runnable {
    @Override
    public void run() {
        System.out.println("Beginning network connection  loading....");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("network connection loading has finished:"+ LocalDate.now());
    }
}
