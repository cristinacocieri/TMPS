package com.company.decorator;

public class Iphone extends SmartPhone {
    public Iphone(Phone phone) {
        super(phone);
    }

    @Override
    public String build() {
        return super.build() + addOS();
    }

    private String addOS() {
        return "IOS v1.0";
    }
}
