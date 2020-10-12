package com.company.factory;

public class Iphone extends Phone{
    protected void createPhone() {
        specifications.add(new IphoneCamera());
        specifications.add(new IphonePanel());
        specifications.add(new IphoneProcessor());
    }
}

