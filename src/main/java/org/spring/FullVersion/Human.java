package org.spring.FullVersion;

import java.util.Random;

public class Human {
    public String name;
    public String surname;
    public int year;
    public int iq;
    public Pet pet;
    public Human mother;
    public Human father;
    public String[][] schedule;


    public void greetPet() {
        System.out.println("Hello, " + this.name);
    }

    public void describePet() {
        String slyLevel = pet.trickLevel > 50 ? "very sly" : "almost not sly";
        System.out.println("I have an " + pet.species + " is " + pet.age + " years old, he is " + slyLevel);
    }

    public boolean feedPet(boolean timeToFeed) {
        if (timeToFeed) {
            System.out.println("Hm... I will feed " + this.name + "'s " + pet.species);
            return true;
        } else {
            Random random = new Random();
            int randomNumber = random.nextInt(101);
            //if I want to see randomNumber
//            System.out.println(randomNumber);

            if (pet.trickLevel > randomNumber) {
                System.out.println("Hm... I will feed " + this.name + "'s " + pet.species);
                return true;
            } else {
                System.out.println("I think " + this.name + "'s " + this.pet.species + " is not hungry.");
                return false;
            }
        }
    }


    public Human() {
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, Human father, Human mother) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.father = father;
        this.mother = mother;
    }

    public Human(String name, String surname, int year, int iq, Human mother, Human father, Pet pet, String[][] schedule) {
        this.father = father;
        this.iq = iq;
        this.mother = mother;
        this.name = name;
        this.pet = pet;
        this.schedule = schedule;
        this.surname = surname;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Human{name='" + name + "', surname='" + surname + "', year=" + year + ", iq=" + iq +
                ", mother=" + mother.name + " " + mother.surname + ", father=" + father.name + " " + father.surname +
                ", pet=" + pet.toString() + "}";
    }

}
