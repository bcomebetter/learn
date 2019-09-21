package section_two_basic_thread_synchronization.transfer_demo;

/**
 * synchronized 对象锁和类锁,对象锁每个对象只有一个,类锁每个类只有一个,他们不是同一个锁
 */
public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);
        Company company = new Company(account);
        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);
        Thread companyThread = new Thread(company);
        System.out.printf("Account : Initial Balance: %f\n",account.
                getBalance());
        bankThread.start();
        companyThread.start();
        try {
            companyThread.join();
            bankThread.join();
            System.out.printf("Account : Final Balance: %f\n",account.
                    getBalance());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
