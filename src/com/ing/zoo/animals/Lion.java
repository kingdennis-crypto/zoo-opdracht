package com.ing.zoo.animals;

import com.ing.zoo.interfaces.Animal;
import com.ing.zoo.interfaces.IEatMeat;

public class Lion extends Animal implements IEatMeat {
    public Lion(String name) {
        super(name, "roooaoaaaaar");
    }

    @Override
    public void eatMeat() {
        System.out.println("nomnomnom thx mate");
    }
}
