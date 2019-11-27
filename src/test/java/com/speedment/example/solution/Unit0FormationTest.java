package com.speedment.example.solution;

import com.speedment.example.solution.formation.Car;
import com.speedment.example.solution.formation.Service;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) final class Unit0FormationTest {

    private Service service;

    private final List<Car> cars = Arrays.asList(
            new Car("golf", "black", 4, Arrays.asList("papa", "maman")),
            new Car("audi", "red", 3, Arrays.asList("tonton", "tata")),
            new Car("samsung", "red", 4, Arrays.asList("fiston"))
    );

    @Test
    void findFirst_lambda() {
        List<String> strings = Arrays.asList("Alphabet", "Bateau", "Coriandre");
        Optional<String> myOptional = strings.stream().findFirst();
        String myString = myOptional.orElse("default value");
        assertEquals("Alphabet", myString);
        myString = myOptional.orElseGet(() -> service.findString());
        myString = myOptional.orElseThrow(() -> new RuntimeException("error"));
    }

    @Test
    void filter() {
        List<Car> redCars = cars.stream()
                .filter(car -> car.getColor().equals("red"))
                .collect(toList());
        assertEquals(2, redCars.size());
    }

    @Test
    void anyMatch() {
        boolean isAnyCarRed = cars.stream()
                .anyMatch(car -> car.getColor().equals("red"));
        assertTrue(isAnyCarRed);
    }

    @Test
    void map() {
        List<String> carModels = cars.stream()
                .map(Car::getModel)
                .collect(toList());

        assertEquals(
                Arrays.asList("golf", "audi", "samsung"),
                carModels
        );
    }

    @Test
    void flatMap() {
        List<String> carModels = cars.stream()
                .flatMap(car -> car.getOwners().stream())
                .collect(toList());

        assertEquals(
                Arrays.asList("papa", "maman", "tonton", "tata", "fiston"),
                carModels
        );
    }


}
