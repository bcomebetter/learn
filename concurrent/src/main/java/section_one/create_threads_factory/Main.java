package section_one.create_threads_factory;


public class Main {
    public static void main(String[] args) {
        MyThreadFactory factory = new MyThreadFactory("myThreadFactory");
        Task task = new Task();
        Thread thread;
        System.out.println("Starting the Threads");
        for (int i = 0; i < 10; i++) {
            thread = factory.newThread(task);
            thread.start();
        }
        System.out.println("factory stats:"+factory.getStatus());
        System.out.println(factory.getCounter());
    }
}
