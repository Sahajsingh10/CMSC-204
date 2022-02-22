//@author Sahaj Singh
public class Notation {

	public static boolean highPrecedence(char stackOp, char strOp) {
		boolean isHigh = false;

		if (stackOp == '/') {
			isHigh = true;
		} else if (stackOp == '-') {
			isHigh = false;
			if (strOp == '-') {
				isHigh = true;
			}
		} else if ((stackOp == '+' && strOp == '-') || (stackOp == '+' && strOp == '+')) {
			isHigh = true;
		} else if ((stackOp == '+' && strOp == '/') || (stackOp == '+' && strOp == '*')) {
			isHigh = false;
		} else if ((stackOp == '*' && strOp == '+') || (stackOp == '*' && strOp == '-')
				|| (stackOp == '*' && strOp == '*')) {
			isHigh = true;
		} else if (stackOp == '*' && strOp == '/') {
			isHigh = false;
		}

		return isHigh;
	}

	public static String convertInfixToPostfix(String complexInfix) throws QueueOverflowException,
			StackOverflowException, StackUnderflowException, InvalidNotationFormatException {
		MyQueue<Character> Queue = new MyQueue<>(complexInfix.length());
		MyStack<Character> Stack = new MyStack<>(complexInfix.length());

		for (int i = 0; i < complexInfix.length(); i++) {

			if (complexInfix.charAt(i) == ' ') {
				continue;
			}

			if (complexInfix.charAt(i) > '0' && complexInfix.charAt(i) < '9') {
				Queue.enqueue(complexInfix.charAt(i));
			}

			if (complexInfix.charAt(i) == '(') {
				Stack.push(complexInfix.charAt(i));
			}
			if (complexInfix.charAt(i) == '+' || complexInfix.charAt(i) == '-' || complexInfix.charAt(i) == '/'
					|| complexInfix.charAt(i) == '*') {

				while ((!Stack.isEmpty()) && highPrecedence(Stack.top(), complexInfix.charAt(i))) {
					Queue.enqueue(Stack.top());
					Stack.pop();

				}
				Stack.push(complexInfix.charAt(i));

			}
			if (complexInfix.charAt(i) == ')') {
				while (!(Stack.top() == '(') && (Stack.isEmpty() == false)) {
					if (Stack.size() == 1) {
						break;
					}
					Queue.enqueue(Stack.top());
					Stack.pop();
				}
				if (Stack.top() != '(') {
					throw new InvalidNotationFormatException();
				} else {
					Stack.pop();

				}

			}

		}
		while (!Stack.isEmpty()) {
			Queue.enqueue(Stack.top());
			Stack.pop();
		}
		return Queue.toString();
	}

	public static String convertPostfixToInfix(String easyPostfix)
			throws StackOverflowException, StackUnderflowException, InvalidNotationFormatException {

		MyStack<String> Stack = new MyStack<>(easyPostfix.length());

		for (int i = 0; i < easyPostfix.length(); i++) {

			if (easyPostfix.charAt(i) == ' ') {
				continue;
			}

			if ((easyPostfix.charAt(i) > '0' && easyPostfix.charAt(i) < '9')) {
				Stack.push(Character.toString(easyPostfix.charAt(i)));
			}

			if (easyPostfix.charAt(i) == '+' || easyPostfix.charAt(i) == '-' || easyPostfix.charAt(i) == '/'
					|| easyPostfix.charAt(i) == '*') {

				if (Stack.size() < 2) {
					throw new InvalidNotationFormatException();
				} else {
					String second = Stack.top();
					Stack.pop();
					String first = Stack.top();
					Stack.pop();
					String l = "(" + first + easyPostfix.charAt(i) + second + ")";
					Stack.push(l);

				}

			}

		}
		if (Stack.size() > 1) {
			throw new InvalidNotationFormatException();

		}

		String result = Stack.top();
		return result;
	}

	public static double evaluatePostfixExpression(String complexPostfix)
			throws StackOverflowException, StackUnderflowException, InvalidNotationFormatException {

		MyStack<String> Stack = new MyStack<>(complexPostfix.length());
		for (int i = 0; i < complexPostfix.length(); i++) {

			if (complexPostfix.charAt(i) == ' ') {
				continue;

			}

			if ((complexPostfix.charAt(i) > '0' && complexPostfix.charAt(i) < '9') || complexPostfix.charAt(i) == '(') {
				Stack.push(Character.toString(complexPostfix.charAt(i)));
			}
			if (complexPostfix.charAt(i) == '+' || complexPostfix.charAt(i) == '-' || complexPostfix.charAt(i) == '/'
					|| complexPostfix.charAt(i) == '*') {

				if (Stack.size() < 2) {
					throw new InvalidNotationFormatException();
				} else {
					String second = Stack.top();
					Stack.pop();
					String first = Stack.top();
					Stack.pop();
					int l = 0;
					if (complexPostfix.charAt(i) == '+') {
						l = Integer.parseInt(first) + Integer.parseInt(second);
					} else if (complexPostfix.charAt(i) == '-') {
						l = Integer.parseInt(first) - Integer.parseInt(second);
					} else if (complexPostfix.charAt(i) == '*') {
						l = Integer.parseInt(first) * Integer.parseInt(second);
					} else if (complexPostfix.charAt(i) == '/') {
						l = Integer.parseInt(first) / Integer.parseInt(second);
					}

					String New = Integer.toString(l);
					Stack.push(New);

				}
			}

		}

		if (Stack.size() > 1) {
			throw new InvalidNotationFormatException();
		}

		double result = Double.parseDouble(Stack.top());
		return result;

	}
}
