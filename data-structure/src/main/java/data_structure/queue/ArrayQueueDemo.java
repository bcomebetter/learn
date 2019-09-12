package data_structure.queue;



public class ArrayQueueDemo {
    public static void main(String[] args) {
        CycleArrayQueue queue = new CycleArrayQueue();
        for (int i = 0; i < 11; i++) {
            queue.add(i);
        }
        System.out.println(queue.size());
        System.out.println(queue.getRear());
        System.out.println(queue.isEmpty());
        System.out.println(queue.isMax());
        System.out.println(queue.getFront());
        System.out.println(queue.getFront());
        System.out.println("----");

        queue.add(11);
        queue.list();
    }
}

