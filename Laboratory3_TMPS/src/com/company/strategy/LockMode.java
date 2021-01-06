package com.company.strategy;

public class LockMode implements IphoneBehavior {

    @Override
    public void mode() {
        System.out.println("iPhone is awake, but you only see an image with some basic information. You can open the Notification Center or the Control Center or slide the Camera icon up to use the camera, but you have to slide your finger across the screen or across a notification to go into.");
    }
}