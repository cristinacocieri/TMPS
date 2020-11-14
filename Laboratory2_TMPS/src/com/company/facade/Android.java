package com.company.facade;

public class Android implements Phone {
    @Override
    public String build() {
        return "Built using Android 4.0";
    }
}