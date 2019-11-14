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

    @Override
public void run() {
    try {
        while(!Thread.currentThread().isInterrupted()) {
            double foodValue = Math.random();
            if (foodValue < 0.33) {
                Ship ship = new Ship(((int) (Math.random() * 3) + 1) * 10, food.bread);
                if (Ship.shipsInQueue.size() < 5) {
                    Ship.shipsInQueue.add(ship);
                    System.out.printf("Плывет корабль с %d килогаммами хлеба!\n", ship.volume);
                } else {
                    System.out.printf("Корабль с %d килогаммами хлеба утонул!\n", ship.volume);
                }
                Thread.currentThread().sleep(3000);
            }
            if (foodValue < 0.66) {
                Ship ship = new Ship(((int) (Math.random() * 3) + 1) * 10, food.sausage);
                if (Ship.shipsInQueue.size() < 5) {
                    Ship.shipsInQueue.add(ship);
                    System.out.printf("Плывет корабль с %d килогаммами сосисок!\n", ship.volume);
                } else {
                    System.out.printf("Корабль с %d килогаммами сосисок утонул!\n", ship.volume);
                }
                Thread.currentThread().sleep(3000);
            }
            if (foodValue <= 1) {
                Ship ship = new Ship(((int) (Math.random() * 3) + 1) * 10, food.mayonnaise);
                if (Ship.shipsInQueue.size() < 5) {
                    Ship.shipsInQueue.add(ship);
                    System.out.printf("Плывет корабль с %d килогаммами майонеза!\n", ship.volume);
                } else {
                    System.out.printf("Корабль с %d килогаммами майонеза утонул!\n", ship.volume);
                }
                Thread.currentThread().sleep(3000);
            }
        }
    } catch (InterruptedException e) {}
    }
}
