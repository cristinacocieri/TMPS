package com.company.factory;

public class PhoneFactory {

    public static Phone getPhone(PhoneType phoneType) {
        switch (phoneType) {
            case Android:
                return new Android();
            case Iphone:
                return new Iphone();
            default:
                return null;
        }
    }
}
