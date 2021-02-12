package com.mtvhere.java.string;

import java.util.*;

public class SimilarStringGroups {
    public static void main(String[] args) {
        SimilarStringGroups solution = new SimilarStringGroups();

        String[] input = {"tars", "rats", "arts", "star"};
        int expOutput = 2;
        int actOutPut = 0;
        // actOutPut = solution.numSimilarGroups(input);
        // System.out.println(Arrays.toString(input) + " has similar group : " + actOutPut + ", expected output : " + expOutput);

        input = new String[]{"omv", "ovm"};
        expOutput = 1;
        actOutPut = 0;
        //actOutPut = solution.numSimilarGroups(input);
        // System.out.println(Arrays.toString(input) + " has similar group : " + actOutPut + ", expected output : " + expOutput);

        input = new String[]{"ajdidocuyh", "djdyaohuic", "ddjyhuicoa", "djdhaoyuic", "ddjoiuycha", "ddhoiuycja", "ajdydocuih", "ddjiouycha", "ajdydohuic", "ddjyouicha"};
        expOutput = 2;
        actOutPut = 0;
        actOutPut = solution.numSimilarGroups(input);
        System.out.println(Arrays.toString(input) + " has similar group : " + actOutPut + ", expected output : " + expOutput);

    }

    private String swapPos(String checkFor, int charPos1, int charPos2) {

        char[] checkForChars = checkFor.toCharArray();

        char charTmp = checkForChars[charPos1];
        checkForChars[charPos1] = checkForChars[charPos2];
        checkForChars[charPos2] = charTmp;

        return new String(checkForChars);
    }

    private void checkExistingBucketThatHas(String checkWith, String checkFor, List<Set<String>> bucket) {


        if (null == bucket) {
            bucket = new ArrayList<>();
        }

        boolean added = false;
        for (int i = 0; i < bucket.size() && !added; i++) {
            Set<String> items = bucket.get(i);
            if (items.contains(checkWith) || items.contains(checkFor)) {
                if (null != checkWith && !items.contains(checkWith)) {
                    items.add(checkWith);
                    System.out.println("update bucket at " + i + " for checkWith " + checkWith);
                }
                if (null != checkFor && !items.contains(checkFor)) {
                    items.add(checkFor);
                    System.out.println("update bucket at " + i + " for checkFor " + checkFor);
                }


                bucket.remove(i);
                bucket.add(i, items);
                added = true;
                //System.out.println("update bucket at " + i + " for " + checkWith + "," + checkFor + " final is " + items);
            }
        }

        if (!added) {
            Set<String> newBucket = new HashSet<>();
            if (null != checkWith) {
                newBucket.add(checkWith);
            }
            if (null != checkFor) {
                newBucket.add(checkFor);
            }

            System.out.println("adding new bucket for " + checkWith + "," + checkFor);
            bucket.add(newBucket);
        }


        //System.out.println(bucket);
    }


    public int numSimilarGroups(String[] strs) {

        int groups = 0;


        List<Set<String>> bucket = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {

            String checkFor = strs[i];
            boolean matched = false;


            for (int j = i + 1; j < strs.length; j++) {
                String checkWith = strs[j];

                if (checkWith.equals(checkFor)) {
                    this.checkExistingBucketThatHas(checkWith, checkFor, bucket);
                    //System.out.println(checkFor + " matches  " + checkWith);
                    matched = true;
                } else {

                    for (int strStPos = 0; strStPos < checkFor.length(); strStPos++) {
                        for (int strSwpPos = strStPos + 1; strSwpPos < checkFor.length(); strSwpPos++) {
                            String newCheckFor = this.swapPos(checkFor, strStPos, strSwpPos);

                            if (newCheckFor.equals(checkWith)) {
                                // System.out.println(checkFor + " matches  " + checkWith);
                                this.checkExistingBucketThatHas(checkWith, checkFor, bucket);
                                matched = true;
                            }
                        }
                    }


                }

            }
            if (!matched) {
                this.checkExistingBucketThatHas(null, checkFor, bucket);
            }
        }

        System.out.println("Final Bucket : " + bucket);
        return bucket.size();
    }
}
