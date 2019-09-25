package section_two_basic_thread_synchronization.test_my_lock;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Product product = new Product(buffer);
        Consumer consumer = new Consumer(buffer);
        Thread thread = new Thread(product,"product1");
        Thread thread1 = new Thread(product,"product2");
        Thread thread2 = new Thread(consumer,"consumer");
        thread1.start();
        thread.start();
        thread2.start();
    }
}
