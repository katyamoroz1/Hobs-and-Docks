package station;
import java.util.concurrent.Semaphore;

public class Station {
//    public Station(String f, boolean busy) {
//        food = f;
//        isBusy = busy;
//    }
//
//    public String food;
//
//    public boolean isBusy;
//
//    public void accept (Ship ship) {
//        isBusy = true;
//        System.out.println("Корабль разгружен");
//    }

    public static final boolean[] stations = new boolean[3];
    public static final Semaphore SEMAPHORE = new Semaphore(3, true);
}
