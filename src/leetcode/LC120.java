package leetcode;

import java.util.List;

public class LC120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();

        for (int i = length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle.get(i)
                        .set(j, triangle.get(i).get(j) +
                                Math.min(triangle.get(i+1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }

        return triangle.get(0).get(0);
    }
}
