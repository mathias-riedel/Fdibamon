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
        if (attacker.getSpecialPower() == SpecialPower.POWERATTACK) {
            int previousHitpoints = attackee.getHitpoints();
            int newHitpoints = previousHitpoints / 3;
            attackee.setHitpoints(newHitpoints);
            System.out.print(attacker.getName() + " benutzt Spezialkraft Power Attack!\n");
        } else {
            int previousHitpoints = attacker.getHitpoints();
            int newHitpoints = previousHitpoints * 3;
            attacker.setHitpoints(newHitpoints);
            System.out.print(attacker.getName() + " benutzt Spezialkraft Jedi Healing!\n");
        }
    }

    private int calculateRemainingHitpointsOfEnemy(int attackPower, int currentHitpointsOfEnemy) {
        int remainingHitpointsOfEnemy = currentHitpointsOfEnemy - attackPower;

        if (remainingHitpointsOfEnemy < 0) {
            remainingHitpointsOfEnemy = 0;
        }

        return remainingHitpointsOfEnemy;
    }
}
