package section_one.thread_demo;

/**
 * 一个java程序伴随着它的所有线程结束而结束(不包括守护线程),当一个线程结束时,其他线程仍然会继续执行,
 * 当其中的一个线程调用了System.exit()方法,所有的线程停止运行.调用线程实例的run()方法并不能开启一个线程,
 * 只有调用线程实例的start()方法才能开启一个新的线程
 */

public class Calculator implements Runnable {
    private int number;

    public Calculator(int number) {
        this.number = number;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"---"+number+"*"+i+"="+i*number);
        }
    }

    public static void main(String[] args) {
        //通过实现Runnable接口来创建新线程
        for (int i = 0; i < 10; i++) {
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
            //当i==5的时候,主线程调用System.exit()方法,程序结束
            if (i==5){
                System.exit(0);
            }
        }
        //通过集成Thread类重写run()方法来创建
        MyThread myThread = new MyThread(1);
        myThread.start();
    }
}
