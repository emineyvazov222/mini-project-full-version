package org.spring.FullVersion;

import java.util.List;
import java.util.Set;

public interface FamilyDao {

    List<Family> getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    void saveFamily(Family family);


}
