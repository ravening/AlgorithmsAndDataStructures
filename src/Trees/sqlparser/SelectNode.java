package Trees.sqlparser;

import java.util.List;

public class SelectNode extends QueryNode {

    private List<String> columns;

    public SelectNode(List<String> columns) {
        this.columns = columns;
    }

    @Override
    public String toSql() {
        if (columns == null || columns.isEmpty()) {
            return "SELECT * ";
        }
        return "SELECT " + String.join(", ", columns) + " ";
    }
}
