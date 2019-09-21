package data_structure.linked_list;


import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * 链表的3要素:数据,next指针,头节点
 */
@Data
public class ListDemo {
    private String name;
    private String password;
    private ListDemo next;
    private ListDemo head;

    @Override
    public String toString() {
        return "ListDemo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListDemo listDemo = (ListDemo) o;
        return name.equals(listDemo.name) &&
                password.equals(listDemo.password);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }

    /**
     *
     * @return
     */
    public ListDemo(){
        head = new ListDemo("头节点",null,null);
    }
    public ListDemo(String name, String password, ListDemo next) {
        this.name = name;
        this.password = password;
        this.next = next;
    }
    public void addLast(ListDemo listDemo){
        ListDemo temp = head;
        while (true){
            if (Objects.nonNull(temp.getNext())){
                temp =temp.getNext();
            }else {
                temp.setNext(listDemo);
                break;
            }
        }
    }
    public void addFirst(ListDemo listDemo){
        ListDemo temp = head;
        if (Objects.nonNull(temp.getNext())){
            listDemo.setNext(temp.getNext());
        }
        temp.setNext(listDemo);
    }
    public boolean remove(ListDemo listDemo){
        ListDemo temp = head;
        while (true){
            if (Objects.isNull(temp.getNext())){
                return false;
            }
            if (!temp.getNext().equals(listDemo)){
                temp =temp.getNext();
            }else {
                ListDemo same = temp.getNext();
                temp.setNext(temp.getNext().getNext());
                same.setNext(null);
                return true;
            }
        }
    }
    public List<ListDemo> show(){
        List<ListDemo> list = Lists.newArrayList();
        ListDemo temp = head;
        if (Objects.isNull(temp.getNext())){
            return list;
        }
        while (true){
            if (Objects.nonNull(temp.getNext())){
                list.add(temp.getNext());
                temp = temp.getNext();
            }else {
                break;
            }
        }
        return list;
    }
}
