package Trees.sqlparser;

public class RightNode extends QueryNode {

    private String value;

    public RightNode(String value) {
        this.value = value;
    }

    @Override
    public String toSql() {
        return value;
    }
}
