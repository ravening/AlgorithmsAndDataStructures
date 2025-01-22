package Trees.sqlparser;

public class JoinQueryNode extends QueryNode {

    private String table;
    private String condition;

    public JoinQueryNode(String table, String condition) {
        this.table = table;
        this.condition = condition;
    }

    @Override
    public String toSql() {
        return String.format("JOIN %s ON %s ", table, condition);
    }
}
