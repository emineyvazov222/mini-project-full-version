package org.spring.FullVersion;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Family implements HumanCreator{

    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    public Family() {
    }

    public Family(Human father, Human mother) {
        this.father = father;
        this.mother = mother;
        this.children = new Human[0];
        this.mother.setFamily(this);
        this.father.setFamily(this);
    }

    public Family(Human[] children, Human father, Human mother, Pet pet) {
        this.children = children;
        this.father = father;
        this.mother = mother;
        this.pet = pet;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }


    public void addChild(Human child) {
        Human[] newChildren = Arrays.copyOf(children, children.length + 1);
        newChildren[children.length] = child;
        setChildren(newChildren);
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.length) {
            return false;
        }

        Human[] newChildren = new Human[children.length - 1];
        for (int i = 0, j = 0; i < children.length; i++) {
            if (i != index) {
                newChildren[j++] = children[i];
            }

        }
        children[index].setFamily(null);
        setChildren(newChildren);
        return true;
    }

    public int countFamily() {
        return children.length + 2;
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
        return Objects.hash(mother, father, Arrays.hashCode(children), pet);
    }

    @Override
    public String toString() {
        return "Family{" +
                "children=" + Arrays.toString(children) +
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

        boolean isBoy = random.nextBoolean(); //true or false

        if (isBoy) {
            childName = boyNames[random.nextInt(boyNames.length)];
        } else {
            childName = girlNames[random.nextInt(girlNames.length)];
        }

        int childIq = (this.mother.getIq() + this.father.getIq()) / 2;

        Human child = isBoy ? new Man(childName, this.father.getSurname(), 2024, childIq, null)
                : new Woman(childName, this.father.getSurname(), 2024, childIq, null);
        this.addChild(child);
        return child;
    }
}
