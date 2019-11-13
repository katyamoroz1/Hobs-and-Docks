package main;

import ships.Ship;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 2; i++) {
            new Thread(new Ship(200, "хлеб")).start();
            Thread.sleep(400);
        }
        for (int i = 1; i <= 2; i++) {
            new Thread(new Ship(200, "сосиска")).start();
            Thread.sleep(400);
        }
        for (int i = 1; i <= 2; i++) {
            new Thread(new Ship(200, "майонез")).start();
            Thread.sleep(400);
        }
    }
}

