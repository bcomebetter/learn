package data_structure.linked_list;

import java.util.List;
import java.util.Objects;

/**
 * 添加(创建)一个头节点,该节点作为链表遍历的起点
 *  通过while加上辅助变量进行循环遍历,英文我们不知道该循环会在什么时候结束
 */
public class MyLink {
    public static void main(String[] args) {
        ListDemo listDemo = new ListDemo("hewei", "aaa", null);
        ListDemo listDemo1 = new ListDemo("zhangsan", "aaa", null);
        ListDemo listDemo2 = new ListDemo("lisi", "aaa", null);
        ListDemo listDemo3 = new ListDemo("wangwu", "aaa", null);
        ListDemo listDemo4 = new ListDemo("zhaoliu", "aaa", null);
        ListDemo listDemo5 = new ListDemo("sunqi", "aaa", null);
        ListDemo head = new ListDemo();
        head.addLast(listDemo);
        head.addLast(listDemo1);
        head.addLast(listDemo2);
        head.addLast(listDemo3);
        head.addLast(listDemo4);
        head.addLast(listDemo5);
        List<ListDemo> show = head.show();
        for (ListDemo demo : show) {
            System.out.println(demo.getName()+"--------"+demo.getPassword());
        }
    }
}
