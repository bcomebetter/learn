package unit;

import com.google.common.collect.*;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author hewei
 * hashMultiset 无序可重复集合 链表
 * hashBiMap 双向map 提供键到值的映射，也提供值到键的映射.如果put键相同,覆盖;值相同,IllegalArgumentException.
 * Table<R,C,V> == Map<R,Map<C,V>> + Map<C,Map<R,V>>
 * Table代表一个特殊的映射，其中两个键可以在组合的方式被指定为单个值,即有两个键的hashmap,同时可以根据每个键获取其对应的map
 * 通过第一个参数作为键的方法为row(),通过第二个参数作为键的方法为column()
 *     可用于公司映射部门,部门映射员工的场景
 */
public class Collections2Test {
    @Test
    public void multisetTest() {
        HashMultiset<String> hashMultiset = HashMultiset.create();
        hashMultiset.add("aaa");
        hashMultiset.add("aaa");
        for (Object o : hashMultiset) {
            System.out.println(o);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void hashBiMap() {
        HashBiMap<String, String> hashBiMap = HashBiMap.create();
        hashBiMap.put("mon","星期一");
        hashBiMap.put("mon","星期二");
        System.err.println(hashBiMap.get("mon"));
        hashBiMap.put("Tues","星期二");
    }

    @Test
    public void testTable() {
        HashBasedTable<String, String, String> employeeTable = HashBasedTable.create();
        employeeTable.put("IBM", "101","Mahesh");
        employeeTable.put("IBM", "102","Ramesh");
        employeeTable.put("IBM", "103","Suresh");

        employeeTable.put("Microsoft", "111","Sohan");
        employeeTable.put("Microsoft", "112","Mohan");
        employeeTable.put("Microsoft", "113","Rohan");

        employeeTable.put("TCS", "121","Ram");
        employeeTable.put("TCS", "112","Shyam");
        employeeTable.put("TCS", "123","Shyam");

        //get Map corresponding to IBM
        Map<String,String> ibmEmployees =  employeeTable.column("TCS");
        Set<String> strings = ibmEmployees.keySet();
        System.err.println(strings.size());

    }
    @Test
    public void testStuScoreMultimap(){
        Multimap<String,StudentScore> scoreMultimap = ArrayListMultimap.create();
        for(int i=10;i<20;i++){
            StudentScore studentScore=new StudentScore();
            studentScore.courseId=1001+i;
            studentScore.score=100-i;
            scoreMultimap.put("peida",studentScore);
        }
        System.err.println(StringUtils.isAllLowerCase("aaa"));
        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.keys());
        Collection<StudentScore> peida = scoreMultimap.get("peida");
        for (StudentScore studentScore : peida) {
            System.out.println(studentScore);
        }
    }
    class StudentScore{
        int courseId;
        int score;

        @Override
        public String toString() {
            return "StudentScore{" +
                    "courseId=" + courseId +
                    ", score=" + score +
                    '}';
        }
    }
}
