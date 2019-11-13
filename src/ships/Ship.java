package ships;

import station.Station;

public class Ship implements Runnable{
    public Ship(int v, String f) {
        volume = v;
        food = f;
    }

    public int volume;

    public String food;
    @Override
    public void run() {
        System.out.printf("Корабль с %s хочет разгрузиться\n", food);
        try{
            Station.SEMAPHORE.acquire();
            int station = -1;
            synchronized (Station.stations){
                for (int i = 0; i < 5; i++)
                    if (!Station.stations[i]) {
                        Station.stations[i] = true;
                        station = i;
                        System.out.printf("Корабль %s припарковался на месте %d.\n", food, i);
                        break;
                    }
            }

            Thread.sleep(5000);

            synchronized (Station.stations) {
                Station.stations[station] = false;
            }

            Station.SEMAPHORE.release();
            System.out.printf("Корабль %s разгрузился.\n", food);
        } catch (InterruptedException e) {
        }
    }
}
