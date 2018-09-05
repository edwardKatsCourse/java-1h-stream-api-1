package com.company.inheritance;

public class Main {

    public static void main(String[] args) {

    }
}

class GrandFather {
    private String name;

    public GrandFather(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Father extends GrandFather {
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public Father(String name, Integer age) {
        super(name);
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.getAge();
    }
}

class Child extends Father {
    private String address;

    public String getAddress() {
        return address;
    }

    public Child(String name, Integer age, String address) {
        super(name, age);
        this.address = address;
    }

    @Override
    public Integer getAge() {
        return super.getAge() + 50;
    }

    @Override
    public String getName() {
        return "Mr./Mrs. " + super.getName();
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.getAddress();
    }
}