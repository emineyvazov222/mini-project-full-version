package org.spring.FullVersion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Human {

    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private Family family;
    private Map<String, String> schedule;


    public Human() {
    }

    public Human(String name, String surname, long birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public Human(String name, String surname, long birthDate, Human father, Human mother) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;

    }

    public Human(String name, String surname, long birthDate, int iq, Map<String, String> schedule) {
        this.name = name;
        this.iq = iq;
        this.schedule = schedule;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public Human(String name, String surname, String birthDateString, int iq) {
        this.name = name;
        this.surname = surname;
        this.iq = iq;
        this.birthDate = convertToMillis(birthDateString);
    }

    private long convertToMillis(String birthDateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(birthDateString, formatter);
        return birthDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();

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

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int year) {
        this.birthDate = year;
    }

    public void greetPet() {
        System.out.println("Hello, " + this.name);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(family, human.family) && Objects.deepEquals(schedule, human.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, iq, family, schedule);
    }

    public String describeAge() {
        LocalDate birthDate = Instant.ofEpochMilli(this.birthDate)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate currentDate = LocalDate.now();

        Period age = Period.between(birthDate, currentDate);

        return String.format("%d years, %d months, and %d days old",
                age.getYears(), age.getMonths(), age.getDays());
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("Name: %s, Surname: %s, Birth Date: %s, IQ: %d",
                name, surname, dateFormat.format(new Date(birthDate)), iq);
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("Garbage Collector in Human class ...");
        super.finalize();
    }


}
