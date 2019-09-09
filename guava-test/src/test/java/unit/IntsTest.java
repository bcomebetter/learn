package unit;

import com.google.common.base.Converter;
import com.google.common.collect.Lists;
import com.google.common.math.DoubleMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 原语工具ints提供了大量的方法,主要用于数组中数据的处理,如返回数组中数字的最值,对数组中出现的字符串进行处理等
 */
public class IntsTest {
    @Test
    public void ints() {
        List<Integer> integers = Ints.asList(1, 2, 1,3,2, 4, 5, 6);
        int[] array = Ints.toArray(integers);
        System.out.println("返回的数组长度为:"+Ints.ensureCapacity(array, 7, 5).length);
        System.err.println("数组的每个元素间添加aaa后的结果是:"+Ints.join("aaa", array));
        System.out.println("转化后的long型的值为:"+Ints.checkedCast(1l));

        System.err.println("比较3,4返回的值为:"+Ints.compare(3, 4));
        System.out.println("比较4,3返回的值为:"+Ints.compare(4, 3));
        //连接多个数组
        int[] concat = Ints.concat(array, array);
        System.err.println("连接两相同的数组的每个元素间添加aaa后的结果是:"+Ints.join("aaa", concat));
        System.out.println("array数组中是否含有元素5:"+Ints.contains(array, 5));
        System.err.println("array数组中是否含有元素10:"+Ints.contains(array, 10));
        //返回值的哈希码; 等于调用 ((Integer) value).hashCode() 的结果
        System.out.println("返回1的hashcode:"+Ints.hashCode(1));
        System.err.println("返回1第一次在数组array中出现的序号:"+Ints.indexOf(array, 1));
        System.out.println("返回1第一次在数组array中出现的序号:"+Ints.indexOf(array, 7));
        System.err.println("返回1最后一次在数组array中出现的序号:"+Ints.lastIndexOf(array,1));
        //????
        Comparator<int[]> comparator = Ints.lexicographicalComparator();
        System.out.println("返回数组中最大值:"+Ints.max(array));
        System.err.println("返回数组中最小值:"+Ints.min(array));
        System.out.println("返回最接近的int值:"+Ints.saturatedCast(1l));
        Converter<String, Integer> stringIntegerConverter = Ints.stringConverter();
        ArrayList<String> strings = Lists.newArrayList("3", "2", "4", "5");
        Iterable<Integer> convertAll = stringIntegerConverter.convertAll(strings);
        for (Integer integer : convertAll) {
            System.err.println(integer);
        }
        //将二进制数11转化为10进制数
        System.err.println(Ints.tryParse("11",2));
        System.err.println(Longs.tryParse("1111", 8));

    }
}
