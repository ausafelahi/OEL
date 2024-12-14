//Muskan Zehra 62553//

public class PostfixEvaluator {
    static int evaluatePostfix(String expression) {
        int[] stack = new int[expression.length()];
        int stackTopIndex = -1;

        for (int currentIndex = 0; currentIndex < expression.length(); currentIndex++) {
            char currentCharacter = expression.charAt(currentIndex);

            if (Character.isDigit(currentCharacter)) {
                stack[++stackTopIndex] = currentCharacter - '0';
            } else {
                int secondOperand = stack[stackTopIndex--];
                int firstOperand = stack[stackTopIndex--];
                switch (currentCharacter) {
                    case '+': stack[++stackTopIndex] = firstOperand + secondOperand; break;
                    case '-': stack[++stackTopIndex] = firstOperand - secondOperand; break;
                    case '*': stack[++stackTopIndex] = firstOperand * secondOperand; break;
                    case '/': stack[++stackTopIndex] = firstOperand / secondOperand; break;
                }
            }
        }

        return stack[stackTopIndex];
    }
}