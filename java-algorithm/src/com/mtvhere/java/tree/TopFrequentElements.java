package com.mtvhere.java.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopFrequentElements {
    public static void main(String[] args) {
        TopFrequentElements solution = new TopFrequentElements();
        int[] input = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] output = solution.topKFrequent(input, k);
        System.out.println(Arrays.toString(input) + " top " + k + " elements are " + Arrays.toString(output));
    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> mapForCount = new HashMap<>();

        for (int i : nums) {
            if (mapForCount.containsKey(i)) {
                mapForCount.put(i, mapForCount.get(i) + 1);
            } else {
                mapForCount.put(i, 1);
            }
        }
        System.out.println("Map : " + mapForCount);

        PriorityQueue<Element> elements = new PriorityQueue<>((o1, o2) -> {
            if (o1.count >= o2.count) {
                return -1;
            }
            return 1;
        });

        for (int num : mapForCount.keySet()) {
            int count = mapForCount.get(num);
            elements.add(new Element(num, count));
        }
        System.out.println("Queue : " + elements);

        int[] output = new int[k];
        for (int i = 0; i < k; i++) {
            output[i] = elements.poll().num;
        }
        return output;
    }

    class Element {
        private int num;
        private int count;

        public Element(int n, int c) {
            this.num = n;
            this.count = c;
        }


        @Override
        public String toString() {
            return "Element{" +
                    "num=" + this.num +
                    ", count=" + this.count +
                    '}';
        }
    }
}
