package assignment21;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int value;
    Node left;
    Node right;
    Node nextRight;

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.nextRight = null;
    }
}

public class Question4 {
    Node root;

    void connectNodesAtSameLevel(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Node prev = null;
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                if (prev != null)
                    prev.nextRight = current;

                prev = current;
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }

            prev.nextRight = null;
        }
    }

    void printConnectedNodes(Node root) {
        Node current = root;
        while (current != null) {
            Node temp = current;
            while (temp != null) {
                System.out.print(temp.value + " -> ");
                temp = temp.nextRight;
            }
            System.out.println("-1");
            current = current.left;
        }
    }
}

