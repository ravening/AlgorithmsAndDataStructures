package Arrays;

/*
https://towardsdatascience.com/tackling-jump-game-problems-leetcode-e0a718e7dfba
 */
public class JumpGame {
    public static boolean solution(int[] array) {
        int i = 0, maxreach = 0;

        while (i < array.length && i <= maxreach) {
            maxreach = Math.max(maxreach, i + array[i]);
            i++;
        }

        return i == array.length;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 1, 4};
        System.out.println(solution(array));
        array = new int[]{3, 2, 1, 0 , 4};
        System.out.println(solution(array));
    }
}
