package com.mtvhere.java.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] output = solution.merge(intervals);
        System.out.println(Arrays.deepToString(intervals) + " result is : " + Arrays.deepToString(output));

        intervals = new int[][]{{1, 4}, {4, 5}};
        output = solution.merge(intervals);
        System.out.println(Arrays.deepToString(intervals) + " result is : " + Arrays.deepToString(output));
    }

    public int[][] merge(int[][] intervals) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        LinkedList<int[]> outputData = new LinkedList<>();

        for (int[] interval : intervals) {
            pq.add(interval);
        }

        while (pq.size() > 0) {
            int current[] = pq.poll();
            int next[] = pq.peek();
            if (next != null && next.length > 0) {
                if (current[1] >= next[0]) {
                    current[1] = Math.max(current[1], next[1]);
                    next = pq.poll(); // delete merged data
                    pq.add(current);
                } else {
                    outputData.add(current);
                }

            } else {
                outputData.add(current);
            }
            //System.out.println("c " + Arrays.toString(current) + " n " + Arrays.toString(next));
        }

        return outputData.toArray(new int[outputData.size()][]);
    }


    public int[][] mergeV1(int[][] intervals) {
        LinkedList<int[]> data = new LinkedList<>();
        if (intervals.length > 1) {
            Arrays.sort(intervals, (a, b) -> {
                return Integer.compare(a[0], b[0]);
            });

            // System.out.println("Input : " + Arrays.deepToString(intervals));

            for (int i = 0; i < intervals.length; i++) {
                if (data.isEmpty() || data.getLast()[1] < intervals[i][0]) {
                    data.add(intervals[i]);
                } else {
                    data.getLast()[1] = Math.max(data.getLast()[1], intervals[i][1]);
                }
            }
            return data.toArray(new int[data.size()][]);
        }

        return intervals;

    }
}
