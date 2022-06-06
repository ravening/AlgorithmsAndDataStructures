package Strings;

/**
 * MInimumWindowSubstringWithOrder
 */
public class MInimumWindowSubstringWithOrder {

    public String solution(String words, String[] target) {
        String[] array = words.split(" ");
        int start = -1;
        int minLength = array.length;
        int index = 0, right = 0, end = 0;

        for (right = 0; right < array.length; right++) {
            if (array[right].equalsIgnoreCase(target[index])) {
                index++;

                // if all words in target matches
                if (index == target.length) {
                    end = right;
                    index--;
                    while (index >= 0) {
                        if (target[index].equalsIgnoreCase(array[right])) {
                            index--;
                        }
                        right--;
                    }

                    // update min length
                    if (minLength > end - right) {
                        minLength = end - right;
                        start = right + 1;
                    }

                    right = start;
                    index = 0;
                }
                
            }
        }

        return buildWord(start, minLength, array);
        
    }

    private String buildWord(int start, int length, String[] array) {
        StringBuilder sb = new StringBuilder();

        for (var i = start; i < start + length; i++) {
            sb.append(array[i]).append(" ");
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        String string = "and career potential to their employees, and their vision and message are stellar examples for";
        String[] target = new String[]{"and", "are", "for"};

        MInimumWindowSubstringWithOrder mInimumWindowSubstringWithOrder = new MInimumWindowSubstringWithOrder();
        System.out.println(mInimumWindowSubstringWithOrder.solution(string, target));
    }
}