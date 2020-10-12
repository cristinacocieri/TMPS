package com.company;

import com.company.singleton.Phone;
import com.company.factory.PhoneFactory;
import com.company.factory.PhoneType;

public class Main {

    public static void main(String[] args) {

        //Singleton Design Pattern
        Phone instance = Phone.getInstance();
        System.out.println(instance);

        //Builder Design Pattern
        com.company.builder.Phone.Builder builder = new com.company.builder.Phone.Builder()
                .Panel("Metal Panel")
                .camera("12 MP")
                .processor("A13 Bionic");
        com.company.builder.Phone phone = builder.build();
        System.out.println(phone);

        //Factory Design Pattern
        com.company.factory.Phone android = PhoneFactory.getPhone(PhoneType.Android);
        com.company.factory.Phone iphone = PhoneFactory.getPhone(PhoneType.Iphone);

        System.out.println(android);
        System.out.println(iphone);

    }
}
