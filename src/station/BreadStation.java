package station;

import ships.Ship;
import Generate.GenerateShips;


public class BreadStation extends Thread {
    public BreadStation() {
    }


    @Override
    public void run() {
        try {
        while (true) {
            Ship ship = Ship.firstShip(GenerateShips.food.bread);
                if (ship != null) {
                    if (ship.fod == GenerateShips.food.bread) {
                    sleep(1000 * ship.volume / 5);
                        System.out.printf("Корабль с %d килограммами хлеба разгрузился!\n", ship.volume);
                    }
                }
        }
        } catch (InterruptedException e) {}
    }
}
