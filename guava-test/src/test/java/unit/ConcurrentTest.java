package unit;

import com.google.common.util.concurrent.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.concurrent.*;

/**
 * 想尝试测试异步回调的事物回滚,失败了
 *
 */
public class ConcurrentTest {
    @Test
    public void test() throws ExecutionException, InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(10);
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(pool);
        ListenableFuture<String> submit = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    int i = 1/0;
                } catch (Exception e) {
                    throw e;
                }
                return "aaa";
            }
        });
        Futures.addCallback(submit,new CallbackDemo(),pool);
        System.err.println(submit.get());

    }

    class CallbackDemo implements FutureCallback<String>{

        @Override
        public void onSuccess(String result) {
            System.out.println("bbb");
        }

        @Override
        public void onFailure(Throwable t) {
            System.out.println("ccx");
        }
    }

}
