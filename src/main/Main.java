package main;

import Generate.GenerateShips;
import ships.Ship;
import station.BreadStation;
import station.MayonnaiseStation;
import station.SausageStation;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        GenerateShips generate = new GenerateShips();
        BreadStation bread = new BreadStation();
        SausageStation sausage = new SausageStation();
        MayonnaiseStation mayonnaise = new MayonnaiseStation();
        generate.start();
        bread.start();
        sausage.start();
        mayonnaise.start();
    }
}

