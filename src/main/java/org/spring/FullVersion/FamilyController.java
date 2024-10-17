package org.spring.FullVersion;

public class FamilyController {

   private final FamilyService familyService;


    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }


    public void createNewFamily(Human father, Human mother) {
     familyService.createNewFamily(father, mother);
    }

    public void displayAllFamilies() {
     familyService.displayAllFamilies();
    }

    public void getFamiliesBiggerThan(int size) {
     familyService.getFamiliesBiggerThan(size);

    }

    public Family getFamilyById(int id) {
     return familyService.getFamilyById(id);
    }

    public void bornChild(Family family, String michael, String sarah) {
     familyService.bornChild(family, michael, sarah);
    }

    public void deleteFamilyByIndex(int index) {
     familyService.deleteFamilyByIndex(index);
    }
}
