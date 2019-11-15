package station;
import ch.qos.logback.classic.Logger;
import hobs.Person;
import org.slf4j.LoggerFactory;
import ships.Ship;
import Generate.GenerateShips;


public class MayonnaiseStation extends Thread {
    public MayonnaiseStation() {
    }

    public static volatile int store;

    public static Logger logger = (Logger) LoggerFactory.getLogger("BreadStation");

    @Override
    public void run() {
        try {
            while (true) {
                Ship ship = Ship.firstShip(GenerateShips.Food.mayonnaise);
                if (ship != null) {
                    if (ship.fod == GenerateShips.Food.mayonnaise) {
                    sleep(1000 * ship.volume / 5);
                        logger.info("Корабль с {} килограммами майонеза разгрузился!", ship.volume);
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
            logger.info("Бродяга украл майонез, теперь есть {} майонеза", Person.mayonnaiseForSandwich);
        }
    }
}
