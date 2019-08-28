package unit;

import com.google.common.base.Throwables;
import org.junit.Test;

import java.util.Optional;

/**
 * @author hewei
 * throwables 搞
 */
public class ThrowableTest {
    @Test
    public void test() {
        try {
            Optional<Object> optional = Optional.of(null);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("=========");
            Throwable rootCause = Throwables.getRootCause(e);
            rootCause.printStackTrace();
            System.out.println("========");
            System.out.println(Throwables.getStackTraceAsString(e));
        }

    }
}
