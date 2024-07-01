package leetcode;

public class Result {

    int startIndex;
    int endIndex;

    public Result() {
        this.startIndex = 0;
        this.endIndex = 0;
    }

    public String getResult(String s) {
        return s.substring(startIndex, endIndex);
    }
}
