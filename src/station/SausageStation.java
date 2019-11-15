package station;
import hobs.Person;
import ships.Ship;
import Generate.GenerateShips;


public class SausageStation extends Thread {
    public SausageStation() {
    }

    public static volatile int store = 0;

    @Override
    public void run() {
        try {
            while (true) {
                Ship ship = Ship.firstShip(GenerateShips.food.sausage);
                if (ship != null) {
                    if (ship.fod == GenerateShips.food.sausage) {
                    sleep(1000 * ship.volume / 5);
                            System.out.printf("Корабль с %d килограммами сосисок разгрузился!\n", ship.volume);
                            store += ship.volume;
                        }
                    }
            }
        } catch (InterruptedException e) {}
    }
    public static synchronized void sausageForSandwich() {
        if (store != 0) {
            store--;
            Person.sausageForSandwich++;
            System.out.printf("Бродяга украл сосиску, теперь есть %d сосисок\n", Person.sausageForSandwich);
        }
    }
}
