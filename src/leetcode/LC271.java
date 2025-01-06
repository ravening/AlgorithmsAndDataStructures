package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC271 {

    public static void main(String[] args) {
        LC271 lc271 = new LC271();
        System.out.println(lc271.encode(new String[]{"Hello", "World"}));  // Output: "Hello#World"
    }

    public String encode(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('/').append(str);
        }

        return sb.toString();
    }

    public String[] decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.parseInt(s.substring(i, slash));
            result.add(s.substring(slash + 1, slash + 1 + size));
            i = slash + 1 + size;
        }

        return result.toArray(new String[0]);
    }
}
