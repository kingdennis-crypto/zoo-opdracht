package com.ing.zoo;

import com.ing.zoo.interfaces.Animal;
import com.ing.zoo.interfaces.ICanPerformTrick;
import com.ing.zoo.interfaces.IEatLeaves;
import com.ing.zoo.interfaces.IEatMeat;

import java.util.*;

public class Zoo {
    private final Map<String, Animal> animals;

    public Zoo(Map<String, Animal> animals) {
        this.animals = animals;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the zoo!");

        while (true) {
            System.out.print("\nVoer uw commando in (exit om te stoppen): ");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                System.out.println("You haven't provided any command!");
                continue;
            }

            String[] inputList = input.trim().toLowerCase().split(" ");
            String command = inputList[0];

            if (command.equals("exit")) {
                break;
            }

            switch (command) {
                case "hello":
                    if (inputList.length == 1) {
                        getAllAnimals().forEach(Animal::sayHello);
                    } else {
                        String name = inputList[1];
                        Animal animalByName = animals.get(name);

                        if (animalByName == null) {
                            System.out.println("The animal by this name does not exist");
                        } else {
                            animalByName.sayHello();

                        }
                    }

                    break;
                case "give":
                    if (inputList.length == 1) {
                        System.out.println("Please give instructions on what to feed");
                    } else {
                        String food = inputList[1];
                        feedAnimals(food);
                    }
                    break;
                case "perform":
                    if (inputList.length == 1) {
                        System.out.println("Please give instructions on what to perform");
                    } else {
                        String action = inputList[1];
                        performAction(action);
                    }
                    break;
                default:
                    unknownCommand(command);
            }
        }
    }

    public List<Animal> getAllAnimals() {
        return new ArrayList<>(animals.values());
    }

    public void feedAnimals(String food) {
        switch (food) {
            case "leaves":
                getAnimalsByInterface(IEatLeaves.class).forEach(IEatLeaves::eatLeaves);
                break;
            case "meat":
                getAnimalsByInterface(IEatMeat.class).forEach(IEatMeat::eatMeat);
            default:
                System.out.println("Unknown food.");
        }
    }

    public void performAction(String action) {
        switch (action) {
            case "trick":
                getAnimalsByInterface(ICanPerformTrick.class).forEach(ICanPerformTrick::performTrick);
                break;
            default:
                System.out.println("Invalid action.");
        }
    }

    public <T> List<T> getAnimalsByInterface(Class<T> interfaceObj) {
        List<T> animalsWithInterface = new ArrayList<>();

        for (Animal animal : animals.values()) {
            if (interfaceObj.isInstance(animal)) {
                animalsWithInterface.add(interfaceObj.cast(animal));
            }
        }

        return animalsWithInterface;
    }

    public void unknownCommand(String command) {
        System.out.printf("Unknown command: %s%n", command);
    }
}
