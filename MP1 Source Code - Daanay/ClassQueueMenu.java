import java.util.Scanner;

public class ClassQueueMenu {
    static Scanner scanner = new Scanner(System.in);
    static int[] queue = new int[2];
    static int front = -1, rear = -1, size = 0;

    public static void main(String[] args) {
        queueMenu();
    }

    // Queue Main Menu
    static void queueMenu() {
        while (true) {
            System.out.println("\n''''Queue Operations''''");
            System.out.println();
            System.out.println("[1] Enqueue an Element");
            System.out.println("[2] Dequeue an Element");
            System.out.println("[3] Display Front");
            System.out.println("[4] Display Rear");
            System.out.println("[5] Display the Queue");
            System.out.println("[0] Return to Main Menu");
            System.out.println();
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: enqueue(); 
                    break;
                case 2: dequeue(); 
                    break;
                case 3: displayFront(); 
                    break;
                case 4: displayRear(); 
                    break;
                case 5: displayQueue(); 
                    break;
                case 0: return;
                default: System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    static void enqueue() {
        if (rear == queue.length - 1) {
        }

        System.out.print("Enter element to enqueue: ");
        int value = scanner.nextInt();

        if (front == -1) front = 0; 
        rear++;
        queue[rear] = value;
        size++;
        
        System.out.println("Element enqueued.");
    }

    static void dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("QUEUE UNDERFLOW: Cannot dequeue, queue is empty.");
            return;
        }

        System.out.println("Dequeued element: " + queue[front]);
        front++;
        size--;

        if (front > rear) {
            front = -1;
            rear = -1;
        }
    }

    static void displayFront() {
        if (front == -1 || front > rear) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("Front element: " + queue[front] + " at index " + front);
        }
    }

    static void displayRear() {
        if (rear == -1) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("Rear element: " + queue[rear] + " at index " + rear);
        }
    }

    static void displayQueue() {
        if (front == -1 || front > rear) {
            System.out.println("Empty Queue");
            return;
        }

        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void returnMain() {
        MainMenu.main(null);
    }
}
