package Strings;

public class MinimumWindowSubsequence {
    
    public String solution(String string, String pattern) {

        int stringLength = string.length();
        int patternLength = pattern.length();

        if (stringLength < patternLength) {
            return "";
        }

        int start = 0, end = 0, index = 0, length = stringLength;
        char[] patternArray = pattern.toCharArray();

        for (var right = 0; right < stringLength; right++) {
            if (string.charAt(right) == (patternArray[index])) {
                index++;

                if (index == patternLength) {
                    index--;
                    end = right;

                    while (index >= 0) {
                        if (string.charAt(right) == patternArray[index]) {
                            index--;
                        }

                        right--;
                    }

                    if (length > end - right) {
                        length = end - right;
                        start = right + 1;
                    }

                    index = 0;
                    right = start;
                }
            }
        }
        
        return string.substring(start, start + length);
    }

    public static void main(String[] args) {
        MinimumWindowSubsequence minimumWindowSubsequence = new MinimumWindowSubsequence();

        System.out.println(minimumWindowSubsequence.solution("xaymbazbdceabe", "abe"));
    }
}
