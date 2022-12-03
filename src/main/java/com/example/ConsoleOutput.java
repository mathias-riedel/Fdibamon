package com.example;

public class ConsoleOutput extends Observer {

    public ConsoleOutput(GameOutput gameOutput) {
        this.gameOutput = gameOutput;
    }
    
    @Override
    public void update() {
        System.out.println(gameOutput.getCurrentInfo());
    }
}
