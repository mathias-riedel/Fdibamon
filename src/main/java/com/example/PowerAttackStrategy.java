package com.example;

public class PowerAttackStrategy implements SpecialPowerStrategy {
    @Override
    public SpecialPowerReturnValues useSpecialPower(Fdibamon attacker, Fdibamon attackee) {
        System.out.print(attacker.getName() + " benutzt Spezialkraft Power Attack!\n");
        int previousHitpoints = attackee.getHitpoints();
        int newAttackeeHitpoints = previousHitpoints / 3;
        SpecialPowerReturnValues returnValues = new SpecialPowerReturnValues(attacker.getHitpoints(), newAttackeeHitpoints);
        return returnValues;
    }
}
