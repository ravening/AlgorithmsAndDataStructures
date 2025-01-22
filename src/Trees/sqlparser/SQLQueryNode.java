package Trees.sqlparser;

import java.util.ArrayList;
import java.util.List;

public class SQLQueryNode extends QueryNode {

    List<QueryNode> children;

    public SQLQueryNode() {
        this.children = new ArrayList<>();

    }

    public void addChild(QueryNode child) {
        children.add(child);
    }

    @Override
    public String toSql() {
        StringBuilder sql = new StringBuilder();
        for (QueryNode child : children) {
            sql.append(child.toSql());
        }

        return sql.toString().trim();
    }
}
