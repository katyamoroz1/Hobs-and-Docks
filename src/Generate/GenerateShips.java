package Generate;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import ships.Ship;

public class GenerateShips extends Thread {
    public GenerateShips() {}

    public static Logger logger = (Logger) LoggerFactory.getLogger("Generate");

    public enum Food {
        bread,
        sausage,
        mayonnaise
    }

    @Override
public void run() {
    try {
        while(!Thread.currentThread().isInterrupted()) {
            double foodValue = Math.random();
            if (foodValue < 0.33) {
                Ship ship = new Ship(((int) (Math.random() * 3) + 1) * 10, Food.bread);
                if (Ship.shipsInQueue.size() < 5) {
                    Ship.shipsInQueue.add(ship);
//                    System.out.printf("Плывет корабль с %d килогаммами хлеба!\n", ship.volume);
                    logger.info("Плывет корабль с {} килогаммами хлеба!", ship.volume);
                } else {
//                    System.out.printf("Корабль с %d килогаммами хлеба утонул!\n", ship.volume);
                    logger.info("Корабль с {} килогаммами хлеба утонул!", ship.volume);
                }
                sleep(700);
            } else if (foodValue < 0.66) {
                Ship ship = new Ship(((int) (Math.random() * 3) + 1) * 10, Food.sausage);
                if (Ship.shipsInQueue.size() < 5) {
                    Ship.shipsInQueue.add(ship);
//                    System.out.printf("Плывет корабль с %d килогаммами сосисок!\n", ship.volume);
                    logger.info("Плывет корабль с {} килогаммами сосисок!", ship.volume);
                } else {
//                    System.out.printf("Корабль с %d килогаммами сосисок утонул!\n", ship.volume);
                    logger.info("Корабль с {} килогаммами сосисок утонул!", ship.volume);
                }
                sleep(700);
            } else if (foodValue <= 1) {
                Ship ship = new Ship(((int) (Math.random() * 3) + 1) * 10, Food.mayonnaise);
                if (Ship.shipsInQueue.size() < 5) {
                    Ship.shipsInQueue.add(ship);
//                    System.out.printf("Плывет корабль с %d килогаммами майонеза!\n", ship.volume);
                    logger.info("Плывет корабль с {} килогаммами майонеза!", ship.volume);
                } else {
//                    System.out.printf("Корабль с %d килогаммами майонеза утонул!\n", ship.volume);
                    logger.info("Корабль с {} килогаммами майонеза утонул!", ship.volume);
                }
                sleep(700);
            }
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }
}
