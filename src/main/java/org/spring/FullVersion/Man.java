package org.spring.FullVersion;

import java.util.Map;

public final class Man extends Human{

    public Man(String name, String surname, int year, int iq, Map<String, String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        System.out.println("Man " + getName() + " greets his pet with a strong handshake.");
    }

    public void repairCar() {
        System.out.println(getName() + " is repairing the car.");
    }
}
