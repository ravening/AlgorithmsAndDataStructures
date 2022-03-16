package Trees;

/*
https://leetcode.com/discuss/interview-question/349617
 */
public class SubtreeMaxAverage {
    private NaryTree head;
    private int max = Integer.MIN_VALUE;

    public NaryTree solution(NaryTree root) {
        helper(root);
        return head;
    }

    private double[] helper(NaryTree root) {
        if (root == null)
            return new double[]{0,0};

        int curTotal = root.val;
        int count = 1;

        if (root.children != null) {
            for (NaryTree child : root.children) {
                double[] tmp = helper(child);
                curTotal += tmp[0];
                count += tmp[1];
            }
        }

        int average = curTotal / count;
        if (count > 1 && average > max) {
            max = average;
            head = root;
        }

        return new double[] {curTotal, count};
    }

    static class NaryTree {
        int val;
        NaryTree[] children;
    }
}
