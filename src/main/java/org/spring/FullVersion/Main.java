package org.spring.FullVersion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Map<String, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY.name(), "Go to work");
        schedule.put(DayOfWeek.TUESDAY.name(), "Gym");

        Human mother = new Woman("Anna", "Smith", 1985, 120, schedule);
        Human father = new Man("John", "Smith", 1980, 130, schedule);


        Family family = new Family(father, mother);

        Human child1 = new Man("Michael", "Smith", 2010, 110, schedule);
        family.addChild(child1);



        Human newChild = family.bornChild();
        System.out.println(newChild);

        System.out.println("Ailə üzvləri: ");
        System.out.println(family);


        System.out.println("Uşaqların siyahısı: ");
        for (Human child : family.getChildren()) {
            System.out.println(child.getName() + " " + child.getSurname());
        }


        System.out.println("Ailənin üzvlərinin sayı: " + family.countFamily());


        Set<Pet> pets = new HashSet<>();
        Pet dog = new Dog("Rex", 5, 70, Set.of("barking", "running"));
        pets.add(dog);
        family.setPet(pets);
        family.addPet(dog);

        System.out.println("Ev heyvanları: " + family.getPet());

    }

}
