package Arrays;

import java.util.*;

/*
https://leetcode.com/problems/accounts-merge/discuss/1774749/JAVA-Union-Find
 */
public class MergeAccounts {

    public List<List<String>> solution(List<List<String>> accounts) {
        Map<String, Integer> emailMap = new HashMap<>();
        UnionFind unionFind = new UnionFind(accounts.size());

        for (var i = 0; i < accounts.size(); i++) {
            List<String> emails = accounts.get(i);
            for (var j = 1; j < emails.size(); j++) {
                if (!emailMap.containsKey(emails.get(j))) {
                    emailMap.put(emails.get(j), i);
                } else {
                    unionFind.union(j, emailMap.get(emails.get(j)));
                }
            }
        }

        Map<Integer, List<String>> accountMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : emailMap.entrySet()) {
            int accountId = entry.getValue();
            int parentId = unionFind.find(accountId);
            if (!accountMap.containsKey(parentId)) {
                accountMap.put(parentId, new ArrayList<>());
            }
            accountMap.get(accountId).add(entry.getKey());
        }

        // final result
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : accountMap.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            emails.add(0, accounts.get(entry.getKey()).get(0));
            result.add(emails);

        }

        return result;
    }
}
