package com.example;

public class SpecialPowerReturnValues {
    private int attackerHitpoints;
    private int attackeeHitpoints;
    
    public SpecialPowerReturnValues(int attackerHitpoints, int attackeeHitpoints) {
        this.attackerHitpoints = attackerHitpoints;
        this.attackeeHitpoints = attackeeHitpoints;
    }
    public int getAttackerHitpoints() {
        return attackerHitpoints;
    }
    public void setAttackerHitpoints(int attackerHitpoints) {
        this.attackerHitpoints = attackerHitpoints;
    }
    public int getAttackeeHitpoints() {
        return attackeeHitpoints;
    }
    public void setAttackeeHitpoints(int attackeeHitpoints) {
        this.attackeeHitpoints = attackeeHitpoints;
    }

    
}
