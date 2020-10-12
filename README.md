# Laboratory No. 1 - Creational Design Patterns
###### Professor: Drumea Vasile
###### Student: Cocieri Cristina
###### Group: FAF-181

### Objectives
```
-To study and understand the Creational Design Patterns;
- To choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms;
- To use some creational design patterns for object instantiation in a sample project.
```
### Main Tasks
```
1. Choose an OO programming language and a suitable IDE or Editor (No frameworks/libs/engines allowed);
2. Select a domain area for the sample project;
3. Define the main involved classes and think about what instantiation mechanisms are needed;
4. Based on the previous point, implement atleast 3 creational design patterns in your project;
```
## Introduction
Creational design patterns are design patterns that deal with object creation mechanisms, trying to create objects in a manner suitable to the situation. The basic form of object creation could result in design problems or added complexity to the design. Creational design patterns solve this problem by somehow controlling this object creation and they are composed of two dominant ideas. One is encapsulating knowledge about which concrete classes the system use. Another is hiding how instances of these concrete classes are created and combined.Five well-known design patterns that are parts of creational patterns are the following:

- Abstract factory pattern, which provides an interface for creating related or dependent objects without specifying the objects' concrete classes.
- Builder pattern, which separates the construction of a complex object from its representation so that the same construction process can create different representations.
- Factory method pattern, which allows a class to defer instantiation to subclasses.
- Prototype pattern, which specifies the kind of object to create using a prototypical instance, and creates new objects by cloning this prototype.
- Singleton pattern, which ensures that a class only has one instance, and provides a global point of access to it.

## Implementation
This project i choose to implement using Java programming language, because it's one of the most popular OOP and Intelij IDE which is perfect for such a projects. In this laboratory i implemented three Creational Design Patterns: Singleton, Builder and Factory Method patterns. The domain area for this project is Technology, but to be more specific i chose to create Phone class.

##### Singleton
If we want a class to have only one instance and provide a global access point to it, then we use singleton pattern. Of course, this design pattern is simplest one, but in general, it is mentioned as a bad practice that should be avoided by many developers due to it prevents extensibility and also decreases testability of the code by it globalizing a state into the app.
```
//Singleton Class
public class Phone {
    private static volatile Phone instance = null;
    private Phone() {
    }
    public static Phone getInstance() {
        if (instance == null) {
            synchronized (Phone.class) {
                if (instance == null) {
                    instance = new Phone();
                }
            }
        }
        return instance;
    }
}
```
##### Builder
Builder is quite similar with abstract factory. Here is the difference : Abstract factory is about what products are made of while builder is about how a single object is making up by different factories or processes. Here I used some Phone properties like: Panel, Processor and Camera and of course getters and setters.
```
public class Phone {
    public static class Builder {
        private String Panel;
        private String processor;
        private String camera;

        public Builder() {
        }
        public Phone build() {
            return new Phone(this);
        }
        public Builder Panel(String frontPanel) {
            this.Panel = frontPanel;
            return this;
        }
        public Builder processor(String processor) {
            this.processor = processor;
            return this;
        }
        public Builder camera(String camera) {
            this.camera = camera;
            return this;
        }
    }
    private String Panel;
    private String Processor;
    private String Camera;
    
    private Phone(Builder builder) {
        this.Panel = builder.Panel;
        this.Processor = builder.processor;
        this.Camera = builder.camera;
    }
    public String getPanel() {
        return Panel;
    }
    public String getProcessor() {
        return Processor;
    }
    public String getCamera() {
        return Camera;
    }
```

##### Factory Method
This Pattern was the most difficult but the most interesting to implement for me.Here ve have the abstract class Phone:
```
public abstract class Phone {
    protected List<Specification> specifications = new ArrayList<Specification>();
    public Phone() {
        createPhone();
    }
    protected abstract void createPhone();
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Phone{");
        sb.append("specifications=").append(specifications);
        sb.append('}');
        return sb.toString();
    }
```
And also we declare an Interface called Specification, which will contain the method for Phone's properties description:
```
public interface Specification {
    void description();
}
```
And something new for me was the enumeration in Java, in which i declared Phone types:
```
public enum  PhoneType {
    Iphone,
    Android
}
```

## Conclusions
In order to do this laboratory work, I did a lot of research regarding Creational Design Patterns and i had a great experience to implement all this theory in practice, which is a very important thing for developing qualitative IT projects in the future.






