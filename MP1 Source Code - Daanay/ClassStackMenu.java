import java.util.Scanner;

class ClassStackMenu {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public ClassStackMenu(int size) {
        this.maxSize = size;
        this.top = -1;
        this.stackArray = new int[maxSize];
    }

    public void pushStackElement(int element) {
        if (top == maxSize - 1) {
            System.out.println("\nSTACK OVERFLOW");
        } else {
            stackArray[++top] = element;
            System.out.println("Element " + element + " pushed into stack.");
        }
    }

    public void popStackElement() {
        if (top == -1) {
            System.out.println("STACK UNDERFLOW");
        } else {
            System.out.println("Element " + stackArray[top] + " popped from stack.");
            top--;
        }
    }

    public void modifyStack(int index, int newValue) {
        if (index < 0 || index > top) {
            System.out.println("Invalid index! Modification failed.");
        } else {
            stackArray[index] = newValue;
            System.out.println("Element at index " + index + " modified to " + newValue);
        }
    }

    public void displayStack() {
        if (top == -1) {
            System.out.println("STACK IS EMPTY");
        } else {
            System.out.println("Stack elements:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stackArray[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClassStackMenu stack = null;
        int choice;
        
        do {
            System.out.println("\n''''Stack Operations''''\n");
            System.out.println("1. Create an Empty Stack");
            System.out.println("2. PUSH element");
            System.out.println("3. POP element");
            System.out.println("4. Modify a Specific Element");
            System.out.println("5. Display the Stack");
            System.out.println("0. RETURN TO MAIN MENU");
            System.out.print("\nYour choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter stack size: ");
                    int size = scanner.nextInt();
                    stack = new ClassStackMenu(size);
                    System.out.println("Stack created with size " + size);
                    break;
                case 2:
                    if (stack == null) {
                        System.out.println("Create a stack first!");
                    } else {
                        System.out.print("Enter element to push: ");
                        int element = scanner.nextInt();
                        stack.pushStackElement(element);
                    }
                    break;
                case 3:
                    if (stack == null) {
                        System.out.println("Create a stack first!");
                    } else {
                        stack.popStackElement();
                    }
                    break;
                case 4:
                    if (stack == null) {
                        System.out.println("Create a stack first!");
                    } else {
                        System.out.print("Enter index to modify: ");
                        int index = scanner.nextInt();
                        System.out.print("Enter new value: ");
                        int newValue = scanner.nextInt();
                        stack.modifyStack(index, newValue);
                    }
                    break;
                case 5:
                    if (stack == null) {
                        System.out.println("Create a stack first!");
                    } else {
                        stack.displayStack();
                    }
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void returnMain() {
        MainMenu.main(null);
    }
}
