package com.crackingthecodinginterview.javapractice;

import java.util.LinkedList;
import java.util.Queue;

abstract class Animal {

    private int order;
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return this.order;
    }

    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }

}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }
}

public class AnimalShelter {

    private Queue<Dog> dogs = new LinkedList<Dog>();
    private Queue<Cat> cats = new LinkedList<Cat>();
    private int order = 0;

    public void enqueue(Animal a) {
        a.setOrder(order);
        order++;
        if (a instanceof Dog) {
            dogs.add((Dog) a);
        } else if (a instanceof Cat) {
            cats.add((Cat) a);
        }
    }

    public Animal dequeueAny() {
        if (dogs.size() == 0) {
            return dequeueCats();
        } else if (cats.size() == 0) {
            return dequeueDogs();
        }
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.isOlderThan(cat)) {
            return dequeueDogs();
        } else {
            return dequeueCats();
        }
    }

    public Dog dequeueDogs() {
        return dogs.poll();
    }

    public Cat dequeueCats() {
        return cats.poll();
    }

    public static void main(String[] args) {

        AnimalShelter as = new AnimalShelter();
        as.enqueue(new Dog("a"));
        as.enqueue(new Cat("b"));
        as.enqueue(new Dog("c"));
        as.enqueue(new Dog("d"));
        as.enqueue(new Dog("e"));
        as.enqueue(new Cat("f"));
        System.out.println(as.dequeueAny().name);
        System.out.println(as.dequeueCats().name);
        System.out.println(as.dequeueDogs().name);

    }

}
