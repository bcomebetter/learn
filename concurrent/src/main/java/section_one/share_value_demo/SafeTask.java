package section_one.share_value_demo;


import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable {
    // TODO: 2019-09-18 这里new Date()多次创建对象??匿名内部类得多次初始化??
    private static ThreadLocal<Date> startDate= new
            ThreadLocal<Date>() {
                protected Date initialValue(){
                    return new Date();
                } };
    @Override
    public void run() {
        System.out.printf("Starting Thread: %s : %s\n",Thread.
                currentThread().getId(),startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n",Thread.
                currentThread().getId(),startDate.get());
    }

}
