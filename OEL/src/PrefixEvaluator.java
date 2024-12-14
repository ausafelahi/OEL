//Areesha Magsi 65362
public class PrefixEvaluator {
    static int evaluatePrefix(String expression) {
        int[] stack = new int[expression.length()];
        int stackTopIndex = -1;

        for (int currentIndex = expression.length() - 1; currentIndex >= 0; currentIndex--) {
            char currentCharacter = expression.charAt(currentIndex);

            if (Character.isDigit(currentCharacter)) {
                stack[++stackTopIndex] = currentCharacter - '0';
            } else {
                int leftOperand = stack[stackTopIndex--];
                int rightOperand = stack[stackTopIndex--];
                switch (currentCharacter) {
                    case '+': stack[++stackTopIndex] = leftOperand + rightOperand; break;
                    case '-': stack[++stackTopIndex] = leftOperand - rightOperand; break;
                    case '*': stack[++stackTopIndex] = leftOperand * rightOperand; break;
                    case '/': stack[++stackTopIndex] = leftOperand / rightOperand; break;
                }
            }
        }
        return stack[stackTopIndex];
    }
}