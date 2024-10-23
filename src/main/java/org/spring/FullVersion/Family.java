package org.spring.FullVersion;


import java.io.Serializable;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Family implements HumanCreator {

    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pet;

    public Family() {
    }

    public Family(Human father, Human mother) {
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
        this.mother.setFamily(this);
        this.father.setFamily(this);
    }

    public Family(List<Human> children, Human father, Human mother, Set<Pet> pet) {
        this.children = children;
        this.father = father;
        this.mother = mother;
        this.pet = pet;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
        father.setFamily(this);
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
        mother.setFamily(this);
    }

    public Set<Pet> getPet() {
        return pet;
    }

    public void setPet(Set<Pet> pet) {
        this.pet = pet;
    }


    public void addChild(Human child) {
        List<Human> childrenList = new ArrayList<>(children);
        childrenList.add(child);
        setChildren(childrenList);
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.size()) {
            return false;
        }

        children.get(index).setFamily(null);
        children.remove(index);
        return true;
    }

    public int countFamily() {
        return children.size() + 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father) && Objects.deepEquals(children, family.children) && Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, children, pet);
    }

    @Override
    public String toString() {
        return "Family{" +
                "children=" + children +
                ", mother=" + mother +
                ", father=" + father +
                ", pet=" + pet +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Garbage Collector in Family class ....");
        super.finalize();
    }

    @Override
    public Human bornChild() {

        Random random = new Random();

        String[] boyNames = {"John", "Michael", "David"};
        String[] girlNames = {"Anna", "Emily", "Sophia"};

        String childName;

        boolean isBoy = random.nextBoolean();

        childName = isBoy ? boyNames[random.nextInt(boyNames.length)] : girlNames[random.nextInt(girlNames.length)];

        int childIq = (this.mother.getIq() + this.father.getIq()) / 2;

        Human child = isBoy ? new Man(childName, this.father.getSurname(), 2024, childIq, null)
                : new Woman(childName, this.father.getSurname(), 2024, childIq, null);
        this.addChild(child);
        return child;
    }

    public void addPet(Pet pets) {
        if (pets != null) {
            pet.add(pets);
        } else {
            System.out.println("Pet cannot be null.");
        }
    }

    public String prettyFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append("family:\n");
        sb.append("\tmother: ").append(mother.prettyFormat()).append(",\n");
        sb.append("\tfather: ").append(father.prettyFormat()).append(",\n");

        sb.append("\tchildren:\n");
        for (Human child : children) {
            String gender = (child instanceof Man) ? "Boy" : "Girl";
            sb.append(gender).append("\\n\"").append(child.prettyFormat()).append("\n");
        }

        sb.append("\tpets:\n");
        for (Pet pets : pet) {
            sb.append("\t\t").append(pets.prettyFormat()).append("\n");
        }

        return sb.toString();

    }


}
