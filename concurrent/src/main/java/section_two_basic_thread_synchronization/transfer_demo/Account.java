package section_two_basic_thread_synchronization.transfer_demo;

import lombok.Data;

import java.util.concurrent.TimeUnit;

@Data
public class Account {
    private double balance;

    public synchronized void addAccount(double amount){
        double tmp = balance;
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp+=amount;
        balance =tmp;
    }
    public synchronized void subtractAmount(double amount){
        double tmp=balance;
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp-=amount;
        balance=tmp;
    }
}
