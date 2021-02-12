package com.mtvhere.java.string;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    public static void main(String[] args) {
        DecodeWays solution = new DecodeWays();

        String input = "226";
        int output = solution.numDecodings(input);
        System.out.println(input + " can be decoded " + output + " ways ");

    }

    public int numDecodings(String s) {
        return this.findDecodeWays(0, s);
    }

    Map<Integer, Integer> memo = new HashMap<>();

    private int findDecodeWays(int index, String s) {

        // System.out.println(index);
        if (this.memo.containsKey(index)) {
            return this.memo.get(index);
        }

        if (index == s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }
        if (index == s.length() - 1) {
            return 1;
        }
        int ans = this.findDecodeWays(index + 1, s);
        if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ans += this.findDecodeWays(index + 2, s);
        }
        this.memo.put(index, ans);
        return ans;
    }


}
