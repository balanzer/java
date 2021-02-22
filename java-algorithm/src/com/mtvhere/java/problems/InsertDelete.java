package com.mtvhere.java.problems;

import java.util.HashSet;
import java.util.Set;

public class InsertDelete {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
        randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
        randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
        randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
        randomizedSet.insert(2); // 2 was already in the set, so return false.
        randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
    }
}

class RandomizedSet {

    Set<Integer> set = null;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        this.set = new HashSet<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (!this.set.contains(val)) {
            this.set.add(val);
            return true;
        }
        return false;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!this.set.contains(val)) {
            return false;
        }
        this.set.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        System.out.println("set : " + this.set);
        int retVal = this.set.stream().findAny().get();
        System.out.println("random : " + retVal);
        return retVal;
    }
}