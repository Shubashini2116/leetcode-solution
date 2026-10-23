class Solution {
    public List<Boolean> getResults(int[][] queries) {
        int maxPos = 0;
        for (int[] q : queries) {
            maxPos = Math.max(maxPos, q[1]);
        }
        maxPos += 2;

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        obstacles.add(maxPos);

        SegmentTree tree = new SegmentTree(maxPos);
        tree.update(1, 0, maxPos, maxPos, maxPos);

        List<Boolean> result = new ArrayList<>();

        for (int[] q : queries) {
            if (q[0] == 1) {
                int x = q[1];
                Integer higher = obstacles.higher(x);
                Integer lower = obstacles.lower(x);

                obstacles.add(x);
                tree.update(1, 0, maxPos, x, x - lower);
                tree.update(1, 0, maxPos, higher, higher - x);
            } else {
                int x = q[1];
                int sz = q[2];

                int maxGap = tree.query(1, 0, maxPos, 0, x);
                Integer lastObs = obstacles.floor(x);
                if (lastObs != null) {
                    maxGap = Math.max(maxGap, x - lastObs);
                }

                result.add(maxGap >= sz);
            }
        }

        return result;
    }

    static class SegmentTree {
        int[] tree;

        SegmentTree(int n) {
            tree = new int[4 * (n + 1)];
        }

        void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
                return;
            }
            int mid = (start + end) / 2;
            if (idx <= mid) {
                update(2 * node, start, mid, idx, val);
            } else {
                update(2 * node + 1, mid + 1, end, idx, val);
            }
            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }

        int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) {
                return 0;
            }
            if (l <= start && end <= r) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            return Math.max(query(2 * node, start, mid, l, r), query(2 * node + 1, mid + 1, end, l, r));
        }
    }
}