package assignment21;

public class Question2 {


	public static class Node{
		int value;
		Node left;
		Node right;
		public Node(int value) {
			this.value=value;
		}
	}
	Node root;

	    Node findLCA(Node node, int key1, int key2) {
	        if (node == null)
	            return null;
	        
	        // If both keys are less than the current node's value,
	        // the LCA lies in the left subtree
	        if (key1 < node.value && key2 < node.value)
	            return findLCA(node.left, key1, key2);
	        
	        // If both keys are greater than the current node's value,
	        // the LCA lies in the right subtree
	        if (key1 > node.value && key2 > node.value)
	            return findLCA(node.right, key1, key2);
	        
	        // If the above conditions are not met, it means the current
	        // node is the LCA
	        return node;
	    }

	    int findDistance(Node node, int key, int distance) {
	        if (node == null)
	            return -1; // Key not found

	        if (node.value == key)
	            return distance;
	        
	        // If the key is less than the current node's value, search in the left subtree
	        if (key < node.value)
	            return findDistance(node.left, key, distance + 1);
	        
	        // If the key is greater than the current node's value, search in the right subtree
	        if (key > node.value)
	            return findDistance(node.right, key, distance + 1);
	        
	        return -1; // Key not found
	    }

	    int findDistanceBetweenNodes(int key1, int key2) {
	        Node lca = findLCA(root, key1, key2);
	        
	        // Find the distance from the LCA to both keys
	        int distance1 = findDistance(lca, key1, 0);
	        int distance2 = findDistance(lca, key2, 0);

	        return distance1 + distance2;
	    }
	
	    public static void main(String[] args) {
	        Question2 bst=new Question2();
	        bst.root = new Node(5);
	        bst.root.left = new Node(3);
	        bst.root.right = new Node(7);
	        bst.root.left.left = new Node(2);
	        bst.root.left.right = new Node(4);
	        bst.root.right.left = new Node(6);
	        bst.root.right.right = new Node(8);

	        int key1 = 2;
	        int key2 = 8;

	        int distance = bst.findDistanceBetweenNodes(key1, key2);
	        System.out.println("Distance between " + key1 + " and " + key2 + " is " + distance);
	    }

}
