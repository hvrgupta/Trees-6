// Time Complexity : O(n log n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    HashMap<Coordinate, List<Integer>> map;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int rmax = Integer.MIN_VALUE;

    class Coordinate {
        int row;
        int col;

        Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Coordinate that = (Coordinate) obj;
            return row == that.row && col == that.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        map = new HashMap<>();
        helper(root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            List<Integer> li = new ArrayList<>();
            for (int j = 0; j <= rmax; j++) {
                Coordinate c = new Coordinate(j, i);
                if (map.containsKey(c)) {
                    for (int num : map.get(c)) {
                        li.add(num);
                    }
                }
            }
            res.add(li);
        }
        return res;
    }

    private void helper(TreeNode root, int row, int col) {
        if (root == null)
            return;

        min = Math.min(min, col);
        max = Math.max(max, col);
        rmax = Math.max(rmax, row);

        Coordinate c = new Coordinate(row, col);

        if (!map.containsKey(c)) {
            map.put(c, new ArrayList<>());
        }

        map.get(c).add(root.val);

        helper(root.left, row + 1, col - 1);
        helper(root.right, row + 1, col + 1);
    }
}
