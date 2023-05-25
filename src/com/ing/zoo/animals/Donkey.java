package com.ing.zoo.animals;

import com.ing.zoo.interfaces.Animal;
import com.ing.zoo.interfaces.ICanPerformTrick;
import com.ing.zoo.interfaces.IEatLeaves;

import java.util.Random;

public class Donkey extends Animal implements IEatLeaves, ICanPerformTrick {
    public Donkey(String name) {
        super(name, "hee-haw");
    }

    @Override
    public void eatLeaves() {
        System.out.println("Oh, this is another one of those \"onion\" things, isn't it?");
    }

    @Override
    public void performTrick() {
        Random random = new Random();
        int rnd = random.nextInt(2);
        String trick;

        if (rnd == 0) {
            trick = "Donkey says: \"I'm a donkey on the edge!\"";
        } else {
            trick = "Donkey says: \"Blue flower, red thorns. This would be so much easier if I wasn't color-blind!\"";
        }

        System.out.println(trick);
    }
}
