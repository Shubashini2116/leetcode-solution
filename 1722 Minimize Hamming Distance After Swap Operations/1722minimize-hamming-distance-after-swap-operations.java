import java.util.*;

class Solution {
    int[] p;

    int find(int x) {
        return p[x] == x ? x : (p[x] = find(p[x]));
    }

    public int minimumHammingDistance(int[] s, int[] t, int[][] swaps) {
        int n = s.length;
        p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;

        for (int[] x : swaps)
            p[find(x[0])] = find(x[1]);

        Map<Integer, Map<Integer, Integer>> m = new HashMap<>();

        for (int i = 0; i < n; i++)
            m.computeIfAbsent(find(i), k -> new HashMap<>())
             .merge(s[i], 1, Integer::sum);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> f = m.get(find(i));
            int c = f.getOrDefault(t[i], 0);

            if (c > 0) f.put(t[i], c - 1);
            else ans++;
        }

        return ans;
    }
}