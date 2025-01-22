package Trees.sqlparser;

public class WhereNode extends QueryNode {

    private QueryNode left;
    private QueryNode right;
    private String operator;

    public WhereNode(QueryNode left, QueryNode right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public String toSql() {
        return String.format("WHERE %s %s %s ", left.toSql(), operator, right.toSql());
    }
}
