package org.spring.FullVersion;

import java.util.Map;

public final class Woman extends Human{

    public Woman(String name, String surname, int year, int iq, Map<DayOfWeek, String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        System.out.println("Woman " + getName() + " greets her pet with a soft pat.");
    }

    public void makeup() {
        System.out.println(getName() + " is putting on makeup.");
    }


}
