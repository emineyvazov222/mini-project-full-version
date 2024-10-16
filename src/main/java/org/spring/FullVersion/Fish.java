package org.spring.FullVersion;

import java.util.Set;

public class Fish extends Pet {

    public Fish(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.FISH);
    }

    @Override
    public void respond() {
        System.out.println("Fish " + getNickname() + " is swimming silently.");
    }

}
