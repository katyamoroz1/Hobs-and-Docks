package Generate;
import java.util.LinkedList;
import java.util.Queue;

import ships.Ship;

public class GenerateShips extends Thread {
    public GenerateShips() {}

    public enum food {
        bread,
        sausage,
        mayonnaise
    }

   public static java.util.Queue<Ship> shipsInQueue = new LinkedList<>();

    @Override
public void run() {
    try {
        while(!Thread.currentThread().isInterrupted()) {
            double foodValue = Math.random();
            if (foodValue < 0.33) {
                Ship ship = new Ship(((int) (Math.random() * 3) + 1) * 10, food.bread);
                shipsInQueue.add(ship);
                System.out.printf("Плывет корабль с %d килогаммами хлеба!\n", ship.volume);
                Thread.currentThread().sleep(3000);
            }
            if (foodValue < 0.66) {
                Ship ship = new Ship(((int) (Math.random() * 3) + 1) * 10, food.sausage);
                shipsInQueue.add(ship);
                System.out.printf("Плывет корабль с %d килограммами сосисок!\n", ship.volume);
                Thread.currentThread().sleep(3000);
            }
            if (foodValue <= 1) {
                Ship ship = new Ship(((int) (Math.random() * 3) + 1) * 10, food.mayonnaise);
                shipsInQueue.add(ship);
                System.out.printf("Плывет корабль с %d килограммами майонеза!\n", ship.volume);
                Thread.currentThread().sleep(3000);
            }
        }
    } catch (InterruptedException e) {}
    }
}
