package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.BinaryOperator;

public class Solution5 {
    public static void main(String[] args) {
        System.out.println(evaluate("3"));
        System.out.println(evaluate("( + 1 2 )"));
        System.out.println(evaluate("( + 3 4 5 )"));
        System.out.println(evaluate("( + 7 ( * 8 12 ) ( * 2 ( + 9 4 ) 7 ) 3 )"));
        System.out.println(evaluate("( + 7 ( * 8 12 ) ( * 2 ( + 9 4 ( * 1 3 ) ( + 1 3 ) ) 7 ) 3 )"));
    }

    private static int evaluate(String exp) {
        String[] expr = exp.split(" ");
        Stack<String> ops = new Stack<>();
        Stack<String> nums = new Stack<>();
        List<Integer> operands;
        for(int i=0; i<expr.length; i++) {
            switch (expr[i]) {
                case ")":
                    operands = new ArrayList<>();
                    String prev = nums.pop();
                    while (!prev.equals("(")) {
                        operands.add(Integer.parseInt(prev));
                        prev = nums.pop();
                    }
                    if(operands.size() == 1) {
                        nums.push(String.valueOf(operands.get(0)));
                        break;
                    }
                    String op = ops.pop();
                    nums.push(evaluate(op, operands));
                    break;
                case "(":
                    nums.push(expr[i]);
                    break;
                case "*":
                case "+":
                    ops.push(expr[i]);
                    break;
                default:
                    nums.push(expr[i]);
            }
        }
        return Integer.parseInt(nums.pop());
    }

    private static String evaluate(String op, List<Integer> operands) {
        BinaryOperator<Integer> sum = (a, b) -> a+b;
        BinaryOperator<Integer> mul = (a, b) -> a*b;

        if(op.equals("*"))
            return operands.stream().reduce(mul).get().toString();
        return operands.stream().reduce(sum).get().toString();
    }
}
