package Arrays;

/*
https://www.geeksforgeeks.org/the-celebrity-problem/?ref=lbp
 */
public class CelebrityProblem {
    int[][] array;

    CelebrityProblem(int[][] matrix) {
        this.array = matrix;
    }

    private int solution() {
        int i = 0;
        int j = array[0].length - 1;

        while (i < j) {
            if (array[i][j] == 1) {
                i++;
            } else {
                j--;
            }
        }

        int candidate = i;

        for (i = 0; i < array.length; i++) {
            if (i != candidate) {
                if (array[i][candidate] != 1 || array[candidate][i] != 0) {
                    return -1;
                }
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[][] M = { { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 1, 0 } };
        CelebrityProblem celebrityProblem =
                new CelebrityProblem(M);

        System.out.println(celebrityProblem.solution());
    }
}
