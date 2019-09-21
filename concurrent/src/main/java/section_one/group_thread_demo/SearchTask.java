package section_one.group_thread_demo;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SearchTask implements Runnable {
    private Result result;

    public SearchTask(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("当前开始的线程名称为"+name);
        try {
            doTask();
            result.setName(name);
        } catch (Exception e) {
            System.out.println("Thread:"+name+"Interrupted.");
        }
        System.out.println("Thread:"+name+"end.");
    }

    private void doTask() throws InterruptedException {
        Random random = new Random(new Date().getTime());
        int value = (int) (random.nextDouble() * 100);
        System.out.println("Thread:"+Thread.currentThread().getName()+":"+value);
        TimeUnit.SECONDS.sleep(value);
    }

}
