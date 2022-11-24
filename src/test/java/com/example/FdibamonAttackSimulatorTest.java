package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FdibamonAttackSimulatorTest {
    @Test
    public void testAttack() {
        Fdibamon fdibamon1 = new Fdibamon("testFdibamon1", 200, 50, SpecialPower.POWERATTACK, 50, 40);
        Fdibamon fdibamon2 = new Fdibamon("testFdibamon2", 100, 60, SpecialPower.POWERATTACK, 60, 70);

        FdibamonAttackSimulator attackSimulator = new FdibamonAttackSimulator();
        
        attackSimulator.successfulAttack(fdibamon1, fdibamon2);
        
        assertEquals(50, fdibamon2.getHitpoints());
    }

    @Test
    public void testPowerAttack() {
        Fdibamon fdibamon1 = new Fdibamon("testFdibamon1", 200, 50, SpecialPower.POWERATTACK, 50, 40);
        Fdibamon fdibamon2 = new Fdibamon("testFdibamon2", 100, 60, SpecialPower.POWERATTACK, 60, 70);

        FdibamonAttackSimulator attackSimulator = new FdibamonAttackSimulator();
        
        attackSimulator.useSpecialPowers(fdibamon1, fdibamon2);

        assertEquals(33, fdibamon2.getHitpoints());
    }

    @Test
    public void testJediHealing() {
        Fdibamon fdibamon1 = new Fdibamon("testFdibamon1", 200, 50, SpecialPower.JEDIHEALING, 50, 40);
        Fdibamon fdibamon2 = new Fdibamon("testFdibamon2", 100, 60, SpecialPower.JEDIHEALING, 60, 70);

        FdibamonAttackSimulator attackSimulator = new FdibamonAttackSimulator();
        
        attackSimulator.useSpecialPowers(fdibamon1, fdibamon2);

        assertEquals(600, fdibamon1.getHitpoints());
    }
}
