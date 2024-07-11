package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/sender-with-largest-word-count/description/
 */
public class LC2284 {

    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();

        for (var i = 0; i < messages.length; i++) {
            map.put(senders[i],
                    map.getOrDefault(senders[i], 0) + messages[i].split(" ").length);
        }

        int max = 0;
        String res = "";

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max || (entry.getValue() == max && entry.getKey().compareTo(res) > 0)) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC2284 lc2284 = new LC2284();
        String[] messages = {"How is leetcode for everyone","Leetcode is useful for practice"};
        String[] senders = {"Bob","Charlie"};

        System.out.println(lc2284.largestWordCount(messages, senders));
    }
}
