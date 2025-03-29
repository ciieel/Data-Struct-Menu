import java.util.*;

public class MainMenu {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int intChoice = 0;

        // Main Menu for Data Structure ToolKit
        do {
            System.out.println("\n''''Data Structures ToolKit''''");
            System.out.println("[1] Array");
            System.out.println("[2] Linked List");
            System.out.println("[3] Stack");
            System.out.println("[4] Queue");
            System.out.println("[5] Binary Search Tree");
            System.out.println("[6] EXIT");
            System.out.println();
            System.out.print("Your Choice: ");
            intChoice = scan.nextInt();

            switch(intChoice) {
                case 1:
                    ClassArrayMenu.main(null);
                    break;
                case 2:
                    ClassLinkedListMenu.main(null);
                    break;
                case 3:
                    ClassStackMenu.main(null);
                    break;
                case 4:
                    ClassQueueMenu.main(null);
                    break;
                 case 5:
                    ClassBinaryTreeMenu.main(null);
                     break;
                case 6:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (intChoice != 6);

        scan.close();
    }
}
