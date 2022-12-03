package com.example;

import java.util.ArrayList;
import java.util.List;

public class GameOutput {
    private List<Observer> observers = new ArrayList<Observer>();
    private String info = "";

    public void updateInfo(String newInfo) {
        this.info = newInfo;
        notifyAllObservers();
    }

    public String getCurrentInfo() {
        return this.info;
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
