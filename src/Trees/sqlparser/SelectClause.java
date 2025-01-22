package Trees.sqlparser;

public class SelectClause extends QueryNode {
    private String clause;

    public SelectClause(String clause) {
        this.clause = clause;
    }

    @Override
    public String toSql() {
        if (clause == null || clause.isEmpty()) {
            return "*";
        }
        return clause;
    }
}
