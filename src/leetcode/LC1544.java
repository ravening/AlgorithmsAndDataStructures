package leetcode;

public class LC1544 {


    public String makeGood(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int pt2 = 0;
        for(int i = 0; i<s.length(); i++){
            if(pt2>0 && Math.abs(sb.charAt(pt2-1) - s.charAt(i)) == 32){
                pt2--;
                sb.deleteCharAt(pt2);
            }
            else{
                sb.append(s.charAt(i));
                pt2++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC1544 lc1544 = new LC1544();
        System.out.println(lc1544.makeGood("leEeetcode"));  // Output: "leetcode"
        System.out.println(lc1544.makeGood("abBAcC"));  // Output: ""
        System.out.println(lc1544.makeGood("s"));  // Output: "s"
    }
}
