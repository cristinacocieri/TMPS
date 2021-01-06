package com.company.adapter;

public class AndroidToIphoneAdapter implements Iphone {

    Android androidPhone;

    public AndroidToIphoneAdapter(Android androidPhone) {
        this.androidPhone = androidPhone;
    }

    public void charge() {
        androidPhone.charge();
    }
}