package Day3StacksQueues;

public class PostfixExpression {
    //evaluate a postfix expression
    //postfix expression: 2 3 1 * + 9 -
    //infix expression: 2 + 3 * 1 - 9
    //infix expression: 2 + (3 * 1) - 9
    //infix expression: 2 + 3 - 9
    //infix expression: 5 - 9
    //infix expression: -4

    public int evaluatePostfix(String expression) {
        StackArray stack = new StackArray(expression.length());

        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if(Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch(c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                }
            }
        }

        return stack.pop();
    }
}
