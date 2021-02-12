package com.mtvhere.java.linkedlist;

public class EmployeeNode {
    private Employee employee;
    private EmployeeNode next;
    private EmployeeNode prev;

    public EmployeeNode getPrev() {
        return this.prev;
    }

    public void setPrev(final EmployeeNode prev) {
        this.prev = prev;
    }

    public void setNext(final EmployeeNode next) {
        this.next = next;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(final Employee employee) {
        this.employee = employee;
    }

    public EmployeeNode(final Employee employee) {
        this.employee = employee;
    }

    public EmployeeNode getNext() {
        return this.next;
    }

    @Override
    public String toString() {
        return this.employee.toString();
    }
}
