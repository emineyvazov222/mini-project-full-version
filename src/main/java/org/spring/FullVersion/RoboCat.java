package org.spring.FullVersion;

import java.util.Set;

public class RoboCat extends Pet implements Foulable {

    public RoboCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.ROBOCAT);
    }

    @Override
    public void respond() {
        System.out.println("RoboCat " + getNickname() + " is beeping.");
    }

    @Override
    public void foul() {
        System.out.println(getNickname() + " malfunctioned and spilled oil!");
    }
}
