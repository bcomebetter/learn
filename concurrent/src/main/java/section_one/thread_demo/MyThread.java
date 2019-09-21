package section_one.thread_demo;

public class MyThread extends Thread {
    private int number;

    public MyThread(int number) {
        this.number = number;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"---"+number+"*"+i+"="+i*number);
        }
    }
}
