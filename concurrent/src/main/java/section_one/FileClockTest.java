package section_one;

import java.util.concurrent.TimeUnit;

/**
 * try-catch捕获异常后继续执行后面的代码,忽略try中的代码.
 * 当线程在睡眠时,中断线程会直接将睡眠线程唤醒,并抛出interruptedException,在此之后,线程执行run方法,
 * 直到run方法执行完成,
 */
public class FileClockTest {
    public static void main(String[] args) {
        FileClock clock = new FileClock();
        Thread thread = new Thread(clock);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
