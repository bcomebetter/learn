package unit;

import com.google.common.collect.*;
import org.junit.Test;

public class MultimapTest {
    @Test
    public void test() {
        ArrayListMultimap<Object, Object> multimap = ArrayListMultimap.create();
        HashMultimap<String, String> hashMultimap = HashMultimap.<String, String>create();

    }
}
