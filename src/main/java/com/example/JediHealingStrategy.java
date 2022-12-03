package com.example;

public class JediHealingStrategy implements SpecialPowerStrategy {
    @Override
    public SpecialPowerReturnValues useSpecialPower(Fdibamon attacker, Fdibamon attackee) {
        App.gameOutput.updateInfo(attacker.getName() + " benutzt Spezialkraft Jedi Healing!\n");
        long previousHitpoints = attacker.getHitpoints();
        long newAttackerHitpoints = previousHitpoints * 2;
        return new SpecialPowerReturnValues(newAttackerHitpoints, attackee.getHitpoints());
    }
}