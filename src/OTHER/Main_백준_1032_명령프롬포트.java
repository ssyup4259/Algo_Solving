package OTHER;

import java.util.Scanner;

public class Main_백준_1032_명령프롬포트 {
	static char[] solve(char[] arr1, char[] arr2) {
		char[] arr3 = new char[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] == arr2[i]) {
				arr3[i] = arr1[i];
			} else {
				arr3[i] = '?';
			}
		}
		return arr3;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next();
		char[] arr1 = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arr1[i] = str.charAt(i);
		}
		for (int i = 0; i < N - 1; i++) {
			char[] arr2 = new char[str.length()];
			String check = sc.next();
			for (int j = 0; j < str.length(); j++) {
				arr2[j] = check.charAt(j);
			}
			arr1 = solve(arr1, arr2);
		}
		String result = "";
		for (int i = 0; i < arr1.length; i++) {
			result += arr1[i];
		}
		System.out.println(result);

	}

}
