package com.example;

import java.security.SecureRandom;
import java.util.Random;

public class FdibamonAttackSimulator {
    private Random rand = new SecureRandom();

    public void attack(Fdibamon attacker, Fdibamon attackee, boolean useSpecialPower) {
        if (useSpecialPower) {
            this.useSpecialPowers(attacker, attackee);
        }
        
        if (this.checkIfAttackIsSuccessful(attacker, attackee)) {
            this.successfulAttack(attacker, attackee);
        }
    }

    public void successfulAttack(Fdibamon attacker, Fdibamon attackee) {
        int remainingHitpointsOfEnemy = calculateRemainingHitpointsOfEnemy(attacker.getAttackPower(),
                attackee.getHitpoints());
        attackee.setHitpoints(remainingHitpointsOfEnemy);
    }

    public boolean checkIfAttackIsSuccessful(Fdibamon attacker, Fdibamon attackee) {
        int effectiveHitChance = this.rand.nextInt(attacker.getHitChance());
        int effectiveEvasionChance = this.rand.nextInt(attackee.getEvasionChance());

        System.out.println("Effektive Hit Chance von " + attacker.getName() + ": " + effectiveHitChance);
        System.out.println("Effektive Evasion Chance von " + attackee.getName() + ": " + effectiveEvasionChance);

        return effectiveHitChance > effectiveEvasionChance;
    }

    public void useSpecialPowers(Fdibamon attacker, Fdibamon attackee) {
        SpecialPowerStrategy specialPowerStrategy;

        switch (attacker.getSpecialPower()) {
            case POWERATTACK:
                specialPowerStrategy = new PowerAttackStrategy();
                break;
            case JEDIHEALING:
                specialPowerStrategy = new JediHealingStrategy();
                break;
            default:
                specialPowerStrategy = new StealHitpointsStrategy();
                break;
        }

        SpecialPowerReturnValues returnValues = specialPowerStrategy.useSpecialPower(attacker, attackee);
        attacker.setHitpoints(returnValues.getAttackerHitpoints());
        attackee.setHitpoints(returnValues.getAttackeeHitpoints());
    }

    private int calculateRemainingHitpointsOfEnemy(int attackPower, int currentHitpointsOfEnemy) {
        int remainingHitpointsOfEnemy = currentHitpointsOfEnemy - attackPower;

        if (remainingHitpointsOfEnemy < 0) {
            remainingHitpointsOfEnemy = 0;
        }

        return remainingHitpointsOfEnemy;
    }
}
