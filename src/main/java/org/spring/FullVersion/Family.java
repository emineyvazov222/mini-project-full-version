package org.spring.FullVersion;

import java.util.Arrays;
import java.util.Objects;

public class Family {
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
            } else {
                children[i].setFamily(null);
            }
        }
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
                ", pet=" + pet.toString() +
                '}';
    }
}
