#singleton model 
```java
class Service {

    private static Service instance = new Service();

    private Service() {

    }

    public static getInstance() {
        return instance;
    };
}
```

#factory model
```java
public interface Shape {
    void draw();
}

public class Rectangle implements Shape {
    @Override 
    public void draw() {
        System.out.println("I am a Rectangle");
    }
}

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("I am a Circle");
    }
}

public class ShapeFactory {

    public Shape getShape(String shapeType) {
        if (shapeType.isEmpty()) {
            return null;
        }
    
        if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("rectangle") {
            return new Rectangle();
        } else {
            return null;
        }
    }
}
```