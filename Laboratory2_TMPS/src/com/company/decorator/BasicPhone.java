package com.company.decorator;

public class BasicPhone implements Phone {
    @Override
    public String build() {
        return "Screen, Battery, Processor";
    }
}
