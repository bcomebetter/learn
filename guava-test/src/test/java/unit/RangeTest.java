package unit;

import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import org.junit.Test;

/**
 * @author hewei
 * 区间比较器,传入参数为继承了Comparable接口的对象,想改区间比较器中传入比较对象的上线和下线,
 * 从而进行区间内几乎可以想到的比较操作,例如:用户收藏一件商品,当商品的价格在此区间之内,进行相
 * 应的提醒,那么就可以根据用户传入的区间的商品的浮动价格进行比较
 */
public class RangeTest {

    @Test
    public void test() {
        //判断
        Range<Integer> range = Range.closed(0, 9);
        System.out.println(range);
        System.err.println(range.contains(5));
        System.err.println(range.contains(10));
        System.err.println(range.containsAll(Lists.newArrayList(1, 2, 3, 2, 4, 1, 2, 3)));
        System.err.println(range.lowerEndpoint());
        System.err.println(range.upperEndpoint());
        Range<Integer> range1 = Range.openClosed(0,3);
        System.err.println(range.isConnected(range1));
    }
}
