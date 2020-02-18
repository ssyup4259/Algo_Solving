package OTHER;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Main_백준_1406_에디터 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Character> stL = new Stack<>(); // Ŀ������ ���ʿ� �մ¾ֵ�
		Stack<Character> stR = new Stack<>(); // Ŀ������ �����ʿ� �ִ¾ֵ�

		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			stL.push(str.charAt(i));
		}

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String a = br.readLine();
			String[] arr = a.split(" ");
			// Ŀ���� �������� ��ĭ �ű�ϱ� ���� ���ÿ��� ������ �������� �ϳ� ����
			// ���ʽ��� ���� ���� �����ʽ��� ���� �� ���̰� Ŀ���� �����ϴ� ��ġ
			if (arr[0].equals("L")) {
				if (!stL.isEmpty()) {
					stR.push(stL.pop());
				}
			} else if (arr[0].equals("D")) {
				if (!stR.isEmpty()) {
					stL.push(stR.pop());
				}
			} else if (arr[0].equals("B")) {
				if (!stL.isEmpty()) {
					stL.pop();
				}
			} else if (arr[0].equals("P")) {
				stL.push(arr[1].charAt(0));
			}
		}

		while (!stL.isEmpty()) {
			stR.push(stL.pop());
		}

		while (!stR.isEmpty()) {
			System.out.print(stR.pop());
		}
	}

}
