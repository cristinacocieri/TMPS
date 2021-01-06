package com.company;

import com.company.adapter.*;
import com.company.adapter.Android;
import com.company.adapter.Iphone;
import com.company.chainofresponsability.*;
import com.company.decorator.*;
import com.company.decorator.NokiaPhone;
import com.company.facade.*;
import com.company.singleton.Phone;
import com.company.factory.PhoneFactory;
import com.company.factory.PhoneType;
import com.company.strategy.LockMode;
import com.company.strategy.SleepMode;
import com.company.strategy.UnlockMode;
import com.company.observer.*;

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

        System.out.println("\nBEHAVIORAL DESIGN PATTERNS:");
        System.out.println("\n1. Chain of Responsibility Design Pattern");

        CallHandlerBase reception = new ReceptionHandler();
        CallHandlerBase admin = new AdministrativeOfficeHandler();
        CallHandlerBase manager = new ManagerHandler();
        CallHandlerBase auto = new AutomatedSpeakerHandler();

        reception.setRedirect(admin);
        admin.setRedirect(manager);
        manager.setRedirect(auto);

        PhoneCall call1 = new PhoneCall(1, "9876543210", PhoneCallResponse.ACCEPTED);
        PhoneCall call2 = new PhoneCall(2, "9182736451", PhoneCallResponse.ACCEPTED);

        reception.setStatus(Status.ONDESK);

        reception.response(call1);

        reception.setStatus(Status.OFFDESK);
        admin.setStatus(Status.OFFDESK);
        manager.setStatus(Status.OFFDESK);
        reception.response(call2);

        System.out.println("\n2. Strategy Design Pattern");

        com.company.strategy.Iphone s1 = new com.company.strategy.Iphone(new SleepMode(), "Sleep Mode");
        com.company.strategy.Iphone s2 = new com.company.strategy.Iphone(new LockMode(), "Lock Mode");
        com.company.strategy.Iphone s3 = new com.company.strategy.Iphone(new UnlockMode(), "Unlock Mode");
        s1.mode();
        s2.mode();
        s3.mode();

        System.out.println("\n3. Observer Design Pattern");

        Subject subject = new MessageStream();

        PhoneClient phoneClient = new PhoneClient(subject);
        TabletClient tableClient = new TabletClient(subject);

        phoneClient.addMessage("Here is a new message!");
        tableClient.addMessage("Another new message!");


    }
}
