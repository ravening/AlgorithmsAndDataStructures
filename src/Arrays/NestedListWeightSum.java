package Arrays;

import java.util.Arrays;
import java.util.List;

//LC339
/**
 * The LeetCode problem “Nested List Weight Sum” involves calculating the sum of all integers in a nested list, weighted by their depth. The integers at the first level have a weight of 1, the integers at the second level have a weight of 2, and so on.
 *
 * Problem Description:
 *
 * You are given a nested list of integers. Each element is either an integer or a list whose elements may also be integers or other lists. Implement a function to compute the sum of all integers in the list weighted by their depth.
 *
 * Approach:
 *
 * 	1.	Depth-First Search (DFS): We can use DFS to traverse the nested list, keeping track of the current depth.
 * 	2.	Recursive Function: For each element in the nested list, if it is an integer, add its value multiplied by the current depth to the total sum. If it is a list, recursively calculate the sum for that list with an incremented depth.
 *
 *
 *
 1.	NestedInteger Interface: This interface is provided by LeetCode. It defines the structure for a nested list element.
 2.	depthSum Method: This method takes a list of NestedInteger and returns the weighted sum of all integers in the list.
 3.	depthSumHelper Method: This recursive helper method traverses the nested list. It takes the current depth as an argument and calculates the weighted sum for the nested list.
 4.	Main Method: This part demonstrates an example usage of the depthSum method. Note that NestedIntegerImpl is a hypothetical implementation of the NestedInteger interface for the purpose of this example.
 */
public class NestedListWeightSum {

    public static void main(String[] args) {
        NestedInteger ni1 = new NestedIntegerImpl(1);
        NestedInteger ni2 = new NestedIntegerImpl(1);

        NestedInteger nil = new NestedIntegerImpl(Arrays.asList(ni1, ni2));

        NestedInteger ni3 = new NestedIntegerImpl(2);

        NestedInteger ni4 = new NestedIntegerImpl(1);
        NestedInteger ni5 = new NestedIntegerImpl(1);

        NestedInteger nil2 = new NestedIntegerImpl(Arrays.asList(ni4, ni5));

        List<NestedInteger> list = (Arrays.asList(nil, ni3, nil2));

        NestedListWeightSum nlws = new NestedListWeightSum();
        System.out.println(nlws.solution(list));
    }

    public int solution(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> nestedList, int depth) {
        int sum = 0;

        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                sum += nestedInteger.getInteger() * depth;
            } else {
                sum += dfs(nestedInteger.getList(), depth + 1);
            }
        }

        return sum;
    }
}

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

/**
 * 1.	NestedIntegerImpl Class: This class implements the NestedInteger interface and provides methods to handle both single integers and nested lists.
 * 	2.	Constructors: There are three constructors:
 * 	•	One for initializing with a single integer.
 * 	•	One for initializing an empty nested list.
 * 	•	One for initializing with a given nested list.
 * 	3.	isInteger Method: Checks if the current NestedInteger holds a single integer.
 * 	4.	getInteger Method: Returns the single integer if it holds one, otherwise returns null.
 * 	5.	setInteger Method: Sets the current NestedInteger to hold a single integer.
 * 	6.	add Method: Adds a nested integer to the list.
 * 	7.	getList Method: Returns the nested list if it holds one, otherwise returns null.
 *
 * This implementation ensures that you can create and manipulate nested lists of integers, which is necessary for testing the depthSum function from the Solution class.
 */
class NestedIntegerImpl implements NestedInteger {
    private final Integer integer;
    private final List<NestedInteger> list;

    NestedIntegerImpl(Integer value) {
        this.integer = value;
        this.list = null;
    }

    NestedIntegerImpl(List<NestedInteger> nestedList) {
        this.integer = null;
        this.list = nestedList;
    }

    @Override
    public boolean isInteger() {
        return integer != null;
    }

    @Override
    public Integer getInteger() {
        return integer;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}
