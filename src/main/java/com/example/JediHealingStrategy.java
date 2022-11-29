package com.example;

public class JediHealingStrategy implements SpecialPowerStrategy {
    @Override
    public SpecialPowerReturnValues useSpecialPower(Fdibamon attacker, Fdibamon attackee) {
        System.out.print(attacker.getName() + " benutzt Spezialkraft Jedi Healing!\n");
        int previousHitpoints = attacker.getHitpoints();
        int newAttackerHitpoints = previousHitpoints * 3;
        SpecialPowerReturnValues returnValues = new SpecialPowerReturnValues(newAttackerHitpoints, attackee.getHitpoints());
        return returnValues;
    }
}