package org.spring.FullVersion;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService {

    private final FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        List<Family> allFamilies = familyDao.getAllFamilies();
        for (int i = 0; i < allFamilies.size(); i++) {
            System.out.println(i + ": " + allFamilies.get(i));
        }

    }

    public List<Family> getFamiliesBiggerThan(int size) {
        return familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() > size)
                .collect(Collectors.toList());
    }

    public List<Family> getFamiliesLessThan(int size) {
        return familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() < size)
                .collect(Collectors.toList());
    }

    public long countFamiliesWithMemberNumber(int size) {
        return familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() == size)
                .count();
    }

    public void createNewFamily(Human father, Human mother) {
        Family newFamily = new Family(father, mother);
        familyDao.saveFamily(newFamily);
    }

    public boolean deleteFamilyByIndex(int index) {
        if (index >= 0 && index < familyDao.getAllFamilies().size()) {
            familyDao.deleteFamily(index);
            return true;
        }
        return false;


    }

    public Family bornChild(Family family, String masculine, String feminine) {
        Human child = new Human();
        if (Math.random() > 0.5) {
            child.setName(masculine);
        } else {
            child.setName(feminine);
        }
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Family family, Human child) {
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThen(int age) {
        for (Family family : familyDao.getAllFamilies()) {
//            family.getChildren().removeIf(child -> child.getAge() > age);
            familyDao.saveFamily(family);
        }
    }


    public int count() {
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public List<Pet> getPets(int index) {
        Family familyByIndex = familyDao.getFamilyByIndex(index);
        if (familyByIndex != null) {
            return (List<Pet>) familyByIndex.getPet();
        }
        return Collections.emptyList();
    }


    public void addPet(int index, Pet pet) {
        Family family = familyDao.getFamilyByIndex(index);
        if (family != null) {
            family.getPet().add(pet);
            familyDao.saveFamily(family);
        }
    }


}
