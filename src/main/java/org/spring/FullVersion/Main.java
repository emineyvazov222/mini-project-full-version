package org.spring.FullVersion;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"eat", "drink", "sleep"};
        Pet pet1 = new Pet("cat", "Ares", 6, 80, arr);
        System.out.println(pet1);
        String[][] schedule = {{"Monday", "go to school"}, {"Tuesday", "play football"}};

        Human father = new Human("Elsen", "Eyvazov", 1970,85,schedule);
        Human mother = new Human("Elnare", "Eyvazova", 1975,80,schedule);

        Family family = new Family(father, mother);

        Human child1 = new Human("Eltac", "Eyvazova", 1990,90, schedule);
        Human child2 = new Human("Aytac", "Eyvazova", 1995,95, schedule);
        family.addChild(child1);
        family.addChild(child2);

        family.setPet(pet1);
        System.out.println(family);

        System.out.println(family.countFamily());

        family.deleteChild(0);
        System.out.println(family.countFamily());



    }
}
