package com.company.observer;

public class TabletClient extends Observer {

    public TabletClient(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    public void addMessage(String message) {
        subject.setState(message + " - sent from tablet");
    }

    @Override
    void update(Observer observer) {
        System.out.println("Tablet Stream: " + subject.getState());
    }

}