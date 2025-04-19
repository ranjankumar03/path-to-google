class Inorder_Successor_BST {

    public static void main(String[] args) {
        // Construct a BST
        //         20
        //        /  \
        //       8    22
        //      / \
        //     4   12
        //        /  \
        //       10   14

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        int target = 14;
        Node targetNode = new Node(target);

        Node successor = findSuccessor(root, targetNode);

        if (successor != null) {
            System.out.println("Inorder Successor of " + target + " is: " + successor.value);
        } else {
            System.out.println("Inorder Successor of " + target + " does not exist.");
        }
    }

    private static Node findSuccessor(Node root, Node target) {
        Node succ = null;

        while (root != null) {
            if (root.value > target.value) {
                succ = root; // Update successor
                root = root.left; // Move to the left subtree
            } else {
                root = root.right; // Move to the right subtree
            }
        }

        return succ;
    }
}

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        this.left = this.right = null;
    }
}