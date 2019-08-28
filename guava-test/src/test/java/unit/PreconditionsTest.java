package unit;


import com.google.common.base.Preconditions;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author hewei
 * method for asserting certain conditions you except variables
 *
 */
public class PreconditionsTest {

    @Test(expected = NullPointerException.class)
    public void checkNotNull() {
        Preconditions.checkNotNull(null);
    }

    @Test
    public void checkNotNullWithMessage() {
        try {
            Preconditions.checkNotNull(null,"猪股降了");
        } catch (Exception e) {
            assertThat(e.getMessage(),equalTo("猪股降了"));
        }
    }

    @Test
    public void testCheckArgument() {
        String type = "A";
        String type_b = "A";
        Preconditions.checkArgument(type.equals(type_b));
    }
}
