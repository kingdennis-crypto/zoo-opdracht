package com.ing.zoo.animals;

import com.ing.zoo.interfaces.Animal;
import com.ing.zoo.interfaces.IEatMeat;

public class Fox extends Animal implements IEatMeat {
    public Fox(String name) {
        super(name, "Wa-wa-way-do, wub-wid-bid-dum-way-do, wa-wa-way-do");
    }

    @Override
    public void eatMeat() {
        System.out.println("Don't bother me while eating meat");
    }
}
