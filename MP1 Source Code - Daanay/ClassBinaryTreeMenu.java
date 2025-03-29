import java.util.Scanner;

public class ClassBinaryTreeMenu {
    static Scanner scanner = new Scanner(System.in);
    static Node root = null;

    public static void main(String[] args) {
        binaryTreeMenu();
    }

    // Binary Tree Main Menu
    static void binaryTreeMenu() {
        while (true) {
            System.out.println("\n''''Binary Tree Operations''''");
            System.out.println("[1] Create an Empty Binary Tree");
            System.out.println("[2] Insert an Element");
            System.out.println("[3] Delete an Element");
            System.out.println("[4] Display Tree Structure");
            System.out.println("[0] Return to Main Menu");

            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createBinaryTree();
                    break;
                case 2:
                    insertNode();
                    break;
                case 3:
                    deleteNode();
                    break;
                case 4:
                    displayBinaryTree(root, 0);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.height = 1; 
            this.left = null;
            this.right = null;
        }
    }

    static void createBinaryTree() {
        root = null;
        System.out.println("An empty binary tree created.");
    }

    static void insertNode() {
        System.out.print("Enter value to insert: ");
        int value = scanner.nextInt();
        root = insertRecursive(root, value);
        System.out.println("Element has been inserted.");
    }

    static Node insertRecursive(Node node, int value) {
        if (node == null) return new Node(value);

        if (value < node.data) {
            node.left = insertRecursive(node.left, value);
        } else {
            node.right = insertRecursive(node.right, value);
        }

        // Update height 
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // Balance the node
        return balanceNode(node);
    }

    static void deleteNode() {
        System.out.print("Enter value to delete: ");
        int value = scanner.nextInt();
        root = deleteRecursive(root, value);
    }

    static Node deleteRecursive(Node node, int value) {
        if (node == null) {
            System.out.println("Value is not in the tree.");
            return null;
        }

        if (value < node.data) {
            node.left = deleteRecursive(node.left, value);
        } else if (value > node.data) {
            node.right = deleteRecursive(node.right, value);
        } else {
            if (node.left == null || node.right == null) {
                Node temp = (node.left != null) ? node.left : node.right;
                if (temp == null) return null;
                else return temp;
            }

            int minValue = findMinValue(node.right);
            node.data = minValue;
            node.right = deleteRecursive(node.right, minValue);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        return balanceNode(node);
    }

    static int findMinValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    static void displayBinaryTree(Node node, int level) {
        if (node == null) return;

        displayBinaryTree(node.right, level + 1);

        for (int i = 0; i < level; i++) System.out.print("   ");
        System.out.println(node.data);

        displayBinaryTree(node.left, level + 1);
    }

    static int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }

    static int getBalanceFactor(Node node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    static Node balanceNode(Node node) {
        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rotateRight(node);
        }

        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return rotateLeft(node);
        }

        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    static Node rotateRight(Node y) {
        Node x = y.left;
        Node T = x.right;

        x.right = y;
        y.left = T;

        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }

    static Node rotateLeft(Node x) {
        Node y = x.right;
        Node T = y.left;

        y.left = x;
        x.right = T;

        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));

        return y;
    }

    public static void returnMain() {
        MainMenu.main(null);
    }
}
