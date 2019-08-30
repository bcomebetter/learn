package unit;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hewei
 * ordering类测试
 * 该类实现了Comparator接口,主要是作为一个比较器,类中提供了按一定规则取排完续后的集合中得元素的方法,如:取最后几位等..
 */
public class OrderingTest {
    private final List<String> strings = Lists.newArrayList(
            "google","guava","java","zhushuangshuang","hewei"
    );
    @Test
    public void testNatural() {
//        ComparisonChain.start().
        //order产生的是一个比较器!!
        ArrayList<Integer> numbers = Lists.newArrayList(1, 2, 3, 4, 5, 22, 33, 44, 2, 4, 3, 5, 2);
        Ordering<Comparable> natural = Ordering.natural();
        Collections.sort(strings,natural);
        for (String s : strings) {
            System.err.println(s);
        }
    }

    @Test
    public void testNulls() {
        ArrayList<Integer> numbers = Lists.newArrayList(null,1, 2, 3, 4, 5, 22,null, 33, 44, 2, 4, 3, 5, 2);

        Ordering<Comparable> natural = Ordering.natural();
        Ordering<Comparable> nullFirst = natural.nullsFirst();
        Ordering<Comparable> nullsLast = natural.nullsLast();
        Collections.sort(numbers,nullFirst);
        for (Integer number : numbers) {
            System.err.println(number);
        }
        System.err.println("=================");
        Integer min = nullsLast.min(3,4);
        Integer min1 = nullsLast.reverse().min(3, 5,4);
        System.out.println(min);
        System.out.println(min1);
        List<Integer> integers = nullsLast.greatestOf(numbers, 3);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
        Collections.sort(numbers,nullsLast);
        for (Integer number : numbers) {
            System.err.println(number);
        }
    }
}
