package com.enroutesystems.reflectionAPI;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

public class Person {
    private String name;
    int age;

    Person() {
        this.name = "Fulano";
        this.age = 25;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String hello() {
        return "Hello, my name is: " + this.name;
    }

    String greet(String name) {
        return "Nice to meet you " + name;
    }

    int sum(int x, int y) {
        return x + y;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + "\'" +
                ", age=" + age +
                "}";
    }
}
