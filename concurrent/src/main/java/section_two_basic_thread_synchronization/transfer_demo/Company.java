package section_two_basic_thread_synchronization.transfer_demo;

public class Company implements Runnable {
    private Account account;

    public Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++){
            account.addAccount(1000);
        }
    }
}
