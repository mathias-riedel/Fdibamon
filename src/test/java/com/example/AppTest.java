package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AppTest 
{
    List<Fdibamon> fdibamons;

    @Before
    public void setup() {
        fdibamons = initializeFdibamonsForTesting();
    }

    @Test
    public void fdibamonsShouldBeEqualIfNameIsTheSame() {
        Fdibamon rado = fdibamons.get(1);
        
        Fdibamon fdibamon = App.getFdibamonFromList(fdibamons, "Rado");
        assertEquals(fdibamon, rado);
    }

    @Test
    public void fdibamonsShouldNotBeEqualIfNamesAreDifferent() {
        Fdibamon klaus = fdibamons.get(2);
        
        Fdibamon fdibamon = App.getFdibamonFromList(fdibamons, "Rado");
        assertNotEquals(fdibamon, klaus);
    }

    @Test
    public void fdibamonShouldBeNullIfNameIsInvalid() {
        Fdibamon fdibamon = App.getFdibamonFromList(fdibamons, "NotAName");
        assertEquals(null, fdibamon);
    }

    @Test
    public void atLeastOneFdibamonSHouldBeDead() {
        Fdibamon klaus = fdibamons.get(2);
        Fdibamon jan = fdibamons.get(0);

        App.fight(klaus, jan);

        assertTrue(jan.getHitpoints() == 0 || klaus.getHitpoints() == 0);
    }

    public static List<Fdibamon> initializeFdibamonsForTesting() {
        List<Fdibamon> fdibamons = new ArrayList<>();
        
        Fdibamon jan = new Fdibamon("Jan", 60, 8, SpecialPower.JEDIHEALING, 50, 20);
        Fdibamon rado = new Fdibamon("Rado", 40, 6, SpecialPower.POWERATTACK, 30, 30);
        Fdibamon klaus = new Fdibamon("Klaus", 30, 4, SpecialPower.STEALHITPOINTS, 10, 15);
        Fdibamon mathias = new Fdibamon("Mathias", 50, 9, SpecialPower.JEDIHEALING, 30, 10);
        Fdibamon nikolay = new Fdibamon("Nikolay", 20, 5, SpecialPower.POWERATTACK, 2, 5);
        
        fdibamons.add(jan);
        fdibamons.add(rado);
        fdibamons.add(klaus);
        fdibamons.add(mathias);
        fdibamons.add(nikolay);

        return fdibamons;
    }
}
