package com.company;

import com.company.adapter.*;
import com.company.adapter.Android;
import com.company.adapter.Iphone;
import com.company.decorator.*;
import com.company.decorator.NokiaPhone;
import com.company.facade.*;
import com.company.singleton.Phone;
import com.company.factory.PhoneFactory;
import com.company.factory.PhoneType;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nCREATIONAL DESIGN PATTERNS:");

        //Singleton Design Pattern
        System.out.println("\n1.Singleton Design Pattern");
        Phone instance = Phone.getInstance();
        System.out.println(instance);

        //Builder Design Pattern
        System.out.println("\n2.Builder Design Pattern");
        com.company.builder.Phone.Builder builder = new com.company.builder.Phone.Builder()
                .Panel("Metal Panel")
                .camera("12 MP")
                .processor("A13 Bionic");
        com.company.builder.Phone phone = builder.build();
        System.out.println(phone);

        //Factory Design Pattern
        System.out.println("\n3.Factory Design Pattern");
        com.company.factory.Phone android = PhoneFactory.getPhone(PhoneType.Android);
        com.company.factory.Phone iphone = PhoneFactory.getPhone(PhoneType.Iphone);

        System.out.println(android);
        System.out.println(iphone);

        System.out.println("\nSTRUCTURAL DESIGN PATTERNS:");
        //Adapter Design Pattern
        System.out.println("\n1.Adapter Design Pattern");
        AndroidCharger androidcharger = new AndroidCharger();
        Android androidphone = new SamsungS20();
        androidcharger.charge(androidphone);

        IphoneCharger iphonecharger = new IphoneCharger();
        Iphone iphoncik = new Iphone12();
        iphonecharger.charge(iphoncik);

        AndroidToIphoneAdapter adapter = new AndroidToIphoneAdapter(androidphone);
        iphonecharger.charge(adapter);

        //Decorator Design Pattern
        System.out.println("\n2.Decorator Design Pattern");
        com.company.decorator.Phone androidPhone = new com.company.decorator.Android(new BasicPhone());
        System.out.println(androidPhone.build());


        com.company.decorator.Phone applePhone = new com.company.decorator.Iphone(new BasicPhone());
        System.out.println(applePhone.build());


        com.company.decorator.Phone nokiaWindowsPhone = new NokiaPhone(new WindowsPhone(new BasicPhone()));
        System.out.println(nokiaWindowsPhone.build());

        com.company.decorator.Phone nokiaAndroidPhone = new NokiaPhone(new com.company.decorator.Android(new BasicPhone()));
        System.out.println(nokiaAndroidPhone.build());

        //Facade Design Pattern
        System.out.println("\n3.Facade Design Pattern");
        FacadePhone facadePhone = new FacadePhone();

        System.out.println(facadePhone.buildAndroidPhone());
        System.out.println(facadePhone.buildApplePhone());
        System.out.println(facadePhone.buildMicrosoftPhone());
    }
}
