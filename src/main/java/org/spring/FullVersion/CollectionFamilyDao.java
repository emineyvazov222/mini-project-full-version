package org.spring.FullVersion;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {

    private List<Family> families = new ArrayList<>();


    @Override
    public List<Family> getAllFamilies() {
        return new ArrayList<>(families);
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (index >= 0 && index < families.size()) {
            return families.get(index);
        }
        return null;
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index >= 0 && index < families.size()) {
            families.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return families.remove(family);
    }

    @Override
    public void saveFamily(Family family) {
        int index = families.indexOf(family);
        if (index >= 0) {
            families.set(index, family);
        } else {
            families.add(family);
        }


    }

    @Override
    public void saveData(List<Family> families) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("families.dat"))) {
            oos.writeObject(families);
            System.out.println("Data saved to file.");
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }

    }

    @Override
    public List<Family> loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("families.dat"))) {
            families = (List<Family>) ois.readObject();
            System.out.println("Data loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
        return families;
    }


}
