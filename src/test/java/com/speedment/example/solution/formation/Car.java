package com.speedment.example.solution.formation;

import java.util.List;
import java.util.Objects;

public class Car {
    private String model;
    private String color;
    private int doors;
    private List<String> owners;

    public Car(String model, String color, int doors, List<String> owners) {
        this.model = model;
        this.color = color;
        this.doors = doors;
        this.owners = owners;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getDoors() {
        return doors;
    }

    public List<String> getOwners() {
        return owners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return doors == car.doors &&
                Objects.equals(model, car.model) &&
                Objects.equals(color, car.color) &&
                Objects.equals(owners, car.owners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, color, doors, owners);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", doors=" + doors +
                ", owners=" + owners +
                '}';
    }
}
