package section_two_basic_thread_synchronization.test_my_lock;



public class Product implements Runnable {
    private Buffer buffer;

    public Product(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            buffer.setDate();
        }
    }
}
