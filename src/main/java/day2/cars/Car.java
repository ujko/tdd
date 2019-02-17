package day2.cars;

public class Car {
    private String name;
    private int id;
    private String color;

    public Car(String name, int id, String color) {
        this.name = name;
        this.id = id;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }
}
