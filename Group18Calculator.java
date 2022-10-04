import java.util.Scanner;
import java.util.Stack;

class Group18Calculator {
    public static void main(String[] args) {
        System.out.println("Enter your equation here:");
    	Scanner in = new Scanner( System.in );
    	String myString = null;
    	if(in.hasNext()) {
			myString = in.next();
			myString = "(" + myString + ")";
		}
        String[] strArr = myString.split("");

        System.out.println(calculator(strArr));
		in.close();
    }
    
    //PROBLEMS THUS FAR:
    //	only works with brackets around the equation - hence the inclusion of line 11
    //	only works with single digits - "6+4" works yet "23+14" does not (it calculates 1+4)
    //	really needs brackets around separate equations - for example "3+3+3" is 6, but "(3+3)+3" is 9


    public static double calculator(String[] strArr) {
        Stack<String> operators = new Stack<String>();
        Stack<Double> operands = new Stack<Double>();

        for(String str : strArr) {
            if (str.trim().equals("")) {
                continue;
            }

            switch(str) {
                case "(":
                    break;
                case ")":
                    double right = operands.pop();
                    double left = operands.pop();
                    String operator = operators.pop();
                    double value = 0;
                    switch(operator) {
                        case "+":
                            value = left + right;
                            break;
                        case "-":
                            value = left - right;
                            break;
                        case "*":
                            value = left * right;
                            break;
                        case "/":
                            value = left / right;
                            break;
                        default:
                            break;
                        }
                        operands.push(value);
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    operators.push(str);
                    break;
                default:
                    operands.push(Double.parseDouble(str));
                    break;
            }
        }

        return operands.pop();
    }
}
