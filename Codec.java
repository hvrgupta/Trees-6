// Time Complexity : O(n) for both the ops
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) return sb.append("[]").toString();
        sb.append("[");
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null) {
                sb.append("null,");
                continue;
            }
            sb.append(node.val + ",");
            q.add(node.left);
            q.add(node.right);
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String nodeStr = data.substring(1,data.length()-1);
        System.out.println(nodeStr);
        if(nodeStr.length() == 0) return null;
        String[] nodeArr = nodeStr.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        int cnt = 0;
        TreeNode root = new TreeNode(Integer.parseInt(nodeArr[cnt++]));
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(!nodeArr[cnt].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodeArr[cnt]));
                node.left = leftNode;
                q.add(leftNode);
            }
            cnt++;
            if(!nodeArr[cnt].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodeArr[cnt]));
                node.right = rightNode;
                q.add(rightNode);
            }
            cnt++;
        }
        return root;
    }
}
