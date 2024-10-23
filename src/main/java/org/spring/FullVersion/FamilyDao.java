package org.spring.FullVersion;

import java.util.List;


public interface FamilyDao {

    List<Family> getAllFamilies();

    Family getFamilyByIndex(int index);

    boolean deleteFamily(int index);

    boolean deleteFamily(Family family);

    void saveFamily(Family family);

    void saveData(List<Family> families);

    List<Family> loadData();


}
