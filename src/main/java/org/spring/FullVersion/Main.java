package org.spring.FullVersion;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Pet dog = new Dog("Buddy", 5, 75, new String[]{"playing", "barking"});
        Pet cat = new DomesticCat("Whiskers", 3, 50, new String[]{"sleeping", "purring"});
        Pet fish = new Fish("Nemo", 1, 0, new String[]{"swimming"});
        Pet roboCat = new RoboCat("Robo", 2, 80, new String[]{"charging", "cleaning"});

        dog.eat();
        dog.respond();
        if (dog instanceof Foulable) {
            ((Foulable) dog).foul();
        }

        cat.eat();
        cat.respond();
        if (cat instanceof Foulable) {
            ((Foulable) cat).foul();
        }

        fish.eat();
        fish.respond();

        roboCat.eat();
        roboCat.respond();
        if (roboCat instanceof Foulable) {
            ((Foulable) roboCat).foul();
        }


        Map<String, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY.name(), "Go to work");
        schedule.put(DayOfWeek.TUESDAY.name(), "Gym");

        Man father = new Man("John", "Doe", 1985, 90, schedule);
        Woman mother = new Woman("Jane", "Doe", 1988, 95, schedule);

        Family family = new Family(mother, father);
        System.out.println(family.bornChild());


    }

}
