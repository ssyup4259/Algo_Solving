package OTHER;

import java.util.Scanner;
import java.util.Stack;

public class Ex3986 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		Stack<Character> st = new Stack<>();
		int cnt = 0; // 좋은 단어 갯수
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < str.length(); j++) {
				// 스택이 비어있지 않고 스택의 이전 수와 현재 수가 같다면
				if (!st.isEmpty() && st.peek() == str.charAt(j)) {
					st.pop(); // 스택에서 뺀다
				} else {
					st.push(str.charAt(j));
				}
			}

			if (st.isEmpty()) {
				cnt++;
			} else { // 스택이 비어있지 않다면 초기화
				st.clear();
			}
		}
		System.out.println(cnt);

	}

}
