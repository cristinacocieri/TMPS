package com.company.facade;

public class FacadePhone {

    private Iphone iPhone;
    private NokiaPhone nokiaPhone;
    private Android androidPhone;

    public FacadePhone() {
        iPhone = new Iphone();
        nokiaPhone = new NokiaPhone();
        androidPhone = new Android();
    }

    public String buildApplePhone() {
        return iPhone.build();
    }

    public String buildMicrosoftPhone() {
        return nokiaPhone.build();
    }

    public String buildAndroidPhone() {
        return androidPhone.build();
    }

}