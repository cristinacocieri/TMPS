package com.company.factory;

public class Android extends Phone{
    protected void createPhone() {
        specifications.add(new AndroidCamera());
        specifications.add(new AndroidPanel());
        specifications.add(new AndroidProcessor());
    }
}
