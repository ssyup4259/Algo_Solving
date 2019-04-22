package OTHER;

import java.util.Scanner;
import java.util.Stack;

public class Ex3986 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		Stack<Character> st = new Stack<>();
		int cnt = 0; // ���� �ܾ� ����
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < str.length(); j++) {
				// ������ ������� �ʰ� ������ ���� ���� ���� ���� ���ٸ�
				if (!st.isEmpty() && st.peek() == str.charAt(j)) {
					st.pop(); // ���ÿ��� ����
				} else {
					st.push(str.charAt(j));
				}
			}

			if (st.isEmpty()) {
				cnt++;
			} else { // ������ ������� �ʴٸ� �ʱ�ȭ
				st.clear();
			}
		}
		System.out.println(cnt);

	}

}
