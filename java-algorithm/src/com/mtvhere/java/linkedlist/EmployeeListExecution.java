package com.mtvhere.java.linkedlist;

public class EmployeeListExecution {
    public static void main(final String[] args) {

        final Employee emp1 = new Employee("Mark", "Smith", 101);
        final Employee emp2 = new Employee("Jhon", "Deo", 201);
        final Employee emp3 = new Employee("Joe", "King", 504);
        final Employee emp4 = new Employee("Martin", "Sean", 807);


        final EmployeeList employeeList = new EmployeeList();

        System.out.println("Current Size : " + employeeList.getSize());
        System.out.println("Current isEmpty : " + employeeList.isEmpty());

        employeeList.addToFront(emp1);
        employeeList.addToFront(emp2);
        employeeList.addToFront(emp3);
        employeeList.addToFront(emp4);
        //employeeList.addToFront(emp1);
        //employeeList.addToFront(emp2);

        System.out.println("After Adding Size : " + employeeList.getSize());
        System.out.println("After Adding isEmpty : " + employeeList.isEmpty());


        System.out.println("Head Point to : " + employeeList.getHead());
        System.out.println("Tail Point to : " + employeeList.getTail());

        employeeList.printList();

        employeeList.reversePrint();//for doubly head linked list

        //final EmployeeNode removedItem = employeeList.removeFromFront();
        //System.out.println("Removed : " + removedItem);

        // System.out.println("After removing 1 item Size : " + employeeList.getSize());
        // employeeList.printList();


    }
}
