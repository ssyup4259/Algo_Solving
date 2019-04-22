import java.util.Arrays;
import java.util.Scanner;

public class Ex1120 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		char[] A = new char[str2.length()];
		char[] B = new char[str2.length()];

		// A의 배열을 B배열의 크기만큼 생성 해놓고 남는 자리는 0으로 채운다
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

		// B배열의 길이와 A배열의 길이의 차이만큼 수행한다.
		for (int i = 0; i <= len; i++) {
			int cnt = 0;
			// A배열의 0인공간은 어떠한 알파벳으로도 채울수 있으니깐 A와B의 차이가 없다
			for (int j = 0; j < str2.length(); j++) {
				if (A[j] != '0' && A[j] != B[j]) {
					cnt++;
				}
			}
			// 최소값 갱신
			if (cnt < min) {
				min = cnt;
			}
			// A배열을 한칸씩 오른쪽으로 민다
			char temp = A[str2.length() - 1];
			for (int j = str2.length() - 1; j > 0; j--) {
				A[j] = A[j - 1];
			}
			A[0] = temp;
		}
		System.out.println(min);
	}

}
