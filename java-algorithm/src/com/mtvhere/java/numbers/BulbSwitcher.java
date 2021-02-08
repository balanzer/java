package com.mtvhere.java.numbers;

public class BulbSwitcher {
    public static void main(String[] args) {
        BulbSwitcher solution = new BulbSwitcher();
        int n = 99999999;
        System.out.println("For n " + n + " Bulbs are " + solution.bulbSwitch(n));

    }

    public int bulbSwitch(int n) {
        boolean bulbs[] = new boolean[n];
        if (n > Math.pow(10, 9)) {
            return 0;
        }
        for (int i = 1; i <= bulbs.length; i++) {

            for (int j = i; j <= bulbs.length; j = j + i) {
                int index = j - 1;
                bulbs[index] = !bulbs[index];
            }
            //System.out.println(Arrays.toString(bulbs));
        }

        int count = 0;
        for (int i = 0; i < bulbs.length; i++) {
            if (bulbs[i]) {
                count++;
            }
        }
        return count;
    }
}
