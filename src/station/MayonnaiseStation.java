package station;
import hobs.Person;
import ships.Ship;
import Generate.GenerateShips;


public class MayonnaiseStation extends Thread {
    public MayonnaiseStation() {
    }

    public static volatile int store;

    @Override
    public void run() {
        try {
            while (true) {
                Ship ship = Ship.firstShip(GenerateShips.Food.mayonnaise);
                if (ship != null) {
                    if (ship.fod == GenerateShips.Food.mayonnaise) {
                    sleep(1000 * ship.volume / 5);
                            System.out.printf("Корабль с %d килограммами майонеза разгрузился!\n", ship.volume);
                            store += ship.volume;
                        }
                    }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static synchronized void mayonnaiseForSandwich() {
        if (store != 0) {
            store--;
            Person.mayonnaiseForSandwich++;
            System.out.printf("Бродяга украл майонез, теперь есть %d майонеза\n", Person.mayonnaiseForSandwich);
        }
    }
}
