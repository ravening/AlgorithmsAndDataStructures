// given a dictionary containing words and a stream of characters, count the number of each words which can be formed

// if stream character is acacabcatghhellomvnsdb and dict is {["aca","cat","hello","world"] }
// find and display count of each and every word once the stream ends.(Like : "aca" : 2 , "cat" : 1 , "hello" : 1 ,
// "world" : 0 ).

package Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SearchWordInCharStream {
    static Map<String, StringBuilder> dict = new HashMap<>();
    static Map<String, Integer> answer = new HashMap<>();

    public static void solution(Character c) {
        // append the character to each of the dictionary word

        dict.keySet()
                .parallelStream()
                .forEach(string -> processCharacter(string, c));
    }

    public static void processCharacter(String string, Character c) {
        dict.get(string).append(c);

        // check if it matches any of the dictionary word
        if (dict.get(string).toString().equals(string)) {
            answer.put(string, answer.get(string) + 1);
        }

        // if length of the character stream is as the key then delete the first character
        if (dict.get(string).length() == string.length()) {
            dict.get(string).deleteCharAt(0);
        }
    }

    public static void main(String args[]) {
        String[] dictionary = {"aca", "cat", "hello", "world"};

        Arrays.stream(dictionary)
                .forEach(string -> {
                    dict.put(string, new StringBuilder());
                    answer.put(string, 0);
                });

        String stream = "acacabcatghhellomvnsdb";

        for (Character character : stream.toCharArray()) {
            solution(character);
        }

        Set<String> set = dict.keySet();
        for (String key : set) {
            System.out.print(key + " -> " + dict.get(key));
        }
    }
}
