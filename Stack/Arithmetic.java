
public class Arithmetic {

	//Evaluates a String exp that has an arithmetic expression, written in classic notation
	public static int evaluate(String exp) {
		return 0;
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
	}
	
	//Evaluates a String exp that has an arithmetic expression written in STOUT notation
	public static int evaluateStout(String exp) {
		MyStack stack = new MyStack<>();
		for (int i = 0; i < exp.length(); i++) {
			if (exp.charAt(i) >= 48 && exp.charAt(i) <= 57) {
				stack.push(exp.charAt(i)-48);
			}
			else {
				stack.push(operate((int) stack.pop().getValue(), (int) stack.pop().getValue(), exp.substring(i,i+1)));
			}
		}
	}
	
	public static String convertClassicToStout(String exp) {
		return "";
	}
	
	
}
