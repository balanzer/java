package com.mtvhere.java.string;

import java.util.ArrayList;
import java.util.List;

public class ValidWordSquare {
    public static void main(String[] args) {
        ValidWordSquare solution = new ValidWordSquare();

        List<String> words = new ArrayList<>(List.of("abcd", "bnrt", "crmy", "dtye"));

        //System.out.println(solution.validWordSquare(words) + " for " + words);

        words = new ArrayList<>(List.of("abc", "b"));

        System.out.println(solution.validWordSquare(words) + " for " + words);

        words = new ArrayList<>(List.of("ball", "asee", "let", "lep"));

        System.out.println(solution.validWordSquare(words) + " for " + words);

    }

    public boolean validWordSquare(List<String> words) {


        if (null != words && !words.isEmpty()) {
            for (int i = 0; i < words.size(); i++) {

                String word = words.get(i);
                //System.out.println("i=" + i + " word = " + word);
                if (words.get(i).length() > 500 || words.size() < word.length()) {
                    //System.out.println("length failed for " + word);
                    return false;
                }

                for (int j = 0; j < word.length(); j++) {

                    // System.out.println("word " + word + " len " + word.length() + " j word " + words.get(j) + " len " + words.get(j).length() + " i is " + i + " j  is " + j);
                    if (words.get(j).length() <= i || word.charAt(j) != words.get(j).charAt(i)) {
                        return false;
                    }
                }

            }
            return true;
        }
        return false;
    }
}
