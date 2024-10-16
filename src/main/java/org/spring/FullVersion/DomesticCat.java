package org.spring.FullVersion;

public class DomesticCat extends Pet implements Foulable {

    public DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.CAT);
    }

    @Override
    public void respond() {
        System.out.println("Cat " + getNickname() + " is meowing.");
    }

    @Override
    public void foul() {
        System.out.println(getNickname() + " scratched the furniture!");
    }


}
