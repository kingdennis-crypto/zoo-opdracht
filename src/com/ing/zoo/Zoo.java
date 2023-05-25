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
                        break;
                    }

                    String name = inputList[1];
                    // TODO: Check if animal does not exist
                    Animal animalByName = animals.get(name);

                    if (animalByName == null) {
                        System.out.println("The animal by this name does not exist");
                    } else {
                        animalByName.sayHello();
                    }

                    break;
                case "give":
                    if (inputList.length == 1) {
                        System.out.println("Please give instructions on what to feed");
                        break;
                    }

                    switch (inputList[1]) {
                        case "leaves":
                            getAnimalsByInterface(IEatLeaves.class).forEach(IEatLeaves::eatLeaves);
                            break;
                        case "meat":
                            getAnimalsByInterface(IEatMeat.class).forEach(IEatMeat::eatMeat);
                            break;
                        default:
                            System.out.println("Unknown food");
                    }
                    break;
                case "perform":
                    if (inputList.length == 1) {
                        System.out.println("Please give instructions on what to perform");
                        break;
                    }

                    switch (inputList[1]) {
                        case "trick":
                            getAnimalsByInterface(ICanPerformTrick.class).forEach(ICanPerformTrick::performTrick);
                            break;
                        default:
                            System.out.println("Invalid perform");
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

    public <T> List<T> getAnimalsByInterface(Class<T> interfaceObj) {
        List<T> animalsWithInterface = new ArrayList<>();

        for (Animal<?> localAnimal : getAllAnimals()) {
            Class<?>[] interfaces = localAnimal.getClass().getInterfaces();

            for (Class<?> implementedInterface : interfaces) {
                if (interfaceObj.isAssignableFrom(implementedInterface)) {
                    animalsWithInterface.add(interfaceObj.cast(localAnimal));
                    break;
                }
            }
        }

        return animalsWithInterface;
    }

    public void unknownCommand(String command) {
        System.out.printf("Unknown command: %s%n", command);
    }
}
