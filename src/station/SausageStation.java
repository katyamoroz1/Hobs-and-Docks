package station;
import ships.Ship;
import Generate.GenerateShips;


public class SausageStation extends Thread {
    public SausageStation() {
    }

    @Override
    public void run() {
        try {
            while (true) {
                Ship ship = Ship.firstShip(GenerateShips.food.sausage);
                if (ship != null) {
                    if (ship.fod == GenerateShips.food.sausage) {
                    sleep(1000 * ship.volume / 5);
                            System.out.printf("Корабль с %d килограммами сосисок разгрузился!\n", ship.volume);
                        }
                    }
            }
        } catch (InterruptedException e) {}
    }
}
