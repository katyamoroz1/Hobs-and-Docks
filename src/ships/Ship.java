package ships;

import Generate.GenerateShips;

import java.util.LinkedList;

public class Ship {
    public Ship(int volume, GenerateShips.food fod) {
        this.volume = volume;
        this.fod = fod;
    }

    public int volume;
    public GenerateShips.food fod;
    public static volatile java.util.Queue<Ship> shipsInQueue = new LinkedList<>();
    public static synchronized Ship firstShip(GenerateShips.food fod) {
        if(!shipsInQueue.isEmpty() && shipsInQueue.peek().fod == fod) {
            return shipsInQueue.poll();
        }
        return null;
    }
}
