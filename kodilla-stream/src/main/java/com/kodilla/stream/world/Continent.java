package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {

    private final List<Country> countryList = new ArrayList<>();

    public List<Country> getCountryList() {
        return new ArrayList<>(countryList);
    }

    public void addCountry(Country country) {
        countryList.add(country);
    }
}
