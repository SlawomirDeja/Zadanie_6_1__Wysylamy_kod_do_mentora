package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        Continent continent1 = new Continent();
        Continent continent2 = new Continent();
        Continent continent3 = new Continent();

        for (int i = 0; i < 4; i++) {
            continent1.addCountry(new Country(new BigDecimal(100)));
            continent2.addCountry(new Country(new BigDecimal(100)));
            continent3.addCountry(new Country(new BigDecimal(100)));
        }

        World world = new World();

        world.addContinent(continent1);
        world.addContinent(continent2);
        world.addContinent(continent3);

        //When
        //Then
        assertEquals(new BigDecimal(1200), world.getPeopleQuantity());
    }
}
