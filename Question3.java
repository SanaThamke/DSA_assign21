package assignment21;

public class Question3 {

	public static class Node{
		int value;
		Node left;
		Node right;
		public Node(int value) {
			this.value=value;
		}
	}
	    Node prev;

	    void convertToDoublyLinkedList(Node root) {
	        if (root == null)
	            return;

	        convertToDoublyLinkedList(root.left);

	        if (prev == null) {
	            root.left = null;
	        } else {
	            prev.right = root;
	            root.left = prev;
	        }
	        prev = root;
	        convertToDoublyLinkedList(root.right);
	    }

	    void printDoublyLinkedList(Node head) {
	        Node curr = head;
	        while (curr != null) {
	            System.out.print(curr.value + " ");
	            curr = curr.right;
	        }
	    }
	}

