package main;

import Generate.GenerateShips;
import hobs.Person;
import station.BreadStation;
import station.MayonnaiseStation;
import station.SausageStation;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        GenerateShips generate = new GenerateShips();
        BreadStation bread = new BreadStation();
        SausageStation sausage = new SausageStation();
        MayonnaiseStation mayonnaise = new MayonnaiseStation();
        for (int i = 0; i < 8; i++) {
            Person hob = new Person("Hob № " + String.valueOf(i));
            hob.start();
        }
        generate.start();
        bread.start();
        sausage.start();
        mayonnaise.start();
    }
}

