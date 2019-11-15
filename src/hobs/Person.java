package hobs;

import station.BreadStation;
import station.MayonnaiseStation;
import station.SausageStation;

public class Person extends Thread {

    public Person() {}

    public static volatile int breadForSandwich = 0;
    public static volatile int sausageForSandwich = 0;
    public static volatile int mayonnaiseForSandwich = 0;

    @Override
    public void run() {
        try {
            while (true) {
                double Value = Math.random();
                if (Value < 0.33) {
                    if(BreadStation.store != 0) {
                        BreadStation.breadForSandwich();
                        sleep(3000);
                    } else {
                        double newValue = Math.random();
                        Value = newValue;
                    }
                } else if (Value < 0.66) {
                    if(SausageStation.store != 0) {
                        SausageStation.sausageForSandwich();
                        sleep(3000);
                    } else {
                        double newValue = Math.random();
                        Value = newValue;
                    }
                } else {
                    if(MayonnaiseStation.store != 0) {
                        MayonnaiseStation.mayonnaiseForSandwich();
                        sleep(3000);
                    } else {
                        double newValue = Math.random();
                        Value = newValue;
                    }
                }
            }

        } catch (InterruptedException e) {
        }
    }
}
