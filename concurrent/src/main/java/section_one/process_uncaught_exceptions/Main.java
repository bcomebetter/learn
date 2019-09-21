package section_one.process_uncaught_exceptions;

/**
 * 关于遇到exception时,线程怎么继续跑的问题
 */
public class Main {
    public static void main(String[] args) {
        MyThreadGroup threadGroup = new MyThreadGroup("myThreadGroup");
        Task task = new Task();
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(threadGroup, task);
            thread.start();

        }
    }
}
