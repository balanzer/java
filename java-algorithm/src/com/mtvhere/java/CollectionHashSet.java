package com.mtvhere.java;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class CollectionHashSet {
    public static void main(final String[] args) {

        final List<Integer> numbers = Arrays.asList(8, 1, 1, 1, 2, 2, 3, 2, 3, 2, 4, 5, 4, 6, 7, 7, 6, 6, 7);

        System.out.println("List numbers : " + numbers);

        final Collection<Integer> noDuplicates = new HashSet<>(numbers);

        System.out.println("Set numbers : " + noDuplicates);

        final Person p1 = new Person("M", "V");
        final Person p2 = new Person("m", "V");
        final Person p3 = new Person("HELLO", "World");
        final Person p4 = new Person("HELLO", "World");
        final Person p5 = new Person("HELLO", "World");

        final List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5, p4, p3, p2, p1, p1, p1);

        System.out.println("List Persons : " + persons.size());

        final Collection<Person> noDupPersons = new HashSet<>(persons);

        System.out.println("Set Persons : " + noDupPersons.size());
    }

    static class Person {
        public Person(final String fName, final String lName) {
            this.fName = fName;
            this.lName = lName;
        }

        public String getfName() {
            return this.fName;
        }

        public void setfName(final String fName) {
            this.fName = fName;
        }

        public String getlName() {
            return this.lName;
        }

        public void setlName(final String lName) {
            this.lName = lName;
        }

        private String fName;
        private String lName;
    }
}
