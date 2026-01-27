import java.util.ArrayList;

public class Arithmetic {

	//Evaluates a String exp that has an arithmetic expression, written in classic notation
	public static int evaluate(String exp) {
		return evaluateStout(convertClassicToStout(exp));
	}
	
	//Returns the result of doing operand1 operation operand2,
	//e.g. operate(5, 2, "-") should return 3
	public static int operate(int operand1, int operand2, String operation) {
		if (operation.equals("/")) {
			return operand1 / operand2;
		} else if (operation.equals("*")) {
			return operand1 * operand2;
		} else if (operation.equals("+")) {
			return operand1 + operand2;
		} else if (operation.equals("-")) {
			return operand1 - operand2;
		} else if (operation.equals("%")) {
			return operand1 % operand2;
		}
		return 0;
	}
	
	//Evaluates a String exp that has an arithmetic expression written in STOUT notation
	public static int evaluateStout(String exp) {
		MyStack stack = new MyStack<>();
		String[] stout = exp.split(" ");
		for (int i = 0; i < stout.length; i++) {
			if (stout[i].charAt(0) >= '0' && stout[i].charAt(0) <= '9') {
				stack.push(Integer.parseInt(stout[i]));
			}
			else {
				int operand2 = (int) stack.pop().getValue();
				int operand1 = (int) stack.pop().getValue();
				stack.push(operate(operand1, operand2, stout[i]));
			}
		}
		return (int) stack.pop().getValue();
	}
	
	// public static String convertClassicToStout(String exp) {
	// 	StringBuilder stout = new StringBuilder();
	// 	MyStack operators = new MyStack<>();
	// 	String[] classic = exp.split(" ");
	// 	for (int i = 0; i < classic.length; i++) {
	// 		if (classic[i].charAt(0) >= '0' && classic[i].charAt(0) <= '9') {
	// 			stout.append(classic[i]);
	// 		}
	// 		else {
	// 			if (classic[i].charAt(0) == ')') {
	// 				while ((char) operators.peek() != '(') {
	// 					stout.append((char) operators.pop().getValue());
	// 				}
	// 				operators.pop();
	// 			}
	// 			else if (operators.empty() || opVal(classic[i].charAt(0)) > opVal((char) operators.peek())) {
	// 				operators.push(classic[i].charAt(0));
	// 			}
	// 			else if (opVal(classic[i].charAt(0)) <= opVal((char) operators.peek())) {
	// 				stout.append((char) operators.pop().getValue());
	// 				operators.push(classic[i].charAt(0));
	// 			}
	// 		}
	// 	}
	// 	while (!operators.empty()) {
	// 		stout.append((char) operators.pop().getValue());
	// 	}
	// 	return stout.toString();
	// }

	public static String convertClassicToStout(String exp) {
		StringBuilder stout = new StringBuilder();
		MyStack operators = new MyStack<>();
		String[] classic = exp.split(" ");

		for (int i = 0; i < classic.length; i++) {
			char curChar = classic[i].charAt(0);
			if (curChar >= '0' && curChar <= '9') {
				stout.append(classic[i]);
				stout.append(" ");
			}
			else if (curChar == '(') {
				operators.push(curChar);
			}
			else if (curChar == ')') {
				while (!operators.empty() && (char) operators.peek() != '(') {
					stout.append((char) operators.pop().getValue());
					stout.append(" ");
				}
				operators.pop();
			}
			else {
				while (!operators.empty() && opVal(curChar) <= opVal((char) operators.peek())) {
					stout.append((char) operators.pop().getValue());
					stout.append(" ");
				}
				operators.push(curChar);
			}
		}
		while (!operators.empty()) {
			stout.append((char) operators.pop().getValue());
			stout.append(" ");
		}
		return stout.substring(0,stout.length()-1).toString();
	}

	private static int opVal(char c) {
		if (c == '+' || c == '-') {
			return 1;
		}
		if (c == '*' || c == '/' || c == '%') {
			return 2;
		}
		return 0;
	}
}
