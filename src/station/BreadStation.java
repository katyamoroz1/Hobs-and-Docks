package station;

import ch.qos.logback.classic.Logger;
import hobs.Person;
import org.slf4j.LoggerFactory;
import ships.Ship;
import Generate.GenerateShips;


public class BreadStation extends Thread {

    public BreadStation() {
    }

    public static Logger logger = (Logger) LoggerFactory.getLogger("BreadStation");

    public static volatile int store = 0;

    @Override
    public void run() {
        try {
            while (true) {
                Ship ship = Ship.firstShip(GenerateShips.Food.bread);
                if (ship != null) {
                    if (ship.fod == GenerateShips.Food.bread) {
                        sleep(1000 * ship.volume / 5);
                        logger.info("Корабль с {} килограммами хлеба разгрузился!", ship.volume);
                        store += ship.volume;
                    }
                }
            }
        } catch (InterruptedException e) {
        }
    }

    public static synchronized void breadForSandwich() {
        if (store != 0) {
            store--;
            Person.breadForSandwich++;
            logger.info("Бродяга украл хлеб, теперь есть {} хлеба", Person.breadForSandwich);
        }
    }
}
