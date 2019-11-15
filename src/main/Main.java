package main;

import Generate.GenerateShips;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import hobs.Person;
import org.slf4j.LoggerFactory;
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
        for (int i = 0; i < 8; i++) {
            Person hob = new Person(String.valueOf(i));
            hob.start();
        }
        generate.start();
        bread.start();
        sausage.start();
        mayonnaise.start();
    }
}

