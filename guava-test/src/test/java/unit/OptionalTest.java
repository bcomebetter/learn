package unit;


import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author hewei
 * 该类的本质是一个容器,如果使用of()方法存入该类的对象为null,会直接报错该类用于强制检测null,
 * 当该容器中存放的为null值是,可以通过or()方法对null值进行取代
 */
public class OptionalTest {
    @Test(expected = NullPointerException.class)
    public void Option() {
        //获取optional实例的两种方式
        Optional<String> optionWithNull = Optional.absent();
        Optional<String> option = Optional.of("aaa");
        Optional<String> optionTwo = Optional.of("bbb");
        Optional<String> optionT = Optional.of(null);

        //asSet()方法,如果该实例不为空,返回包含该实例的集合
        for (String s : option.asSet()) {
            System.err.println(s);
        }
        for (String s : optionWithNull.asSet()) {
            System.err.println(s);
        }
        boolean present = option.isPresent();
        assertThat(present,equalTo(true));
        String string = option.or("zhushuangshuang");
        String stringUseDefault = optionWithNull.or("zhushuangshuang");
        assertThat(string,equalTo("aaa"));
        assertThat(stringUseDefault,equalTo("zhushuangshuang"));
        Optional<String> stringOptional = optionWithNull.or(option);
        assertThat(stringOptional.get(),equalTo("aaa"));
        String stringWithLambda= optionWithNull.or(()->option.get());
        assertThat(stringWithLambda,equalTo("aaa"));
        String stringNotNull = option.orNull();
        String nullString = optionWithNull.orNull();
        assertThat(stringNotNull,equalTo("aaa"));
        assertThat(nullString,equalTo(null));
    }

    @Test
    public void testIterable() {
        ArrayList<Optional<String>> options = Lists.newArrayList();
        options.add(Optional.of("aaa"));
        options.add(Optional.of("bbb"));
        options.add(Optional.of("ccc"));
        options.add(Optional.absent());
        Iterable<String> strings = Optional.presentInstances(options);
        strings.forEach(System.err::println);
        System.err.println(options.get(0).toString());
    }
}

