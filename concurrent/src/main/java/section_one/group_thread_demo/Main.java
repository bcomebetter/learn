package section_one.group_thread_demo;

import java.util.concurrent.TimeUnit;

/**
 * 对于线程组来说, 可以通过线程组的interrupt方法将线程组中的线程全部打断.
 */
public class Main {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        Result result = new Result();
        SearchTask searchTask = new SearchTask(result);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(threadGroup, searchTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("number of Threads:"+threadGroup.activeCount());
        System.out.println("information about the thread group");
        //展示该线程组
        threadGroup.list();

        //将所有活跃的线程存放到线程数组中
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);

        for (int i=0; i<threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n",threads[i].
                    getName(),threads[i].getState());
        }

        waitFinish(threadGroup);
        threadGroup.interrupt();
    }
    private static void waitFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount()>9) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
