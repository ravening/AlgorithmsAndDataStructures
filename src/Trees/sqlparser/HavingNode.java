package Trees.sqlparser;

public class HavingNode extends QueryNode {
    private String condition;

    public HavingNode(String condition) {
        this.condition = condition;
    }

    @Override
    public String toSql() {
        return "HAVING " + condition + " ";
    }
}
