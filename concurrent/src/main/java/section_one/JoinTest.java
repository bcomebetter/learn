package section_one;

import java.time.LocalDate;

/**
 * aim to test class below
 * @see  DataSourcesLoader
 * @see  NetworkConnectionsLoader
 */
public class JoinTest {
    public static void main(String[] args) {
        DataSourcesLoader dsLoader = new DataSourcesLoader();
        Thread dsThread = new Thread(dsLoader, "DataSourcesLoader");
        NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
        Thread ncThread = new Thread(ncLoader, "NetworkConnectionsLoader");
        ncThread.start();
        dsThread.start();

        try {
            dsThread.join();
            ncThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main: Configuration has been loaded :"+ LocalDate.now());
    }
}
