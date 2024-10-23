import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class QueueNode {
    Node node;
    Node parent;
    int level;

    QueueNode(Node n, Node p, int l) {
        node = n;
        parent = p;
        level = l;
    }
}

public class Solution {
    public Node replaceWithCousinsSum(Node root) {
        if (root == null) return null;

        Queue<QueueNode> q = new LinkedList<>();
        q.add(new QueueNode(root, null, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int levelSum = 0;

            for (int i = 0; i < size; i++) {
                QueueNode qNode = q.poll();
                levelSum += qNode.node.data;
                q.add(qNode);
            }

            for (int i = 0; i < size; i++) {
                QueueNode qNode = q.poll();
                Node node = qNode.node;
                Node parent = qNode.parent;

                int sumOfCousins = levelSum;

                if (parent != null && parent.left == node && parent.right != null) {
                    sumOfCousins -= parent.right.data;
                }
                if (parent != null && parent.right == node && parent.left != null) {
                    sumOfCousins -= parent.left.data;
                }

                sumOfCousins -= node.data;

                node.data = sumOfCousins;

                if (node.left != null) q.add(new QueueNode(node.left, node, qNode.level + 1));
                if (node.right != null) q.add(new QueueNode(node.right, node, qNode.level + 1));
            }
        }

        return root;
    }
}
