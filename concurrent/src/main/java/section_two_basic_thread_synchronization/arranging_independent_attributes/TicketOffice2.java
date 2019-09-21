package section_two_basic_thread_synchronization.arranging_independent_attributes;

public class TicketOffice2 implements Runnable {
    private Cinema cinema;
    public TicketOffice2(Cinema cinema){
        this.cinema=cinema;
    }
    @Override
    public void run() {
        cinema.returnTickets2(2);
        cinema.returnTickets2(2);
        cinema.sellTickets2(4);
        cinema.sellTickets1(3);
        cinema.sellTickets1(3);
        cinema.returnTickets1(6);
    }
}
