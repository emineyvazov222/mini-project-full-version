package org.spring.FullVersion;

public class Main {
    public static void main(String[] args) {
        String[] habits = {"eat", "drink", "sleep"};
        Pet pet1 = new Pet("dog", "Rock", 5, 75, habits);
        System.out.println(pet1);
        pet1.eat();
        pet1.foul();
        pet1.respond();


        Human father = new Human("Vito", "Karleone", 1945);
        Human mother = new Human("Jane", "Karleone", 1955);

        String[][] schedule = {{"Monday", "go to school"}, {"Tuesday", "play football"}};
        Human human1 = new Human("Michael", "Karleone", 1977, 90, mother, father, pet1, schedule);
        System.out.println(human1);
        human1.greetPet();
        human1.describePet();
        human1.feedPet(false);


    }
}
