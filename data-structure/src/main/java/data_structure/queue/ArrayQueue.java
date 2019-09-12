package data_structure.queue;

import lombok.Data;

import static com.google.common.base.Preconditions.checkState;

@Data
class ArrayQueue{
    private final static int MAX_SIZE =10;
    private int maxSize;
    private int front;
    private int rear;
    private int[] array;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.rear = -1;
        this.front =-1;
        array = new int[maxSize];
    }
    public ArrayQueue(){
        this(MAX_SIZE);
    }
    public boolean isEmpty(){
        return rear==front;
    }
    public int size(){
        return front-rear;
    }
    public boolean isMax(){
        return rear==maxSize-1;
    }
    public void add(int number){
        checkState(!isMax(),"该队列已满,无法添加");
        rear++;
        array[rear]=number;
    }
    public int getFront(){
        checkState(!isEmpty(),"该队列为空,无法取出");
        front++;
        return array[front];
    }
    public void list(){
        checkState(!isEmpty(),"队列为空,无法展示");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
