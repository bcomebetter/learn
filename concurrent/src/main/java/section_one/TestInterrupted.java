package section_one;

/**
 * 线程里面存了一个是否被打断的属性,默认值为false,如果调用线程interrupt()方法,会将该值设置为true,
 * 再根据isInterrupted()方法的返回值 ,可以将线程中断
 */
public class TestInterrupted {
  public static void main(String[] args) {
    //测试中断一个正在进行的线程
    Thread task = new PrimeGenerator();
    task.start();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    task.interrupt();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}
