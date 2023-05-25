package com.ing.zoo;

import com.ing.zoo.animals.*;
import com.ing.zoo.interfaces.Animal;

import java.util.HashMap;
import java.util.Map;

public class MainApplication {
    private final static Map<String, Animal> animals = new HashMap<>();

    public static void main(String[] args) {
        animals.put("henk", new Lion("Henk"));
        animals.put("elsa", new Hippo("Elsa"));
        animals.put("dora", new Pig("Dora"));
        animals.put("wally", new Tiger("Wally"));
        animals.put("marty", new Zebra("Marty"));
        animals.put("donkey", new Donkey("Donkey"));
        animals.put("wilfred", new Fox("Wilfred"));

        Zoo zoo = new Zoo(animals);
        zoo.run();
    }
}
