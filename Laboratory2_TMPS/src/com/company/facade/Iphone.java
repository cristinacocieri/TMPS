package com.company.facade;

public class Iphone implements Phone {
    @Override
    public String build() {
        return "Built using iOS 11";
    }
}