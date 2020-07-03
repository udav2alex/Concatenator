package ru.gressor.concatenator.hw2.spam_sender;

import android.util.Log;

import java.util.HashSet;

public class Spammer implements Observable {
    private HashSet<Observer> observers = new HashSet<>();
    private int index;

    public void sendSpam() {
        Log.d(SpamActivity.TAG, "Spammer sent message " + index);
        notify("message " + index++);
    }

    @Override
    public void register(Observer observer) {
        Log.d(SpamActivity.TAG, "Spammer registered observer");
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        Log.d(SpamActivity.TAG, "Spammer unregistered observer");
        observers.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
