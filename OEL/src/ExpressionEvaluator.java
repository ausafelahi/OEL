import java.util.Scanner;
public class ExpressionEvaluator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("Choose an option:");
			System.out.println("1. Evaluate Postfix Expression");
			System.out.println("2. Evaluate Prefix Expression");
			System.out.println("3. Evaluate Infix Expression");
			System.out.println("4. Exit");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
            case 1:
                System.out.println("Enter a postfix expression:");
                String postfix = scanner.nextLine();
                System.out.println("Result: " + PostfixEvaluator.evaluatePostfix(postfix));
                break;

            case 2:
                System.out.println("Enter a prefix expression:");
                String prefix = scanner.nextLine();
                System.out.println("Result: " + PrefixEvaluator.evaluatePrefix(prefix));
                break;

            case 3:
                System.out.println("Enter an infix expression:");
                String infix = scanner.nextLine();
                System.out.println("Result: " + InfixEvaluator.evaluateInfix(infix));
                break;

            case 4:
                System.out.println("Exiting... Goodbye!");
                return;

            default:
                System.out.println("Invalid choice! Please try again.");
        }
		}
	}

}
