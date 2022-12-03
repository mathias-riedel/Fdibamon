package com.example;

public class PowerAttackStrategy implements SpecialPowerStrategy {
    @Override
    public SpecialPowerReturnValues useSpecialPower(Fdibamon attacker, Fdibamon attackee) {
        App.gameOutput.updateInfo(attacker.getName() + " benutzt Spezialkraft Power Attack!\n");
        long previousHitpoints = attackee.getHitpoints();
        long newAttackeeHitpoints = previousHitpoints / 3;
        return new SpecialPowerReturnValues(attacker.getHitpoints(), newAttackeeHitpoints);
    }
}
