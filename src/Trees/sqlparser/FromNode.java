package Trees.sqlparser;

public class FromNode extends QueryNode {

    private String name;

    public FromNode(String name) {
        this.name = name;
    }

    @Override
    public String toSql() {
        return "FROM " + name + " ";
    }
}
