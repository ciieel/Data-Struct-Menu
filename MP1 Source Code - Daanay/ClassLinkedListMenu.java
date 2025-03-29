import java.util.Scanner;

public class ClassLinkedListMenu {
    static Scanner scanner = new Scanner(System.in);
    static Node head = null; 

    public static void main(String[] args) {
        linkedListMenu();
    }

    // Menu for Linked List
    static void linkedListMenu() {
        while (true) {
            System.out.println("\n''''Linked List Operations''''");
            System.out.println();
            System.out.println("[1] Create an Empty Linked List");
            System.out.println("[2] Insert an Element");
            System.out.println("[3] Delete an Element");
            System.out.println("[4] Reverse the Linked List");
            System.out.println("[5] Remove Duplicates");
            System.out.println("[6] Display the Linked List");
            System.out.println("[0] Return to Main Menu");
            System.out.println();
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1: createLinkedList();
                    break;
                case 2: insertLLElement(); 
                    break;
                case 3: deleteLLElement(); 
                    break;
                case 4: reverseLinkedList(); 
                    break;
                case 5: removeDuplicates(); 
                    break;
                case 6: displayList(); 
                    break;
                case 0: return;
                default: System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    static void createLinkedList() {
        head = null; 
        System.out.println("An empty linked list has been created.");
    }

    static void insertLLElement() {
        System.out.print("Enter element to insert: ");
        int value = scanner.nextInt();
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Element inserted.");
    }

    static void deleteLLElement() {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }

        System.out.print("Enter element to delete: ");
        int value = scanner.nextInt();

        if (head.data == value) {
            head = head.next;
            System.out.println("Element deleted.");
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Element not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Element deleted.");
            System.out.println("Press Display to see the list");

        }
    }

    static void reverseLinkedList() {
        Node prev = null, current = head, next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        System.out.println("Linked list reversed.");
        System.out.println("Press Display to see the list");

    }

    static void removeDuplicates() {
        Node temp = head;

        while (temp != null) {
            Node inner = temp;
            while (inner.next != null) {
                if (inner.next.data == temp.data) {
                    inner.next = inner.next.next;
                } else {
                    inner = inner.next;
                }
            }
            temp = temp.next;
        }
        System.out.println("Duplicates removed.");
        System.out.println("Press Display to see the list");


    }

    static void displayList() {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }

        System.out.print("Linked List: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void returnMain(){
        MainMenu.main(null);
    }
}
