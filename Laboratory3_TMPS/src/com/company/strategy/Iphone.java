package com.company.strategy;

public class Iphone {
    private IphoneBehavior behavior;
    private String type;

    public Iphone(IphoneBehavior behavior, String type) {
        super();
        this.behavior = behavior;
        this.type = type;
    }
    public void mode() {
        System.out.println(type);
        behavior.mode();
    }
}