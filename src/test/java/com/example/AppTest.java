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
        
        Fdibamon jan = new Fdibamon("Jan", 100, 60, SpecialPower.JEDIHEALING, 50, 40);
        Fdibamon rado = new Fdibamon("Rado", 50, 30, SpecialPower.POWERATTACK, 30, 20);
        Fdibamon klaus = new Fdibamon("Klaus", 10, 3, SpecialPower.POWERATTACK, 10, 25);
        Fdibamon mathias = new Fdibamon("Mathias", 100, 50, SpecialPower.JEDIHEALING, 30, 15);
        Fdibamon nikolay = new Fdibamon("Nikolay", 20, 15, SpecialPower.POWERATTACK, 17, 10);
        
        fdibamons.add(jan);
        fdibamons.add(rado);
        fdibamons.add(klaus);
        fdibamons.add(mathias);
        fdibamons.add(nikolay);

        return fdibamons;
    }
}
