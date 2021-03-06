package unit;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.base.MoreObjects;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * get()方式通过从数据库中获取,自动加入缓存中
 * put()可以通过添加键值对的方式加入,则不需要传入classloader
 * https://blog.csdn.net/Yangxuxux/article/details/82226822 关于手机短信验证通过该缓存实现
 */
public class CacheTester {
    public static void main(String args[]){
        //create a cache for employees based on their employee id
        LoadingCache employeeCache =
                CacheBuilder.newBuilder()
                        .maximumSize(100) // maximum 100 records can be cached
                        .expireAfterAccess(30, TimeUnit.MINUTES) // cache will expire after 30 minutes of access
                        .build(new CacheLoader<String, Employee>() {
                            @Override
                            public Employee load(String empId) throws Exception {
                                //别的集合类型
                                return getFromDatabase(empId);
                            }
                        });

        try {
            //如果缓存不存在,调用CacheLoader中的load方法
            //employee record
           //ca
            System.out.println("Invocation #1");
            System.out.println(employeeCache.get("100"));
            System.out.println(employeeCache.get("103"));
            System.out.println(employeeCache.get("110"));
            //second invocation, data will be returned from cache
            System.out.println("Invocation #2");
            System.out.println(employeeCache.get("100"));
            System.out.println(employeeCache.get("103"));
            System.out.println(employeeCache.get("110"));

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static Employee getFromDatabase(String empId){
        Employee e1 = new Employee("Mahesh", "Finance", "100");
        Employee e2 = new Employee("Rohan", "IT", "103");
        Employee e3 = new Employee("Sohan", "Admin", "110");

        Map<String,Employee> database = new HashMap();
        database.put("100", e1);
        database.put("103", e2);
        database.put("110", e3);
        System.out.println("Database hit for" + empId);
        return database.get(empId);
    }
}

class Employee {
    String name;
    String dept;
    String empID;

    public Employee(String name, String dept, String empID){
        this.name = name;
        this.dept = dept;
        this.empID = empID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public String getEmplD() {
        return empID;
    }
    public void setEmplD(String emplD) {
        this.empID = emplD;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(Employee.class)
                .add("Name", name)
                .add("Department", dept)
                .add("Emp Id", empID).toString();
    }
}


