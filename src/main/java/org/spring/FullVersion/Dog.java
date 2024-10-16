package org.spring.FullVersion;

import java.util.Set;

public class Dog extends Pet implements Foulable {

    public Dog(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.DOG);
    }

    @Override
    public void respond() {
        System.out.println("Dog " + getNickname() + " is barking.");
    }

    @Override
    public void foul() {
        System.out.println(getNickname() + " made a mess!");
    }


}
