package com.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static GameOutput gameOutput = new GameOutput();
    public static void main( String[] args )
    {
        List<Fdibamon> fdibamons = initializeFdibamons();

        ConsoleOutput consoleOutput = new ConsoleOutput(gameOutput);

        gameOutput.attach(consoleOutput);

        gameOutput.updateInfo("Folgende Fdibamons stehen zur Auswahl: Jan, Rado, Klaus, Mathias, Nikolay");

        printEmptyLine();

        Scanner scanner = new Scanner(System.in);
        Fdibamon fdibamon1 = letUserChooseFdibamon(fdibamons, scanner);
        Fdibamon fdibamon2 = letUserChooseFdibamon(fdibamons, scanner);
        scanner.close();

        gameOutput.updateInfo("Ihre gewählten Fdibamons: " + fdibamon1 + ", " + fdibamon2);

        printEmptyLine();

        gameOutput.updateInfo("Der Kampf beginnt!");

        FightResults results = fight(fdibamon1, fdibamon2);

        printEmptyLine();

        printWinner(results.getWinner());

        printEmptyLine();

        FightReportGenerator fightReportGenerator = new FightReportGenerator();
        fightReportGenerator.createFightReport(fdibamon1, fdibamon2, results.getWinner(), results.getRounds());
    }

    public static FightResults fight(Fdibamon fdibamon1, Fdibamon fdibamon2) {
        boolean areBothFdibamonsStillAlive = true;
        int round = 1;
        FdibamonAttackSimulator attackSimulator = new FdibamonAttackSimulator();

        do {
            printEmptyLine();
            gameOutput.updateInfo("Runde " + round);

            boolean useSpecialPower = round % 5 == 0;

            attackSimulator.attack(fdibamon1, fdibamon2, useSpecialPower);
            attackSimulator.attack(fdibamon2, fdibamon1, useSpecialPower);

            gameOutput.updateInfo("Hitpoints von Fdibamon " + fdibamon1 + ": " + fdibamon1.getHitpoints());
            gameOutput.updateInfo("Hitpoints von Fdibamon " + fdibamon2 + ": " + fdibamon2.getHitpoints());

            areBothFdibamonsStillAlive = fdibamon1.getHitpoints() > 0 && fdibamon2.getHitpoints() > 0;
            round++;
        } while (areBothFdibamonsStillAlive);

        Fdibamon winner = getWinner(fdibamon1, fdibamon2);

        return new FightResults(winner, round - 1);
    }

    private static Fdibamon getWinner(Fdibamon fdibamon1, Fdibamon fdibamon2) {
        if (fdibamon1.getHitpoints() > fdibamon2.getHitpoints()) {
            return fdibamon1;
        } else if (fdibamon2.getHitpoints() > fdibamon1.getHitpoints()) {
            return fdibamon2;
        } else {
            return null;
        }
    }

    public static void printWinner(Fdibamon winner) {
        if (winner != null) {
            gameOutput.updateInfo("Der Gewinner ist " + winner + "!");
        } else {
            gameOutput.updateInfo("Der Kampf ist unentschieden!");
        }
    }

    public static Fdibamon getFdibamonFromList(List<Fdibamon> fdibamons, String name) {
        Fdibamon fdibamon = null;
        for (Fdibamon f : fdibamons) {
            if (name.equals(f.getName())) {
                fdibamon = f;
            }
        }

        return fdibamon;
    }

    public static Fdibamon letUserChooseFdibamon(List<Fdibamon> fdibamons, Scanner scanner) {
        String name = "";
        Fdibamon fdibamon = null;
        while (fdibamon == null) {
            gameOutput.updateInfo("Wählen Sie ein Fdibamon aus:");
            name = scanner.nextLine();

            fdibamon = getFdibamonFromList(fdibamons, name);

            if (fdibamon == null) {
                gameOutput.updateInfo("Das eingegebene Fdibamon existiert nicht. Bitte versuchen Sie es noch einmal!");
            }
        }
        return fdibamon.clone();
    }

    public static List<Fdibamon> initializeFdibamons() {
        List<Fdibamon> fdibamons = new ArrayList<>();

        Fdibamon jan = new Fdibamon("Jan", 60, 8, SpecialPower.JEDIHEALING, 50, 20);
        Fdibamon rado = new Fdibamon("Rado", 40, 6, SpecialPower.POWERATTACK, 30, 30);
        Fdibamon klaus = new Fdibamon("Klaus", 30, 4, SpecialPower.STEALHITPOINTS, 10, 15);
        Fdibamon mathias = new Fdibamon("Mathias", 50, 9, SpecialPower.JEDIHEALING, 30, 10);
        Fdibamon nikolay = new Fdibamon("Nikolay", 20, 5, SpecialPower.POWERATTACK, 2, 5);
        
        fdibamons.add(jan);
        fdibamons.add(rado);
        fdibamons.add(klaus);
        fdibamons.add(mathias);
        fdibamons.add(nikolay);

        return fdibamons;
    }

    private static void printEmptyLine() {
        gameOutput.updateInfo("\n");
    }
}
