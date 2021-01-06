package com.company.strategy;

public class SleepMode implements IphoneBehavior {

    @Override
    public void mode() {
        System.out.println("iPhone is asleep when it’s on but the screen is dark. It can receive incoming calls, e-mail, messages, and notifications, which push it into.");
    }
}