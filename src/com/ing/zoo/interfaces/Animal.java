package com.ing.zoo.interfaces;

public abstract class Animal<T> {
//    String getName();
//    void sayHello();
//    void performTrick();
//    boolean canPerformTrick();

    private final String name;
    private final String helloText;

    public Animal(String name, String helloText) {
        this.name = name;
        this.helloText = helloText;
    }

    public void sayHello() {
        System.out.println(helloText);
    }

    @Override
    public String toString() {
        return String.format("Hello my name is %s", this.name);
    }
}
