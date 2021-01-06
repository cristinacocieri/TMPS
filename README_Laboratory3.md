# Laboratory No. 2 - Structural Design Patterns
###### Professor: Drumea Vasile
###### Student: Cocieri Cristina
###### Group: FAF-181

### Objectives
```
- Study and understand the Behavioral Design Patterns;
- As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user;
- Implement some additional functionalities using behavioral design patterns;
```
### Main Tasks
```
1.By extending your project, implement atleast 3 behavioral design patterns in your project.
2.Keep your files grouped (into packages/directories) by their responsibilities.
3.Document your work in a separate markdown file according to the requirements.
```
## Introduction
behavioral design patterns are design patterns that identify common communication patterns between objects and realize these patterns. By doing so, these patterns increase flexibility in carrying out this communication.

1. Chain of responsibility - A way of passing a request between a chain of objects.

2. Command - Encapsulate a command request as an object.

3. Interpreter - A way to include language elements in a program.

4. Iterator - Sequentially access the elements of a collection.

5. Mediator - Defines simplified communication between classes.

6. Observer - A way of notifying change to a number of classes.

7. Strategy - Encapsulates an algorithm inside a class.


## Implementation
This project i choose to implement using Java programming language, because it's one of the most popular OOP and Intelij IDE which is perfect for such a projects. In this laboratory i implemented three Behavioral Design Patterns: Chain of Responsibility, Observer and Strategy patterns. The domain area for this project is Technology, but to be more specific i chose to create Phone class.

##### Chain of Responsibility
This pattern promotes decoupling while percolating responsibility from one object to another, giving an equal chance to every receiving object to handle the request. Imagine in a office when a person calls, the first person takes the call. If the person is busy, the call is redirected to the second person and so on until no one is available. Then, an automated receiver replies to the caller. In my labortory work it shows the chain of responders to handle the responsibility.

```
public abstract class CallHandlerBase {
    protected CallHandlerBase redirectedTo;
    protected Status status = Status.ONDESK;
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setRedirect(CallHandlerBase r) {
        redirectedTo = r;
    }
    public abstract PhoneCallResponse response(PhoneCall call);
}
 
```

##### Strategy
The Strategy Pattern helps us encapsulate an algorithm into a class structure. Objects then can be instantiated dynamically according to the program's requirement and suitability. Here i have implemented different strategies according to the IPhone mode.

```
public class Iphone {
    private IphoneBehavior behavior;
    private String type;

    public Iphone(IphoneBehavior behavior, String type) {
        super();
        this.behavior = behavior;
        this.type = type;
    }
    public void mode() {
        System.out.println(type);
        behavior.mode();
    }
}

```

##### Observer
The Observer Pattern helps create a dependency relationship among objects in such a way that when one object changes its state, the dependent objects are notified and updated automatically. It's rather like a domino effect. In my examples it shows the new notification on Phone or Tablet.

```
public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    abstract void setState(String state);

    abstract String getState();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(observer);
        }
    }

}
```

### Results

In the Main class we have this lines of codes:

```
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
```

Here we have the debug of our project:

![alt text](https://github.com/cristinacocieri/TMPS/blob/main/Laboratory3_TMPS/Lab3Debug.png)


## Conclusions
In order to do this laboratory work, I did a lot of research regarding Behavioral Design Patterns and i had a great experience to implement all this theory in practice, which is a very important thing for developing qualitative IT projects in the future.






