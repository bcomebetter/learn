package unit;


import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

public class FutureTest {
    // 创建线程池
    final static ExecutorService service = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Long t1 = System.currentTimeMillis();

        // 任务1
        Future<Boolean> booleanTask = service.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return true;
            }
        });

        while (true) {
            if (booleanTask.isDone() && !booleanTask.isCancelled()) {
                //模拟耗时
                Thread.sleep(500);
                Boolean result = booleanTask.get();
                System.err.println("BooleanTask: " + result);
                break;
            }
        }

        // 任务2
        Future<String> stringTask = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello World";
            }
        });

        while (true) {
            if (stringTask.isDone() && !stringTask.isCancelled()) {
                String result = stringTask.get();
                System.err.println("StringTask: " + result);
                break;
            }
        }


        // 任务3
        Future<Integer> integerTask = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        });

        while (true) {
            if (integerTask.isDone() && !integerTask.isCancelled()) {
                Integer result = integerTask.get();
                System.err.println("IntegerTask: " + result);
                break;
            }
        }

        // 执行时间
        System.err.println("time: " + (System.currentTimeMillis() - t1));
    }

    @Test
    public void test() {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));


    }
    class FallbackDemo implements FutureCallback<String>{

        @Override
        public void onSuccess(String result) {

        }

        @Override
        public void onFailure(Throwable t) {

        }
    }

    @Test
    public void testTry() {
        try {
            try {
                int i = 1/0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e) {

        }
        System.out.println("ssss");
    }
}
