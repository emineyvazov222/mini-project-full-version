package org.spring.FullVersion;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {

    private List<Family> familyDatabase = new ArrayList<>();


    @Override
    public List<Family> getAllFamilies() {
        return familyDatabase;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (index >= 0 && index < familyDatabase.size()) {
            return familyDatabase.get(index);
        }
        return null;
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index >= 0 && index < familyDatabase.size()) {
            familyDatabase.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return familyDatabase.remove(family);
    }

    @Override
    public void saveFamily(Family family) {
        if (!familyDatabase.contains(family)) {
            familyDatabase.add(family);
        }


    }
}
