package section_two_basic_thread_synchronization.arranging_independent_attributes;

/**
 * 任何对象都可以作为对象锁,当多个互不相干的属性需要同时进行更新时,可以创建多个仅仅用于作为锁
 * 的对象作为同步代码块的参数来实现数据的共享
 */
public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        Thread thread = new Thread(new TicketOffice1(cinema),"c1");
        Thread thread1 = new Thread(new TicketOffice2(cinema),"c2");
        thread.start();
        thread1.start();

        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getName()+"剩余票数"+cinema.getVacanciesCinema1());
        System.out.println(thread1.getName()+"剩余票数"+cinema.getVacanciesCinema2());
    }
}
