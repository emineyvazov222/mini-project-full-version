package org.spring.FullVersion;

import java.util.Arrays;

public class Pet {
    public String species;
    public String nickname;
    public int age;
    public int trickLevel;
    public String[] habits;



    public void eat() {
        System.out.println("I am eating");
    }

    public void respond() {
        System.out.println("Hello, owner. I am - " + this.nickname + ". I miss you!");
    }

    public void foul() {
        System.out.println("I need to cover it up");
    }

    public Pet() {
    }

    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "age=" + age +
                ", species='" + species + '\'' +
                ", nickname='" + nickname + '\'' +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }

}
