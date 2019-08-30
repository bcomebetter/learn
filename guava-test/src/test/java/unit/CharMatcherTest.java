package unit;

import com.google.common.base.CharMatcher;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

public class CharMatcherTest {
    @Test
    public void test() {

        String str = "ddd";
        String str1 = "aaaaaadddaaaddd";
        System.out.println(match(str1, str));

        CharMatcher matcher = CharMatcher.is('b');
        System.err.println(matcher.matches('b'));
        CharMatcher matcher1 = CharMatcher.is('c');
        CharMatcher matcher2 = matcher1.or(matcher);
        System.err.println(matcher2.matches('a'));
        System.err.println(matcher2.matches('b'));
        System.err.println(matcher2.matches('c'));
        List<Student> students=new ArrayList<>();
        students.add(new Student("hewei"));
        Optional
                .ofNullable(students)
                .orElse(Collections.emptyList())
                . forEach(System.out::println);
    }

    private Integer match(String str1, String str2){
        checkNotNull(str1,str1+"不能为空");
        checkNotNull(str2,str2+"不能为空");
        checkState(str1.length()>=str2.length(),"参数2的长度不能大于参数1的长度");
        for (int i = 0,j = str2.length()+i,len =str1.length(); j< len; i++,j++) {
            String s = str1.substring(i, j);
            if (s.equals(str2)){
                return i+1;
            }
        }
        //方法的目的
        //每个参数的意义,为什么
        return -1;
    }
}
@Data
class Student{
    private String name;

    public Student(String name) {
        this.name = name;
    }
}
