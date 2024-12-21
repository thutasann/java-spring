package Basics;

import Shared.Car;

public class CopyingObjectsSample {
    public void SampleOne() {
        System.out.println("\n===> Copying Object Sample one");

        Car car1 = new Car("Car One", "Model one", 2001);
        Car car2 = new Car("Car two", "Model two", 2002);
        Car car3 = new Car(car2);

        car2.copy(car1);

        System.out.println(car1);
        System.out.println(car2);
        System.out.println("----> Car 1");
        System.out.println(car1.getMake());
        System.out.println(car1.getModel());
        System.out.println(car1.getYear());

        System.out.println("----> Car 2");
        System.out.println(car2.getMake());
        System.out.println(car2.getModel());
        System.out.println(car2.getYear());

        System.out.println("----> Car 3");
        System.out.println(car3.getMake());
        System.out.println(car3.getModel());
        System.out.println(car3.getYear());
    }
}
