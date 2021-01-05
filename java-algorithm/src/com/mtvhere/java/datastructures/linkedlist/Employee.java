package com.mtvhere.java.datastructures.linkedlist;

public class Employee {

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "{" +
                "'" + this.firstName + '\'' +
                ",'" + this.lastName + '\'' +
                "," + this.id +
                '}';
    }

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    private String firstName;
    private String lastName;
    private long id;

    public Employee(final String firstName, final String lastName, final long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
}
