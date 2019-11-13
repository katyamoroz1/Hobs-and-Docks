package ships;

import Generate.GenerateShips;
import station.Station;

public class Ship {
    public Ship(int volume, GenerateShips.food fod) {
        this.volume = volume;
        this.fod = fod;
    }

    public int volume;
    public GenerateShips.food fod;
}
