package unit;

import com.google.common.base.CaseFormat;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import org.junit.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author hewei
 * Joiner concatenate strings together with a specified delimiter
 * 主要用于将固定长度的数组转化为字符串或者stringbuffer对象,同时可将数组中的null值进行相应的处理(替换或者去除),
 * 并可以将map集合中的实例转为指定格式的字符串
 */
public class JoinerTest {
    private final List<String> strings = Lists.newArrayList(
            "google","guava","java","zhushuangshuang","hewei"
    );
    private final List<String> stringsWithNull = Lists.newArrayList(
            "google","guava","java","zhushuangshuang",null,"hewei"
    );

    private final Map<String,String> mapStrings = ImmutableMap.of(
            "google","guava","zhushuangshuang","hewei"
    );

    public static void main(String[] args) {

    }
    @Test
    public void testJoin(){
        Joiner aa = Joiner.on("-");
        System.err.println(aa.join(strings));

    }

    @Test(expected = NullPointerException.class)
    public void testJoinSplitNullPointException() {
        //返回一个人带有连接符的joiner对象,如果分隔符为null,抛出空指针异常
        Joiner.on(null);
    }

    @Test(expected = NullPointerException.class)
    public void testListWithNull() {
        //当集合中存在未处理的空值时,出现空指针异常
        System.err.println(Joiner.on("-").join(stringsWithNull));
    }

    @Test
    public void testDealListWithNull() {
        //通过joiner对象的skipNulls或者useForNull对null值进行处理以避免空指针异常

        //useForNul()   使用"猪股跌了"替代null值
        System.err.println(Joiner.on("?").useForNull("猪股跌了").join(stringsWithNull));
        //skipNulls()   跳过空值
        System.err.println(Joiner.on("?").skipNulls().join(stringsWithNull));
    }

    @Test
    public void testJoinAppendToStringBuffer() throws IOException {
        StringBuffer sb = new StringBuffer();
        StringBuffer stringBuffer = Joiner.on("?").useForNull("猪股跌了").appendTo(sb, stringsWithNull);
        System.err.println(stringBuffer.toString());
        System.err.println(sb==stringBuffer);
        assertThat(stringBuffer.toString(), equalTo("google?guava?java?zhushuangshuang?猪?hewei"));
    }

    @Test
    public void testJoinByStream() {
        System.err.println(stringsWithNull.stream().filter(aa -> aa != null && !aa.isEmpty()).collect(Collectors.joining("?")));
    }

    @Test
    public void test_Join_On_With_Map() {
        assertThat(Joiner.on("?").withKeyValueSeparator("=").join(mapStrings),equalTo("google=guava?zhushuangshuang=hewei"));
    }

    @Test
    public void caseFormat() {
        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "MyTest-data"));
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));
    }
}
