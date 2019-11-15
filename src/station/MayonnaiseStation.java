package station;
import ships.Ship;
import Generate.GenerateShips;


public class MayonnaiseStation extends Thread {
    public MayonnaiseStation() {
    }

    @Override
    public void run() {
        try {
            while (true) {
                Ship ship = Ship.firstShip(GenerateShips.food.mayonnaise);
                if (ship != null) {
                    if (ship.fod == GenerateShips.food.mayonnaise) {
                    sleep(1000 * ship.volume / 5);
                            System.out.printf("Корабль с %d килограммами майонеза разгрузился!\n", ship.volume);
                        }
                    }
            }
        } catch (InterruptedException e) {}
    }
}
