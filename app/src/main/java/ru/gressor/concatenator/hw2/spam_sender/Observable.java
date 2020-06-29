package ru.gressor.concatenator.hw2.spam_sender;

public interface Observable {
    void register(Observer observer);
    void unregister(Observer observer);
    void notify(String message);
}
