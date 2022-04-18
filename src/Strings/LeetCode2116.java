package Strings;

public class LeetCode2116 {
    public boolean canBeValid(String s, String locked) {
        System.out.println("length is " + s.length());
        if (s.length() % 2 != 0) {
            return false;
        }
        
        if (isValid(s)) {
            return true;
        } else {
            System.out.println("proceed");
        }
        
        int flippable = 0;
        int balance = 0;
        
        for (var i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                flippable++;
            } else {
                if (s.charAt(i) == '(') {
                    balance++;
                } else {
                    balance--;
                }
                
                
            }
            if (balance + flippable < 0) {
                return false;
            }
        }
        if (balance > flippable) {
            return false;
        }
        flippable = 0;
        balance = 0;
        System.out.println("proceed");
        for (var i = s.length()-1; i>= 0; i--) {
            if (locked.charAt(i) == '0') {
                flippable++;
            } else {
                if (s.charAt(i) == ')') {
                    balance++;
                } else {
                    balance--;
                }
            }
            if (balance + flippable < 0) {
                return false;
            }
           
        }
        
        if (balance > flippable) {
            return false;
        }
        return true;
    }
    
    public boolean isValid(String s) {
        int count = 0;
        
        char[] ch = s.toCharArray();
        
        for (char chr : ch) {
            if (chr == '(') {
                count++;
            } else if (chr == ')') {
                count--;
            }
            
            if (count < 0) {
                return false;
            }
        }
        
        return count == 0;
    }

    public static void main(String[] args) {
        LeetCode2116 lc = new LeetCode2116();

        String s = "((()(()()))()((()()))))()((()(()";
        String locked = "10111100100101001110100010001001";
        System.out.println(lc.canBeValid(s, locked));
    }
}
