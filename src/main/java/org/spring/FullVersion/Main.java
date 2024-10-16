package org.spring.FullVersion;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        String[] arr = {"eat", "drink", "sleep"};
        Pet pet1 = new Pet(Species.CAT, "Ares", 6, 80, arr);
        System.out.println(pet1);

        Map<DayOfWeek, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY, "go to school");
        schedule.put(DayOfWeek.TUESDAY, "play football");

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
