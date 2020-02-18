package SIMULATION;
import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_1120_문자열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		char[] A = new char[str2.length()];
		char[] B = new char[str2.length()];

		for (int i = 0; i < str2.length(); i++) {
			if (i >= str1.length()) {
				A[i] = '0';
			} else {
				A[i] = str1.charAt(i);
			}
		}
		for (int i = 0; i < str2.length(); i++) {
			B[i] = str2.charAt(i);
		}

		int len = str2.length() - str1.length();
		int min = Integer.MAX_VALUE;

		for (int i = 0; i <= len; i++) {
			int cnt = 0;
			for (int j = 0; j < str2.length(); j++) {
				if (A[j] != '0' && A[j] != B[j]) {
					cnt++;
				}
			}
			if (cnt < min) {
				min = cnt;
			}
			char temp = A[str2.length() - 1];
			for (int j = str2.length() - 1; j > 0; j--) {
				A[j] = A[j - 1];
			}
			A[0] = temp;
		}
		System.out.println(min);
	}

}
