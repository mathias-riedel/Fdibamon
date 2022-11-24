package com.example;

public class FightResults {
    private Fdibamon winner;
    private int rounds;

    public FightResults(Fdibamon winner, int rounds) {
        this.winner = winner;
        this.rounds = rounds;
    }
    public Fdibamon getWinner() {
        return winner;
    }
    public void setWinner(Fdibamon winner) {
        this.winner = winner;
    }
    public int getRounds() {
        return rounds;
    }
    public void setRounds(int rounds) {
        this.rounds = rounds;
    }
}
