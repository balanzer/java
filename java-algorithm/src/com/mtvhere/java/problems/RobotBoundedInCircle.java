package com.mtvhere.java.problems;

public class RobotBoundedInCircle {
    public static void main(String[] args) {
        RobotBoundedInCircle solution = new RobotBoundedInCircle();
        // String input = "GGLLGGGGGGG";
        String input = "GGLLGG";
        System.out.println(input + " is : " + solution.isRobotBounded(input));

    }

    public boolean isRobotBounded(String instructions) {

        if (null == instructions || instructions.length() > 100) {
            return false;
        }
        // north = 0, east = 1 or right, south = 2, west = 3 or left
        int directions[][] = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //intial position
        int x = 0, y = 0;

        //moves
        int move = 0;


        for (char i : instructions.toCharArray()) {


            if (i == 'L') {
                //left index is 3 - west
                move = (move + 3) % 4;
            } else if (i == 'R') {
                //right index is 1 - east
                move = (move + 1) % 4;
            } else if (i == 'G') {

                x = x + directions[move][0];
                y = y + directions[move][1];

            } else {
                return false;
            }

            System.out.println("Char " + i + " -> x(" + x + "), y(" + y + "), idx(" + move + ")");
        }
        System.out.println("Final -> x(" + x + "), y(" + y + "), idx(" + move + ")");
        return (x == 0 && y == 0) || (move != 0);
    }

    public boolean isRobotBoundedV1(String instructions) {

        // north = 0, east = 1 or right, south = 2, west = 3 or left
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Initial position is in the center
        int x = 0, y = 0;
        // facing north
        int idx = 0;

        for (char i : instructions.toCharArray()) {

            if (i == 'L') {
                idx = (idx + 3) % 4;
            } else if (i == 'R') {
                idx = (idx + 1) % 4;
            } else {
                x += directions[idx][0];
                y += directions[idx][1];
            }
            System.out.println("Char " + i + " -> x(" + x + "), y(" + y + "), idx(" + idx + ")");
        }
        System.out.println("final x(" + x + "), y(" + y + "), idx(" + idx + ")");
        // after one cycle:
        // robot returns into initial position
        // or robot doesn't face north
        return (x == 0 && y == 0) || (idx != 0);
    }
}
