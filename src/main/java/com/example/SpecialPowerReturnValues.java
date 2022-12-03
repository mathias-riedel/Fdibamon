package com.example;

public class SpecialPowerReturnValues {
    private long attackerHitpoints;
    private long attackeeHitpoints;
    
    public SpecialPowerReturnValues(long attackerHitpoints, long attackeeHitpoints) {
        this.attackerHitpoints = attackerHitpoints;
        this.attackeeHitpoints = attackeeHitpoints;
    }
    public long getAttackerHitpoints() {
        return attackerHitpoints;
    }
    public void setAttackerHitpoints(long attackerHitpoints) {
        this.attackerHitpoints = attackerHitpoints;
    }
    public long getAttackeeHitpoints() {
        return attackeeHitpoints;
    }
    public void setAttackeeHitpoints(long attackeeHitpoints) {
        this.attackeeHitpoints = attackeeHitpoints;
    }

    
}
