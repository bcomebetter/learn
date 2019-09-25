package section_two_basic_thread_synchronization.test_my_lock;

import java.util.ArrayList;
import java.util.Date;

public class Buffer {

    private MyLock lock = new MyLock();
    private ArrayList<Date> arrayList = new ArrayList<>();

    public void getDate(){
        while (arrayList.size()==0){
        }
        lock.lock();

        System.out.println("获取了一个date"+arrayList.get(0)+",该线程的名称为:"+Thread.currentThread().getName()+",size="+arrayList.size());
        arrayList.remove(0);
        lock.unlock();
    }
    public void setDate(){
        while (arrayList.size()==8){

        }
        lock.lock();

        System.out.println("添加了一个新的date"+arrayList.add(new Date())+",该线程的名称为:"+Thread.currentThread().getName()+",size="+arrayList.size());

        lock.unlock();
    }
}
