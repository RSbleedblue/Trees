public class Solution {
    public static BinaryTreeNode<Integer> lcaOfThreeNodes(BinaryTreeNode<Integer> root, int node1, int node2, int node3) {
        if (root == null) {
            return null;
        }
        return lcaOfThreeNodesHelper(root, node1, node2, node3);
    }

    private static BinaryTreeNode<Integer> lcaOfThreeNodesHelper(BinaryTreeNode<Integer> root, int node1, int node2, int node3) {
        if (root == null) {
            return null;
        }

        if (root.data == node1 || root.data == node2 || root.data == node3) {
            return root;
        }

        BinaryTreeNode<Integer> leftLCA = lcaOfThreeNodesHelper(root.left, node1, node2, node3);
        BinaryTreeNode<Integer> rightLCA = lcaOfThreeNodesHelper(root.right, node1, node2, node3);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        return (leftLCA != null) ? leftLCA : rightLCA;
    }
}
