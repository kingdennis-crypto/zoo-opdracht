package com.ing.zoo.animals;

import com.ing.zoo.interfaces.Animal;
import com.ing.zoo.interfaces.ICanPerformTrick;
import com.ing.zoo.interfaces.IEatLeaves;

import java.util.Random;

public class Zebra extends Animal implements IEatLeaves {
    public Zebra(String name) {
        super(name, "zebra zebra");
    }

    @Override
    public void eatLeaves() {
        System.out.println("munch munch zank yee bra");
    }
}
