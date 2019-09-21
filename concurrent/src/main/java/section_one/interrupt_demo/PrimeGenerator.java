package section_one.interrupt_demo;

import com.google.common.base.Preconditions;

public class PrimeGenerator extends Thread {
    @Override
    public void run() {
        long number = 1l;
        while (true){
            if (isPrime(number)){
        System.out.println(number+" is prime");
            }
            if (this.isInterrupted()){
                System.out.println("the prime number generator has been Interrupted");
                return;
            }
            number++;
        }
    }
    private boolean isPrime(long number){
        Preconditions.checkState(number>=0);
        if (number<=2)
            return true;
    for (int i = 2; i < number; i++) {
      //遍历查找素数
        if (number%i==0){
            return false;
        }
    }
    return true;
    }
}
