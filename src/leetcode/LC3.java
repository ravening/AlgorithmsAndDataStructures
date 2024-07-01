package leetcode;

public class LC3 {

    public static void main(String[] args) {
        String string = "GEEKSFORGEEKS";
        LC3 lc3 = new LC3();

        Result result = lc3.solution(string);

        System.out.println("lenght is " + (result.endIndex - result.startIndex));
        System.out.println(result.getResult(string));
    }

    public Result solution(String string) {
        Result result = new Result();
        int[] array = new int[256];
        int i = 0, j, max = 0;

        if (string == null || string.isEmpty()) {
            return result;
        }

        for (j = 0; j < string.length(); j++) {
            i = array[string.charAt(j)] > 0 ?
                    Math.max(i, array[string.charAt(j)]) : i;

            array[string.charAt(j)] = j + 1;
            if ((j-i + 1) > max) {
                max = j-i + 1;
                result.endIndex = j+1;
                result.startIndex = i;
            }
        }

        return result;
    }
}
