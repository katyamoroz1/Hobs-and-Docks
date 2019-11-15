package ships;

import Generate.GenerateShips;

import java.util.LinkedList;

public class Ship {
    public Ship(int volume, GenerateShips.Food fod) {
        this.volume = volume;
        this.fod = fod;
    }

    public int volume;
    public GenerateShips.Food fod;
    public static volatile java.util.Queue<Ship> shipsInQueue = new LinkedList<>();
    public static synchronized Ship firstShip(GenerateShips.Food fod) {
        if(!shipsInQueue.isEmpty() && shipsInQueue.peek().fod == fod) {
            return shipsInQueue.poll();
        }
        return null;
    }
}
