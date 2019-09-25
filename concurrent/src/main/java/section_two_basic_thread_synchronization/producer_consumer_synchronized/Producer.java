package section_two_basic_thread_synchronization.producer_consumer_synchronized;

public class Producer implements Runnable {
    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++){
            storage.set();
        }
    }
}
