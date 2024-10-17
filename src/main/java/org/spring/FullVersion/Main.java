package org.spring.FullVersion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        FamilyDao familyDao = new CollectionFamilyDao();
        FamilyService familyService = new FamilyService(familyDao);
        FamilyController familyController = new FamilyController(familyService);

        Human father = new Human("John", "Doe", 1980);
        Human mother = new Human("Jane", "Doe", 1982);
        familyController.createNewFamily(father, mother);

        Human father2 = new Human("John", "Doe", 1981);
        Human mother2 = new Human("Jane", "Doe", 1983);
        familyController.createNewFamily(father2, mother2);


        familyController.displayAllFamilies();

        familyController.getFamiliesBiggerThan(0);


        Family family = familyController.getFamilyById(0);
        System.out.println(family);

        System.out.println(mother2.describeAge());

        familyController.bornChild(family, "Michael", "Sarah");


        familyController.deleteFamilyByIndex(0);

    }

}
