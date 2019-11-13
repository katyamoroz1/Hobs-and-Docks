package main;

import Generate.GenerateShips;
import ships.Ship;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        GenerateShips generate = new GenerateShips();
        generate.start();
    }
}

