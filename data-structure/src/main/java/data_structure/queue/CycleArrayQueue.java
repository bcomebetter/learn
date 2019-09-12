package data_structure.queue;

import lombok.Data;

import static com.google.common.base.Preconditions.checkState;

/**
 * 队列三个要素:最大容量,前指针,后指针
 * 自己画图在草稿纸上分析每次添加数据的状态,考虑到循环队列,故需要在稿纸上进行循环推演
 */
@Data
public class CycleArrayQueue {
    private final static int DEFAULT_SIZE =10;
    private int maxSize;
    private int front;
    private int rear;
    private int[] array;

    public CycleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.rear = 0;
        this.front = 0;
        array = new int[maxSize];
    }
    public CycleArrayQueue(){
        this(DEFAULT_SIZE);
    }

    public boolean isEmpty(){
        return rear-front==0;
    }
    public int size(){
        return rear-front;
    }
    public boolean isMax(){
        return rear-front==maxSize;
    }
    public void add(int number){
        checkState(!isMax(),"该队列已满,无法添加");
        array[rear%maxSize]=number;
        rear++;
    }
    public int getFront(){
        checkState(!isEmpty(),"该队列为空,无法取出");
        int i = array[front%maxSize];
        array[front%maxSize]=0;
        front++;
        return i;
    }
    public void list(){
        checkState(!isEmpty(),"队列为空,无法展示");
        if (rear>front){
            for (int i = front;i<rear;i++){
                System.out.println(array[i%maxSize]);
            }
        }
    }
}
