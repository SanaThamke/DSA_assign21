package assignment21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question1 {
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val=val;
		}
	}

	private static void inorderTraversal(TreeNode node, List<Integer> values) {
        if (node == null)
            return;
        inorderTraversal(node.left, values);
        values.add(node.val);
        inorderTraversal(node.right, values);
    }

    private static TreeNode buildBST(TreeNode node, List<Integer> values, int[] index) {
        if (node == null)
            return null;
        node.val = values.get(index[0]);
        index[0]++;
        node.left = buildBST(node.left, values, index);
        node.right = buildBST(node.right, values, index);
        return node;
    }

    public static TreeNode convertBinaryTreeToBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorderTraversal(root, values);
        Collections.sort(values);
        int[] index = {0};
        return buildBST(root, values, index);
    }
    private static boolean verifyBST(TreeNode node, int minVal, int maxVal) {
        if (node == null)
            return true;
        if (node.val < minVal || node.val > maxVal)
            return false;
        return verifyBST(node.left, minVal, node.val - 1) &&
                verifyBST(node.right, node.val+ 1, maxVal);
    }

}
