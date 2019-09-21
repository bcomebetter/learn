package section_one.join_demo;

import java.time.LocalDate;

/**
 * aim to test class below
 * @see  DataSourcesLoader
 * @see  NetworkConnectionsLoader
 * join()方法,可以在其中传递时间作为参数,当某一个线程中调用其他线程方法时
 * ,该线程阻塞固定时间或者等待其他线程执行完毕.
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
