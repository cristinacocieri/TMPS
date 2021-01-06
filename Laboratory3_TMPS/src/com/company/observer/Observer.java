package com.company.observer;

public abstract class Observer {

    protected Subject subject;

    abstract void update(Observer observer);

}
