package section_one;

import java.util.concurrent.TimeUnit;

public class FileSearchTest {
    public static void main(String[] args) {
        FileSearch fileSearch = new FileSearch("/Users", "redis-server");
        Thread task = new Thread(fileSearch);
        task.start();
        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }
}
