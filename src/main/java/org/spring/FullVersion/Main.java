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


        Map<DayOfWeek, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY, "Go to work");
        schedule.put(DayOfWeek.TUESDAY, "Gym");

        Man father = new Man("John", "Doe", 1985, 90, schedule);
        Woman mother = new Woman("Jane", "Doe", 1988, 95, schedule);

        Family family = new Family(mother, father);



        String[] arr = {"eat", "drink", "sleep"};
        Pet pet1 = new Pet(Species.CAT, "Ares", 6, 80, arr);
        System.out.println(pet1);

        Map<String, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY.name(), "go to school");
        schedule.put(DayOfWeek.TUESDAY.name(), "play football");

        father.greetPet();
        mother.greetPet();
        Human human = new Human("Irshad", "Eyvazov", 1995, 95, schedule);


        Human child = family.bornChild();
        System.out.println("Child born: " + child);

        System.out.println("Family members:");
        System.out.println(family);

        System.out.println("Animal activities:");
        for (Map.Entry<String, String> entry : schedule.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Human father = new Human("Elsen", "Eyvazov", 1970, 90, schedule);
        Human mother = new Human("Elnare", "Eyvazova", 1975, 85, schedule);

        Family family = new Family(father, mother);


        Human child1 = new Human("Eltac", "Eyvazova", 1990);
        Human child2 = new Human("Aytac", "Eyvazova", 1995);
        family.addChild(child1);
        family.addChild(child2);


        family.setPet(pet1);
        System.out.println(family);

        System.out.println(family.countFamily());

        family.deleteChild(0);
        System.out.println(family.countFamily());
    }

}
