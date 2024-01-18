package org.example.model.observer;

public interface Subject {

    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void trimiteNotificare(String mesaj);
}
