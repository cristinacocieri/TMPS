package com.company.decorator;

public class Android extends SmartPhone {
    public Android(Phone phone) {
        super(phone);
    }

    @Override
    public String build() {
        return super.build() + addOS();
    }

    private String addOS() {
        return "Android OS v6.0";
    }
}