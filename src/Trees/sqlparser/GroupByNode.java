package Trees.sqlparser;

public class GroupByNode extends QueryNode {

    private String column;

    public GroupByNode(String column) {
        this.column = column;
    }

    @Override
    public String toSql() {
        return "GROUP BY " + column + " ";
    }
}
