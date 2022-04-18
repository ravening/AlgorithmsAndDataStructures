package Strings;

public class MInimumSwapsAnagram {
    public int solution(char[] string1, char[] string2) {
        int result = 0;
        int i = 0, j = 0;

        while (i < string1.length) {
            j = i;

            while (string1[j] != string2[i]) {
                j++;
            }

            while (i < j) {
                char tmp = string1[j];
                string1[j] = string1[j-1];
                string1[j-1] = tmp;
                j--;
                result++;
            }

            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        String string = "abcfdegji";
        String another = "fjiacbdge";
        MInimumSwapsAnagram mInimumSwapsAnagram = new MInimumSwapsAnagram();
        System.out.println(mInimumSwapsAnagram.solution(string.toCharArray(), another.toCharArray()));
    }
}
