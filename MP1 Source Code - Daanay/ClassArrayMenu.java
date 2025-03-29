import java.util.Scanner;

public class ClassArrayMenu {
    static Scanner scanner = new Scanner(System.in);
    static int[] array = new int[0]; 
    static int count = 0;

    public static void main(String[] args) {
        arrayMenu();
    }

    // Menu for Array
    static void arrayMenu() {
        while (true) {
            System.out.println("\n''''Array Operations''''");
            System.out.println();
            System.out.println("[1] Create an Empty Array");
            System.out.println("[2] Insert an Element");
            System.out.println("[3] Delete an Element");
            System.out.println("[4] Sort in Ascending Order");
            System.out.println("[5] Sort in Descending Order");
            System.out.println("[6] Display Array"); 
            System.out.println("[0] Return to Main Menu");
            System.out.println();
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1: createArray(); 
                    break;
                case 2: insertArrayElement(); 
                    break;
                case 3: deleteArrayElement();
                    break;
                case 4: arrayAscending(); 
                    break;
                case 5: arrayDescending(); 
                    break;
                case 6: arrayDisplay(); 
                    break;
                case 0: return;
                default: System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    static void createArray() {
        array = new int[0];
        count = 0;
        System.out.println("Successful! An empty array created.");
    }

    static void insertArrayElement() {
        System.out.print("Enter the array element you want to insert: ");
        int value = scanner.nextInt();
        int[] newArray = new int[count + 1];

        for (int i = 0; i < count; i++) {
            newArray[i] = array[i];
        }

        newArray[count] = value;
        array = newArray;
        count++;
    }

    static void deleteArrayElement() {
        System.out.print("Enter element to delete: ");
        int value = scanner.nextInt();
        boolean found = false;
        int[] newArray = new int[count - 1];
        int index = 0;

        for (int i = 0; i < count; i++) {
            if (array[i] == value && !found) {
                found = true;
                continue;
            }
            if (index < newArray.length) {
                newArray[index++] = array[i];
            }
        }

        if (found) {
            array = newArray;
            count--;
            System.out.println("Element has been deleted.");
        } else {
            System.out.println("Invalid! Array element not found.");
        }
    }

    static void arrayAscending() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println();
        System.out.println("Array sorted in ascending order.");
        System.out.print("Array elements: ");
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static void arrayDescending() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println();
        System.out.println("Array sorted in descending order.");
        System.out.print("Array elements: ");
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static void arrayDisplay() {
        if (count == 0) {
            System.out.println("The array is empty.");
            return;
        }

        System.out.print("Array elements: ");
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void returnMain(){
        MainMenu.main(null);
    }
}