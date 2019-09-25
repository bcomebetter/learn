package section_two_basic_thread_synchronization.producer_consumer_lock_demo;

public class Main  {
    public static void main(String[] args) {
        FileMock fileMock = new FileMock(100, 10);
        Buffer buffer = new Buffer(20);
        Producer producer = new Producer(fileMock, buffer);
        Thread threadProduct = new Thread(producer, "Producer");
        Consumer[] consumers = new Consumer[3];
        Thread[] productThreads = new Thread[3];
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new Consumer(buffer);
            productThreads[i] = new Thread(consumers[i],"consumer"+i);
        }
        threadProduct.start();
        for (int i=0; i<3; i++){
            productThreads[i].start();
        }
    }
}
