package org.spring.FullVersion;

public class Fish extends Pet {

    public Fish(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.FISH);
    }

    @Override
    public void respond() {
        System.out.println("Fish " + getNickname() + " is swimming silently.");
    }

}
