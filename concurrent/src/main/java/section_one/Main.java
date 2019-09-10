package section_one;

/**
 * 线程中含有4个属性,id,name,priority(线程优先级),状态,其中,状态和id不可修改
 * 状态主要分为六种:new,runnable,blocked,waiting,time waiting or terminated,
 * 在new和terminated时,调用interrupt方法时,不会改变线程的状态值,在java中,处于此状态的线程没有必要去打断
 * 在runnable和blocked状态时,调用interrupt方法时,会改变线程状态的标识,将线程的被打断的状态值设为true
 * waiting,time waiting,调用interrupt方法时直接抛出interruptException,并重置线程状态为false
 * 在设置线程优先级的时候
 * 如果线程没有设置名称,那么jvm会自动为其生成名称
 * */
public class Main {
    public static void main(String[] args) {

        Thread threads[]=new Thread[10];
        Thread.State state[] = new Thread.State[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator(i));
            if (i%2==0){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            }{
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread"+i);
        }

        for (int i = 0; i < state.length; i++) {
            state[i] = threads[i].getState();
            System.out.println(threads[i].getName()+"现在线程的状态是:"+state[i]);
        }
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("aaa");
            }
        });
        thread.start();


        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }

        watchThread(threads,state);

        for (int i = 0; i < state.length; i++) {
            state[i] = threads[i].getState();
            System.out.println(threads[i].getName()+"现在线程的状态是:"+state[i]);

        }
    System.out.println(Thread.currentThread().getName());
    }
    public static void watchThread(Thread[] threads,Thread.State[] states){
        for (int i = 0; i < states.length; i++) {
            if (!threads[i].getState().equals(states[i])){
                states[i] = threads[i].getState();
            }
        }
    }
}
