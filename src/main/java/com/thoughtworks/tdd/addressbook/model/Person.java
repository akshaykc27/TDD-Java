package com.thoughtworks.tdd.addressbook.model;

public class Person {

    private  String name;
    private  String phoneNumber;
    private  String address;

    public Person(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
