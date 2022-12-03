package com.example;

public class StealHitpointsStrategy implements SpecialPowerStrategy {
    @Override
    public SpecialPowerReturnValues useSpecialPower(Fdibamon attacker, Fdibamon attackee) {
        App.gameOutput.updateInfo(attacker.getName() + " benutzt Spezialkraft Steal-Hitpoints!\n");
        long previousAttackeeHitpoints = attackee.getHitpoints();
        long previousAttackerHitpoints = attacker.getHitpoints();
        long newAttackeeHitpoints = previousAttackeeHitpoints - 10;
        long newAttackerHitpoints = previousAttackerHitpoints + 10;
        SpecialPowerReturnValues returnValues = new SpecialPowerReturnValues(newAttackerHitpoints, newAttackeeHitpoints);
        return returnValues;
    }
}
