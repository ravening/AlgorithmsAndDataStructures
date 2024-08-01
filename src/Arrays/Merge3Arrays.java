package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Merge3Arrays {

    public Integer[] merge(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0, k =0;
        int a = 0, b= 0, c = 0;

        while (i < nums1.length || j < nums2.length || k < nums3.length ) {
            a = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
            b = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;
            c = k < nums3.length ? nums3[k] : Integer.MAX_VALUE;

            int min = Math.min(a, Math.min(b, c));
            if (list.isEmpty() || list.get(list.size() - 1) != min) {
                list.add(min);
            }

            if (i < nums1.length && list.get(list.size() - 1) == a) {
                i++;
            }
            if (j < nums2.length && list.get(list.size() - 1) == b) {
                j++;
            }
            if (k < nums3.length && list.get(list.size() - 1) == c) {
                k++;
            }
        }

        Integer[] res = new Integer[list.size()];
        list.toArray(res);
        return res;
    }
}
