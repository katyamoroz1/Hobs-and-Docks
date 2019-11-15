package station;

import hobs.Person;
import ships.Ship;
import Generate.GenerateShips;


public class BreadStation extends Thread {
    public BreadStation() {
    }

public static volatile int store = 0;

    @Override
    public void run() {
        try {
        while (true) {
            Ship ship = Ship.firstShip(GenerateShips.food.bread);
                if (ship != null) {
                    if (ship.fod == GenerateShips.food.bread) {
                    sleep(1000 * ship.volume / 5);
                        System.out.printf("Корабль с %d килограммами хлеба разгрузился!\n", ship.volume);
                        store += ship.volume;
                    }
                }
        }
        } catch (InterruptedException e) {}
    }

    public static synchronized void breadForSandwich() {
        if (store != 0) {
            store--;
            Person.breadForSandwich++;
            System.out.printf("Бродяга украл хлеб, теперь есть %d хлеба\n", Person.breadForSandwich);
        }
    }
}
