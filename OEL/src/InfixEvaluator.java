// Ausaf Elahi 65916
public class InfixEvaluator {
    static int evaluateInfix(String expression) {
        char[] operators = new char[expression.length()];
        int[] operands = new int[expression.length()];
        int opTop = -1, numTop = -1;

        for (int i = 0; i < expression.length(); i++) {
            char name = expression.charAt(i);

            if (Character.isDigit(name)) {
                operands[++numTop] = name - '0';
            } else if (name == '(') {
                operators[++opTop] = name;
            } else if (name == ')') {
                while (opTop != -1 && operators[opTop] != '(') {
                    char operator = operators[opTop--];
                    int num2 = operands[numTop--];
                    int num1 = operands[numTop--];
                    operands[++numTop] = applyOperation(num1, num2, operator);
                }
                opTop--;
            } else {
                while (opTop != -1 && precedence(operators[opTop]) >= precedence(name)) {
                    char operator = operators[opTop--];
                    int num2 = operands[numTop--];
                    int num1 = operands[numTop--];
                    operands[++numTop] = applyOperation(num1, num2, operator);
                }
                operators[++opTop] = name;
            }
        }

        while (opTop != -1) {
            char operator = operators[opTop--];
            int num2 = operands[numTop--];
            int num1 = operands[numTop--];
            operands[++numTop] = applyOperation(num1, num2, operator);
        }

        return operands[numTop];
    }

    static int applyOperation(int num1, int num2, char operator) {
        switch (operator) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': return num1 / num2;
        }
        return 0;
    }

    static int precedence(char operator) {
        if (operator == '+' || operator == '-') return 1;
        if (operator == '*' || operator == '/') return 2;
        return 0;
    }
}
