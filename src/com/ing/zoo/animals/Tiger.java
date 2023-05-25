package com.ing.zoo.animals;

import com.ing.zoo.interfaces.Animal;
import com.ing.zoo.interfaces.ICanPerformTrick;
import com.ing.zoo.interfaces.IEatMeat;

import java.util.Random;

public class Tiger extends Animal implements IEatMeat, ICanPerformTrick {
    public Tiger(String name) {
        super(name, "rraaarww");
    }

    @Override
    public void eatMeat() {
        System.out.println("nomnomnom oink wubalubadubdub");
    }

    @Override
    public void performTrick() {
        Random random = new Random();
        int rnd = random.nextInt(2);
        String trick;

        if (rnd == 0) {
            trick = "jumps in tree";
        } else {
            trick = "scratches ears";
        }

        System.out.println(trick);
    }
}
