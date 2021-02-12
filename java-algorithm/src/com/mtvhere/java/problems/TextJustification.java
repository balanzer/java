package com.mtvhere.java.problems;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        TextJustification solution = new TextJustification();

        //String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        //int maxWidth = 16;

        String[] words = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int maxWidth = 20;

        List<String> output = solution.fullJustify(words, maxWidth);
        //System.out.println(output);
        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i) + ", len " + output.get(i).length() + " reqd len : " + maxWidth);
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> output = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            StringBuilder tmp = new StringBuilder(str);

            if (tmp.append(words[i]).toString().length() < maxWidth) {
                str = str.append(words[i]).append(" ");
            } else {
                //System.out.println(str.toString());
                output.add(str.toString());
                str = new StringBuilder(words[i]).append(" ");
            }
        }
        output.add(str.toString());

        for (int i = 0; i < output.size(); i++) {
            boolean leftJustified = false;
            if (i + 1 == output.size()) {
                leftJustified = true;
            }
            String strTmp = output.get(i);
            output.remove(i);

            output.add(i, this.getJustifiedText(strTmp, maxWidth, leftJustified));
        }

        return output;
    }

    private String getJustifiedText(String str, int maxWidth, boolean leftJustified) {


        if (leftJustified) {
            return str + this.getSpace(maxWidth - str.length()); // str already left justified
        } else {
            String justifiedTxt = this.addSpaces(str, maxWidth);
            // System.out.println(justifiedTxt + " len : " + justifiedTxt.length());

            return justifiedTxt;
        }
    }

    private String addSpaces(String str, int maxWidth) {


        String[] dataStr = str.trim().split(" ");
        String tmpJoinedStr = String.join("", dataStr);

        int remainingSpace = maxWidth - tmpJoinedStr.length();
        int spaceBetweenEachWords = 0;
        if (dataStr.length > 1) {
            spaceBetweenEachWords = remainingSpace / (dataStr.length - 1);
        }

        int extraSpacesReqd = maxWidth - (tmpJoinedStr.length() + (spaceBetweenEachWords * (dataStr.length - 1)));
    /*
        System.out.println("Join len : " + tmpJoinedStr.length() + ", needed :  " + maxWidth + ", total words : "
                + dataStr.length + ", space between each words : " + spaceBetweenEachWords + ", extra space reqd : " + extraSpacesReqd);
        */
        int index = 0;
        while (extraSpacesReqd > 0) {
            if (dataStr.length > 1) {
                index = index % (dataStr.length - 1);
            } else {
                index = 0;
            }

            dataStr[index] = dataStr[index] + " ";//add exta spaces before all words expect last till extraSpacesReqd is 0
            extraSpacesReqd--;
        }

        //last words can be ignore, no space reqd to add
        for (int i = 0; i < dataStr.length - 1; i++) {
            dataStr[i] = dataStr[i] + this.getSpace(spaceBetweenEachWords);
        }

        return String.join("", dataStr);
    }

    private String getSpace(int spaceBetweenEachWords) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < spaceBetweenEachWords; i++) {
            spaces.append(" ");
        }
        return spaces.toString();
    }
}
