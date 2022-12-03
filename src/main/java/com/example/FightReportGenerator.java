package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class FightReportGenerator {
  public void createFightReport(Fdibamon fdibamon1, Fdibamon fdibamon2, Fdibamon winner, int rounds) {
    String filename = generateFilename(fdibamon1, fdibamon2);
    try {
      File desktop = new File(System.getProperty("user.home"), "/Desktop");
      File fightReport = new File(desktop, filename);
      if (fightReport.createNewFile()) {
        App.gameOutput.updateInfo("Der Kampf Report wurde auf dem Desktop erstellt: " + fightReport.getName());
        this.writeToFile(fdibamon1, fdibamon2, winner, rounds, fightReport);
      }
    } catch (IOException e) {
      App.gameOutput.updateInfo("Ein Fehler ist aufgetreten. Datei konnte nicht erstellt werden.");
    }
  }

  private void writeToFile(Fdibamon fdibamon1, Fdibamon fdibamon2, Fdibamon winner, int rounds, File fightReport) {
    try (FileWriter myWriter = new FileWriter(fightReport.getAbsolutePath());) {
      myWriter.write("Fdibamons: " + fdibamon1.getName() + ", " + fdibamon2.getName() + "\n");
      if (winner != null) {
        myWriter.write("Gewinner: " + winner.getName() + "\n");
      } else {
        myWriter.write("Der Kampf war unentschieden. \n");
      }
      myWriter.write("Anzahl an Runden: " + rounds + "\n");
      myWriter.write("Beide Fdibamons haben ihre Spezialkraft " + rounds / 5 + " Mal angewandt.\n");
    } catch (IOException e) {
      App.gameOutput.updateInfo("Ein Fehler ist aufgetreten. Datei konnte nicht beschrieben werden.");
    }
  }

  public String generateFilename(Fdibamon fdibamon1, Fdibamon fdibamon2) {
    String currentDateAndTime = this.getCurrentDateAndTime();
    return fdibamon1.getName() + "-" + fdibamon2.getName() + " " + currentDateAndTime + ".txt";
  }

  public String getCurrentDateAndTime() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH-mm-ss");
    LocalDateTime now = LocalDateTime.now();
    return dtf.format(now);
  }
}
