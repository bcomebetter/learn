package section_two_basic_thread_synchronization.producer_consumer_lock_demo;

public class Producer implements Runnable {
    private FileMock mock;
    private Buffer buffer;
    public Producer (FileMock mock, Buffer buffer){
        this.mock=mock;
        this.buffer=buffer;
    }
    @Override
    public void run() {
        buffer.setPendingLines(true);
        while (mock.hasMoreLines()){
            String line = mock.getLine();
            buffer.insert(line);
        }
        buffer.setPendingLines(false);
    }
}
