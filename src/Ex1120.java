import java.util.Arrays;
import java.util.Scanner;

public class Ex1120 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		char[] A = new char[str2.length()];
		char[] B = new char[str2.length()];

		// A�� �迭�� B�迭�� ũ�⸸ŭ ���� �س��� ���� �ڸ��� 0���� ä���
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

		// B�迭�� ���̿� A�迭�� ������ ���̸�ŭ �����Ѵ�.
		for (int i = 0; i <= len; i++) {
			int cnt = 0;
			// A�迭�� 0�ΰ����� ��� ���ĺ����ε� ä��� �����ϱ� A��B�� ���̰� ����
			for (int j = 0; j < str2.length(); j++) {
				if (A[j] != '0' && A[j] != B[j]) {
					cnt++;
				}
			}
			// �ּҰ� ����
			if (cnt < min) {
				min = cnt;
			}
			// A�迭�� ��ĭ�� ���������� �δ�
			char temp = A[str2.length() - 1];
			for (int j = str2.length() - 1; j > 0; j--) {
				A[j] = A[j - 1];
			}
			A[0] = temp;
		}
		System.out.println(min);
	}

}
