package hobs;

import station.BreadStation;
import station.MayonnaiseStation;
import station.SausageStation;

import java.util.concurrent.BrokenBarrierException;

public class Person extends Thread {

    public Person(String name) {
        super(name);
    }

    public static volatile int breadForSandwich = 0;
    public static volatile int sausageForSandwich = 0;
    public static volatile int mayonnaiseForSandwich = 0;
    public static volatile int cooking = 0;

    @Override
    public void run() {
        try {
            while (true) {
                if (cooking < 2) {
                    ++cooking;
//                    System.out.println("I am in\n");
                    Barrier.BARRIER.await();
                } else {
                    double value = Math.random();
                    if (value < 0.33) {
                        if (BreadStation.store != 0) {
//                            System.out.println(getName());
                            BreadStation.breadForSandwich();
                            sleep(3000);
                        } else {
                            double newValue = Math.random();
                            value = newValue;
                        }
                    } else if (value < 0.66) {
                        if (SausageStation.store != 0) {
//                            System.out.println(getName());
                            SausageStation.sausageForSandwich();
                            sleep(3000);
                        } else {
                            double newValue = Math.random();
                            value = newValue;
                        }
                    } else {
                        if (MayonnaiseStation.store != 0) {
//                            System.out.println(getName());
                            MayonnaiseStation.mayonnaiseForSandwich();
                            sleep(3000);
                        } else {
                            double newValue = Math.random();
                            value = newValue;
                        }
                    }
                    if (breadForSandwich >= 8 && sausageForSandwich >= 8 && mayonnaiseForSandwich >= 8) {
                        Barrier.BARRIER.await();
                    }
                }
            }

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
