package com.mtvhere.java.string;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String input, output;
        input = "yzwhuvljgkbxonhkpnxldwkaiboqoflbotqamsxyglfqniflcrtsxbsxlwmxowwnnxychyrjedlijejqzsgwakzohghpxgamecmhcalfoyjtutxeciwqupwlxrgdcpfvybskrytvmwkvnbdjitmohjavhmjobudvbsnkvszyrahpanocltwzeubgxkkthxhjgvcvygfkjctkubtjdocncmjzmxujetybdwmqutvrrulhlsbcbripctbkacwoutkrqsohiihiegqqlasykkgjjskgphieofsjlkkmvwcltgjqbpakercxypfcqqsmkowmgjglbzbidapmqoitpzwhupliynjynsdfncaosrfegquetyfhfqohxytqhjxxpskpwxegmnnppnnmgexwpkspxxjhqtyxhoqfhfyteuqgefrsoacnfdsnyjnyilpuhwzptioqmpadibzblgjgmwokmsqqcfpyxcrekapbqjgtlcwvmkkljsfoeihpgksjjgkkysalqqgeihiihosqrktuowcakbtcpirbcbslhlurrvtuqmwdbytejuxmzjmcncodjtbuktcjkfgyvcvgjhxhtkkxgbuezwtlconapharyzsvknsbvdubojmhvajhomtijdbnvkwmvtyrksbyvfpcdgrxlwpuqwicextutjyoflachmcemagxphghozkawgszqjejildejryhcyxnnwwoxmwlxsbxstrclfinqflgyxsmaqtoblfoqobiakwdlxnpkhnoxbkgjlvuhwzy";
        output = solution.longestPalindrome(input);
        System.out.println(input + ", Longest Palindromic Substring is : " + output);
    }

    public String longestPalindrome(String s) {
        if (null == s || s.trim().length() <= 1) {
            return s;
        }
        if (s.trim().length() > 1000) {
            return null;
        }
        String maxPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j >= i && j != i; j--) {
                String checkFor = s.substring(i, j);
                String reverse = this.reverse(checkFor);
                if (checkFor.equals(reverse)) {
                    if (checkFor.length() >= maxPalindrome.length()) {
                        maxPalindrome = checkFor;
                        System.out.println(maxPalindrome);
                    }
                }
            }
        }

        return maxPalindrome;
    }

    private String reverse(String s) {
        if (s != null & s.trim().length() > 0) {
            StringBuilder input = new StringBuilder(s);
            return input.reverse().toString();
        }
        return null;
    }
}
