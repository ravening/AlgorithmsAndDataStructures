package src.Strings;

import java.util.HashSet;
import java.util.Set;

public class PrintAllLCS {
    public static void printAll(String str1, String str2) {
        Set<String> set = LCS.displayAllLcs(str1, str2, str1.length(), str2.length());
        for (String s: set) {
            System.out.println(s);
        }
    }

    public static void lcs(String str1, String str2) {
        LCS.lcs(str1, str2);
    }

    public static void main(String[] args) {
        String X = "AGTGATG";
        String Y = "GTTAG";

        lcs(X, Y);
        printAll(X, Y);
    }
}
