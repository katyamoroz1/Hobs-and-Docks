package hobs;

public class Cook implements Runnable {
    @Override
    public void run() {
        Person.cooking = 0;
        Person.breadForSandwich -= 8;
        Person.sausageForSandwich -= 8;
        Person.mayonnaiseForSandwich -= 8;
        System.out.println("БРОДЯГИ КУШАЮТ!!!");
    }
}
