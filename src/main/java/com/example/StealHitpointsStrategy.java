package com.example;

public class StealHitpointsStrategy implements SpecialPowerStrategy {
    @Override
    public SpecialPowerReturnValues useSpecialPower(Fdibamon attacker, Fdibamon attackee) {
        System.out.print(attacker.getName() + " benutzt Spezialkraft Steal-Hitpoints!\n");
        int previousAttackeeHitpoints = attackee.getHitpoints();
        int previousAttackerHitpoints = attacker.getHitpoints();
        int newAttackeeHitpoints = previousAttackeeHitpoints - 10;
        int newAttackerHitpoints = previousAttackerHitpoints + 10;
        SpecialPowerReturnValues returnValues = new SpecialPowerReturnValues(newAttackerHitpoints, newAttackeeHitpoints);
        return returnValues;
    }
}
