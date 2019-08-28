package unit;

import com.google.common.base.Splitter;
import org.junit.Test;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * @author hewei
 * splitter product substrings broken out by the provider delimiter
 * suggest read source code
 * 主要用于按照一定的规则分割字符串,同时可以将分割字符串中产生的""进行处理,并可以处理分割出来的字符串
 * 所带有的空格,同时可以将字符串切割转化为map
 */
public class SplitterTest {
    @Test
    public void testSplitter() {
        List<String> strings = Splitter.on("?").splitToList("zhu?shuang?shuang");
        assertThat(strings, notNullValue());
        assertThat(strings.get(0),equalTo("zhu"));
        assertThat(strings.get(1),equalTo("shuang"));
        assertThat(strings.get(2),equalTo("shuang"));
        assertThat(strings.size(),equalTo(3));
    }

    @Test
    public void testSplitterNull() {
        //使用omitEmptyStrings()可以除去产生的字符串中的null值
        List<String> strings = Splitter.on("?").splitToList("zhu?shuang???shuang");
        assertThat(strings,notNullValue());
        assertThat(strings.get(0),equalTo("zhu"));
        assertThat(strings.get(1),equalTo("shuang"));
        assertThat(strings.get(2),equalTo(""));
        assertThat(strings.get(3),equalTo(""));
        assertThat(strings.get(4),equalTo("shuang"));
        assertThat(strings.size(),equalTo(5));
    }
    @Test
    public void testSplitterWithNull() {
        //使用omitEmptyStrings()可以除去产生的字符串中的空字符串""
        List<String> strings = Splitter.on("?").omitEmptyStrings().splitToList("zhu?shuang???shuang");
        assertThat(strings,notNullValue());
        assertThat(strings.get(0),equalTo("zhu"));
        assertThat(strings.get(1),equalTo("shuang"));
        assertThat(strings.get(2),equalTo("shuang"));
        assertThat(strings.size(),equalTo(3));
    }

    @Test
    public void testSplitterWithMap() {
        //注意是trimResults()是将key=value前后的空格去掉,如果key=  value,那么map中的值为  value
        Map<String, String> stringMap = Splitter.on("?").trimResults().omitEmptyStrings()
                .withKeyValueSeparator("=").split("google=guava?   hewei=zhushuangshuang   ??   ");
        assertThat(stringMap,notNullValue());
        assertThat(stringMap.size(),equalTo(2));
        assertThat(stringMap.get("google"),equalTo("guava"));
        assertThat(stringMap.get("hewei"),equalTo("zhushuangshuang"));
        Splitter splitter = Splitter.on("?").trimResults();
    }
    @Test
    public void testSplit_On_Split_OmitEmpty() {
        List<String> strings = Splitter.on("?").omitEmptyStrings()
                .splitToList("zhu   ???shuang??    shuang");
        strings.forEach(System.err::println);
        assertThat(strings,notNullValue());
        assertThat(strings.get(0),equalTo("zhu   "));
        assertThat(strings.get(1),equalTo("shuang"));
        assertThat(strings.get(2),equalTo("    shuang"));
        assertThat(strings.size(),equalTo(3));
    }
    @Test
    public void testSplit_On_Split_OmitEmpty_TrimResult() {
        //使用trimResults()去除字符串首位的空格,同时还可以除去指定的字符串
        List<String> strings = Splitter.on("?").omitEmptyStrings().trimResults().splitToList("zhu   ???shuang??    shuang");
        assertThat(strings,notNullValue());
        assertThat(strings.get(0),equalTo("zhu"));
        assertThat(strings.get(1),equalTo("shuang"));
        assertThat(strings.get(2),equalTo("shuang"));
        assertThat(strings.size(),equalTo(3));
    }

    /**
     * aaaabbbbccccdddd
     */
    @Test
    public void testSplitFixLength() {
        List<String> stringList = Splitter.fixedLength(4).splitToList("aaaabbbbccccdddd");
        assertThat(stringList,notNullValue());
        assertThat(stringList.get(0),equalTo("aaaa"));
        assertThat(stringList.get(1),equalTo("bbbb"));
        assertThat(stringList.get(2),equalTo("cccc"));
        assertThat(stringList.get(3),equalTo("dddd"));
        assertThat(stringList.size(),equalTo(4));
    }

    @Test
    public void testSplitOn_SplitLimit() {
        List<String> stringList = Splitter.on("?").limit(3).splitToList("hewei?zhushuangshuang?google?guava");
        assertThat(stringList,notNullValue());
        assertThat(stringList.size(),equalTo(3));
        assertThat(stringList.get(0),equalTo("hewei"));
        assertThat(stringList.get(1),equalTo("zhushuangshuang"));
        assertThat(stringList.get(2),equalTo("google?guava"));
    }
    @Test
    public void testSplitOn_SplitPattern() {
        List<String> stringList = Splitter.onPattern("\\|").trimResults().omitEmptyStrings().splitToList("hello   | | | world");
        assertThat(stringList,notNullValue());
        assertThat(stringList.size(),equalTo(2));
        assertThat(stringList.get(0),equalTo("hello"));
        assertThat(stringList.get(1),equalTo("world"));
        System.err.println(Splitter.on('a').omitEmptyStrings().split("bababa").toString());
        Splitter.fixedLength(4).splitToList("aaaabbbbcccc").forEach(a-> System.err.println(a));

    }
}
