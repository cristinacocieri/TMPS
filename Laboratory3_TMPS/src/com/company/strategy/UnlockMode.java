package com.company.strategy;

public class UnlockMode implements IphoneBehavior {

    @Override
    public void mode() {
        System.out.println("iPhone's screen is awake and active. You see either the Home screen or an app screen and interact with them with all the touchscreen gestures.");
    }
}