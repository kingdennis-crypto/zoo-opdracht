package com.ing.zoo.animals;

import com.ing.zoo.interfaces.Animal;
import com.ing.zoo.interfaces.IEatLeaves;

public class Hippo extends Animal implements IEatLeaves {
    public Hippo(String name) {
        super(name, "splash");
    }

    @Override
    public void eatLeaves() {
        System.out.println("munch munch lovely");
    }
}
