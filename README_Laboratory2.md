# Laboratory No. 2 - Structural Design Patterns
###### Professor: Drumea Vasile
###### Student: Cocieri Cristina
###### Group: FAF-181

### Objectives
```
- Study and understand the Structural Design Patterns;
- As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user;
- Implement some additional functionalities using structural design patterns;
```
### Main Tasks
```
1.By extending your project, implement atleast 3 structural design patterns in your project.
2.Keep your files grouped (into packages/directories) by their responsibilities.
3.Document your work in a separate markdown file according to the requirements.
```
## Introduction
Structural design patterns are concerned with how classes and objects can be composed, to form larger structures.The structural design patterns simplifies the structure by identifying the relationships.These patterns focus on, how the classes inherit from each other and how they are composed from other classes.There are following 7 types of structural design patterns:

1.Adapter Pattern - Adapting an interface into another according to client expectation.

2.Bridge Pattern - Separating abstraction (interface) from implementation.

3.Composite Pattern - Allowing clients to operate on hierarchy of objects.

4.Decorator Pattern - Adding functionality to an object dynamically.

5.Facade Pattern - Providing an interface to a set of interfaces.

6.Flyweight Pattern - Reusing an object by sharing it.

7.Proxy Pattern - Representing another object.


## Implementation
This project i choose to implement using Java programming language, because it's one of the most popular OOP and Intelij IDE which is perfect for such a projects. In this laboratory i implemented three Structural Design Patterns: Adapter, Decorator and Facade patterns. The domain area for this project is Technology, but to be more specific i chose to create Phone class.

##### Adapter
An Adapter Pattern says that just "converts the interface of a class into another interface that a client wants".In other words, to provide the interface according to client requirement while using the services of a class with a different interface.
We use Adapter Pattern because it allows two or more previously incompatible objects to interact and it also allows reusability of existing functionality. In my project we have AndroidCharger and IphoneCharger, and by using Adapter Pattern, we can convert Android interface into Iphone interface.

```
public class AndroidToIphoneAdapter implements Iphone {

    Android androidPhone;

    public AndroidToIphoneAdapter(Android androidPhone) {
        this.androidPhone = androidPhone;
    }

    public void charge() {
        androidPhone.charge();
    }
}
 
```
##### Decorator
A Decorator Pattern says that just "attach a flexible additional responsibilities to an object dynamically".In other words, The Decorator Pattern uses composition instead of inheritance to extend the functionality of an object at runtime. Some reasons to use this pattern are: it provides greater flexibility than static inheritance,it enhances the extensibility of the object, because changes are made by coding new classes,it simplifies the coding by allowing to develop a series of functionality from targeted classes instead of coding all of the behavior into the object.
Here we have a Phone Interface and an abstarct class SmartPhone, which is extended by different classes(types of phones).

```
public abstract class SmartPhone implements Phone {

    private final Phone phone;

    public SmartPhone(Phone phone) {
        this.phone = phone;
    }

    public String build() {
        return phone.build();
    }
}

```

##### Facade
A Facade Pattern says that just "just provide a unified and simplified interface to a set of interfaces in a subsystem, therefore it hides the complexities of the subsystem from the client".In other words, Facade Pattern describes a higher-level interface that makes the sub-system easier to use. The advantages of use this pattern are: it shield the clients from the complexities of the sub-system components and it also promotes loose coupling between subsystems and its clients.
Here we have a Phone interface and a FacadePhone class, in which all other types of phones are unified.
```
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
```

### Results

In the Main class we have this lines of codes:

```
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
```

Here we have the debug of our project:

![alt text](https://github.com/cristinacocieri/TMPS/blob/main/Laboratory2_TMPS/Debug.png?raw=true)


## Conclusions
In order to do this laboratory work, I did a lot of research regarding Structural Design Patterns and i had a great experience to implement all this theory in practice, which is a very important thing for developing qualitative IT projects in the future.






