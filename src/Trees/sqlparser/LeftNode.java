package Trees.sqlparser;

public class LeftNode extends QueryNode{

    private String value;

    public LeftNode(String value) {
        this.value = value;
    }

    @Override
    public String toSql() {
        return value;
    }
}
