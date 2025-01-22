package Trees.sqlparser;

import java.util.Arrays;

public class Parser {

    public static void main(String[] args) {
        QueryNode select = new SelectNode(Arrays.asList("id, name, age"));
        QueryNode from = new FromNode("users");
        QueryNode where = new WhereNode(new LeftNode("age"), new RightNode("18"), ">");
        QueryNode join = new JoinQueryNode("addresses", "users.id = addresses.user_id");
        QueryNode groupBy = new GroupByNode("name");
        QueryNode having = new HavingNode("SUM(age) > 100");

        SQLQueryNode query = new SQLQueryNode();
        query.addChild(select);
        query.addChild(from);
        query.addChild(join);
        query.addChild(where);
        query.addChild(groupBy);
        query.addChild(having);
        System.out.println(query.toSql());
    }
}
