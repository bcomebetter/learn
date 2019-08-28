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
    @Autowired
    private PlatformTransactionManager platformTransactionManager;
    @Test
    public void test() {

        TransactionStatus transaction = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
        ExecutorService pool = Executors.newFixedThreadPool(10);
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(pool);
        ListenableFuture<TransactionStatus> submit = executorService.submit(new CallableDemo(transaction));
        Futures.addCallback(submit,new CallbackDemo(),pool);

    }
    class CallableDemo implements Callable<TransactionStatus>{

        private TransactionStatus transactionStatus;

        CallableDemo(TransactionStatus transactionStatus) {
            this.transactionStatus = transactionStatus;
        }

        public TransactionStatus call() throws Exception {
            return transactionStatus;
        }
    }
    class CallbackDemo implements FutureCallback<TransactionStatus>{

        public void onSuccess(TransactionStatus transactionStatus) {

            platformTransactionManager.commit(transactionStatus);

        }

        public void onFailure(Throwable t) {
            System.err.println("hewei");
        }
    }

}
