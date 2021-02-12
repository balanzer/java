package com.mtvhere.java.arrays;

public class PutBoxesInWarehouse {
    public static void main(String[] args) {
        PutBoxesInWarehouse solution = new PutBoxesInWarehouse();
        int[] boxes = {1, 3, 3, 4, 5};
        int[] warehouse = {4, 4, 1, 1};
        int output = solution.maxBoxesInWarehouse(boxes, warehouse);
        System.out.println("Max Boxes : " + output);

    }

    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int boxcount = 0;

        for (int j = warehouse.length - 1; j >= 0; j--) {

            int maxRoomSize = warehouse[j];
            // System.out.println("Checking for boxes with room height  " + maxRoomSize);
            int index = -1;
            boolean added = false;
            int maxBoxHeightForThisRoom = Integer.MIN_VALUE;
            for (int i = 0; i < boxes.length; i++) {
                if (boxes[i] == maxRoomSize) {
                    //System.out.println("\t\tbox with height " + boxes[i] + " added to room with height " + maxRoomSize);
                    // System.out.println("\t\tbox added with height " + boxes[i] + " index " + i);
                    boxes[i] = Integer.MIN_VALUE;
                    boxcount++;
                    added = true;
                    break;
                } else {
                    if (boxes[i] <= maxRoomSize && boxes[i] > 0) {
                        if (boxes[i] >= maxBoxHeightForThisRoom) {
                            index = i;
                            maxBoxHeightForThisRoom = boxes[i];
                        }
                    }
                }

            }
            if (!added) {
                if (index >= 0) {
                    //System.out.println(index);
                    // System.out.println("\t\tbox added with height " + boxes[index] + " index " + index);
                    boxes[index] = Integer.MIN_VALUE;
                    boxcount++;

                } else {
                    // System.out.println("room cannot accomodate any boxes ");
                }
            }


        }

        return boxcount;
    }
}
