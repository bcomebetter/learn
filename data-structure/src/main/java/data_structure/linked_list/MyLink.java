package data_structure.linked_list;
import java.util.List;


/**
 * 添加(创建)一个头节点,该节点作为链表遍历的起点
 *  通过while加上辅助变量进行循环遍历,英文我们不知道该循环会在什么时候结束
 */
public class MyLink {
    public static void main(String[] args) {
        ListDemo head = new ListDemo();
        head.addLast(new Node("hewei"));
        head.addLast(new Node("zhangsan"));
        head.addLast(new Node("lisi"));
        head.addLast(new Node("wangwu"));
        head.addLast(new Node("zhaoliu"));
        head.addLast(new Node("sunqi"));
        head.addLast(new Node("tianba"));
        head.addLast(new Node("sanjiu"));
        List<Node> show = head.show();
        show.forEach(System.out::println);
        System.out.println("--------------------------");
        head.reversal();
        show = head.show();
        show.forEach(System.out::println);
    }
}
