package section_one;

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
