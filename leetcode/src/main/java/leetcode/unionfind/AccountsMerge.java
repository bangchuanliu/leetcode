package leetcode.unionfind;

import common.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Pair<Integer, String>> map = new HashMap<>();
        int idx = 0;
        UF uf = new UF();
        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!map.containsKey(email)) {
                    map.put(email, new Pair<Integer, String>(idx++, name));
                }
                uf.union(map.get(email).getKey(), map.get(account.get(1)).getKey());
            }
        }

        Map<Integer, TreeSet<String>> m2 = new HashMap<>();

        for (String email : map.keySet()) {
            int root = uf.find(map.get(email).getKey());
            TreeSet<String> set = m2.getOrDefault(root, new TreeSet<>());
            set.add(email);
            m2.put(root, set);
        }

        List<List<String>> ret = new ArrayList<>();

        for (TreeSet<String> emails : m2.values()) {
            List<String> temp = new ArrayList<>(emails);
            String name = map.get(temp.get(0)).getValue();
            temp.add(0, name);
            ret.add(temp);
        }

        return ret;
    }


    class UF {
        int[] id;

        UF() {
            id = new int[10001];
            for (int i = 0; i < id.length; i++) {
                id[i] = i;
            }
        }

        public int find(int x) {
            while (x != id[x]) {
                x = id[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int p = find(x);
            int q = find(y);
            if (p == q) {
                return;
            }
            id[p] = q;
        }

    }

    public static void main(String[] args) {
        String[][] strings = {{"Ethan", "Ethan1@m.co", "Ethan2@m.co", "Ethan0@m.co"}, {"David", "David1@m.co", "David2@m.co", "David0@m.co"}, {"Lily", "Lily0@m.co", "Lily0@m.co", "Lily4@m.co"}, {"Gabe", "Gabe1@m.co", "Gabe4@m.co", "Gabe0@m.co"}, {"Ethan", "Ethan2@m.co", "Ethan1@m.co", "Ethan0@m.co"}};
        List<List<String>> accounts = new ArrayList<>();
        for (String[] strs : strings) {
            accounts.add(Arrays.asList(strs));
        }
        AccountsMerge accountsMerge = new AccountsMerge();
        System.out.println(Arrays.deepToString((accountsMerge.accountsMerge(accounts).toArray())));
    }
}
