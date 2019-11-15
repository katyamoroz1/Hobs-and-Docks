package station;

import ch.qos.logback.classic.Logger;
import hobs.Person;
import org.slf4j.LoggerFactory;
import ships.Ship;
import Generate.GenerateShips;


public class SausageStation extends Thread {
    public SausageStation() {
    }

    public static Logger logger = (Logger) LoggerFactory.getLogger("SausageStation");

    public static volatile int store = 0;

    @Override
    public void run() {
        try {
            while (true) {
                Ship ship = Ship.firstShip(GenerateShips.Food.sausage);
                if (ship != null) {
                    if (ship.fod == GenerateShips.Food.sausage) {
                        sleep(1000 * ship.volume / 5);
                        logger.info("Корабль с {} килограммами сосисок разгрузился!", ship.volume);
                        store += ship.volume;
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void sausageForSandwich() {
        if (store != 0) {
            store--;
            Person.sausageForSandwich++;
            logger.info("Бродяга украл сосиску, теперь есть {} сосисок", Person.sausageForSandwich);
        }
    }
}
