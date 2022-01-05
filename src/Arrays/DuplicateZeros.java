package Arrays;

public class DuplicateZeros {
    public static void solution(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (var i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }
        String str = sb.toString();
        str = str.replaceAll("0", "00");

        for (var i = 0; i < array.length; i++) {
            array[i] = str.charAt(i) - '0';
        }

        for (var i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 0, 2, 3, 0, 4, 5, 0};
        solution(array);
    }
}
