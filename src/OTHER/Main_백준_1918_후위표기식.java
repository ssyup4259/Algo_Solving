package OTHER;

import java.util.Scanner;
import java.util.Stack;

public class Main_백준_1918_후위표기식 {
	static int priority(char c) {
		switch (c) {
		case '*':
		case '/':
			return 2;
		case '+':
		case '-':
			return 1;
		case '(':
		case ')':
			return 0;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Stack<Character> st = new Stack<>();

		String res = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int pr = priority(c);

			if (c >= 'A' && c <= 'Z') {
				res += c;
			} else if (c == '*' || c == '+' || c == '/' || c == '-') {
				while (!st.isEmpty() && priority(st.peek()) >= pr) {
					res += st.pop();
				}
				st.add(c);
			} else if (c == '(') {
				st.add(c);
			} else if (c == ')') {
				while (!st.isEmpty() && st.peek() != '(') {
					res += st.pop();
				}
				st.pop();
			}
		}
		
		while(!st.isEmpty()) {
			res += st.pop();
		}
		
		System.out.println(res);
	}

}
