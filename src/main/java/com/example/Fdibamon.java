package com.example;

public class Fdibamon implements Cloneable {
  private String name;
  private long hitpoints;
  private int attackPower;
  private SpecialPower specialPower;
  private int hitChance;
  private int evasionChance;

  public Fdibamon(String name, long hitpoints, int attackPower, SpecialPower specialPower, int hitChance, int evasionChance) {
    this.name = name;
    this.hitpoints = hitpoints;
    this.attackPower = attackPower;
    this.specialPower = specialPower;
    this.hitChance = hitChance;
    this.evasionChance = evasionChance;
  }
  
  public SpecialPower getSpecialPower() {
    return specialPower;
  }
  public void setSpecialPower(SpecialPower specialPower) {
    this.specialPower = specialPower;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public long getHitpoints() {
    return hitpoints;
  }
  public void setHitpoints(long hitpoints) {
    this.hitpoints = hitpoints;
  }
  public int getAttackPower() {
    return attackPower;
  }
  public void setAttackPower(int attackPower) {
    this.attackPower = attackPower;
  }
  public int getHitChance() {
    return hitChance;
  }
  public void setHitChance(int hitChance) {
    this.hitChance = hitChance;
  }
  public int getEvasionChance() {
    return evasionChance;
  }
  public void setEvasionChance(int evasionChance) {
    this.evasionChance = evasionChance;
  }

  @Override
  public String toString() {
    return this.name;
  }

  public Fdibamon clone() {
    return new Fdibamon(this.name, this.hitpoints, this.attackPower, this.specialPower, this.hitChance, this.evasionChance);
  }
}
