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
    private Node head;
    /**
     *
     * @return
     */
    public ListDemo(){
        head = new Node("头节点");
    }

    public void addLast(Node node){
        Node temp = head;
        while (true){
            if (Objects.nonNull(temp.next)){
                temp =temp.next;
            }else {
                temp.next =node;
                break;
            }
        }
    }
    public void addFirst(Node node){
        Node temp = head;
        if (Objects.nonNull(temp.next)){
            node.next = temp.next;
        }
        head.next = node;
    }
    public boolean remove(Node node){
        Node temp = head;
        while (true){
            if (Objects.isNull(temp.next)){
                return false;
            }
            if (!temp.next.equals(node)){
                temp =temp.next;
            }else {
                Node same = temp.next;
                temp.next = temp.next.next;
                same.next = null;
                return true;
            }
        }
    }
    public List<Node> show(){
        List<Node> list = Lists.newArrayList();
        Node temp = head;
        if (Objects.isNull(temp.next)){
            return list;
        }
        while (true){
            if (Objects.nonNull(temp.next)){
                list.add(temp.next);
                temp = temp.next;
            }else {
                break;
            }
        }
        return list;
    }
    public void reversal(){
        if (Objects.isNull(head.next)||Objects.isNull(head.next.next)){
            return;
        }
        Node cur = head.next;
        Node last = null;

        while (Objects.nonNull(cur)){
            head.next = cur;
            cur = cur.next;
            head.next.next= last;
            last = head.next;
        }

    }
}
