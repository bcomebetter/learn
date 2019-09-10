package section_one;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

/**
 * aim: learn the use of join() method of the Thread class with the initialization example
 *
 */
public class DataSourcesLoader implements Runnable {
    @Override
    public void run() {
        System.out.println("Beginning data source loading....");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Data source loading has finished:"+ LocalDate.now());
    }
}
