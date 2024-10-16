package org.spring.FullVersion;

import java.util.Arrays;
import java.util.Objects;

public abstract class Pet {

    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public Pet() {
    }

    public Pet(Species species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(Species species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = Species.UNKNOWN;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet(String nickname, int age, int trickLevel, String[] habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public void eat() {
        System.out.println(nickname + " is eating.");
    }

    public abstract void respond();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && trickLevel == pet.trickLevel && Objects.equals(species, pet.species) && Objects.equals(nickname, pet.nickname) && Objects.deepEquals(habits, pet.habits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, age, trickLevel, Arrays.hashCode(habits));
    }

    @Override
    public String toString() {
        return "Pet{" +
                "age=" + age +
                ", species='" + species + '\'' +
                ", nickname='" + nickname + '\'' +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                ", canFly=" + species.canFly() +
                ", numberOfLegs=" + species.getNumberOfLegs() +
                ", hasFur=" + species.hasFur() +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Garbage Collector in Pet class ....");
        super.finalize();
    }
}
