package org.spring.FullVersion;

import java.util.Map;
import java.util.Objects;

public class Human {

    private String name;
    private String surname;
    private int year;
    private int iq;
    private Family family;
    private Map<String, String> schedule;

    public Human() {
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, Human father, Human mother) {
        this.name = name;
        this.surname = surname;
        this.year = year;

    }

    public Human(String name, String surname, int year, int iq, Map<String, String>  schedule) {
        this.name = name;
        this.iq = iq;
        this.schedule = schedule;
        this.surname = surname;
        this.year = year;
    }



    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Map<String, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, String> schedule) {
        this.schedule = schedule;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void greetPet() {
        System.out.println("Hello, " + this.name);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(family, human.family) && Objects.deepEquals(schedule, human.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, iq, family, schedule);
    }

    @Override
    public String toString() {
        return "Human{name='" + name + "', surname='" + surname + "', year=" + year + ", iq=" + iq +
                ", schedule=" + schedule +
                "}";
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("Garbage Collector in Human class ...");
        super.finalize();
    }

}
