package com.company.singleton;

//Singleton Class
public class Phone {

    private static volatile Phone instance = null;

    private Phone() {
    }

    public static Phone getInstance() {
        if (instance == null) {
            synchronized (Phone.class) {
                if (instance == null) {
                    instance = new Phone();
                }
            }
        }
        return instance;
    }
}