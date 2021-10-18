package Strings;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String string = "becoming good at programming needs lot of practice";
        String[] words = string.split("\\s+");
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        words = reverseWordsInString.reverseWords(words);

        string = String.join(" ", words);
        System.out.println(string);
    }

    public String[] reverseWords(String[] words) {
        int length = words.length;

        if (length % 2 == 0) {
            int mid = length / 2;

            while (mid < length) {
                String tmp = words[mid];
                words[mid] = words[length - mid - 1];
                words[length - mid - 1] = tmp;
                mid++;
            }
        } else {
            int mid = (length / 2) + 1;

            while (mid < length) {
                String tmp = words[mid];
                words[mid] = words[length - mid - 1];
                words[length - mid - 1] = tmp;
                mid++;
            }
        }

        return words;
    }

}
