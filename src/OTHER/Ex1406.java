package OTHER;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Ex1406 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Character> stL = new Stack<>(); // 커서기준 왼쪽에 잇는애들
		Stack<Character> stR = new Stack<>(); // 커서기준 오른쪽에 있는애들

		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			stL.push(str.charAt(i));
		}

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String a = br.readLine();
			String[] arr = a.split(" ");
			// 커서를 왼족으로 한칸 옮기니깐 왼쪽 스택에서 오른쪽 스택으로 하나 보넴
			// 왼쪽스택 제일 위와 오른쪽스택 제일 위 사이가 커서가 존재하는 위치
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
