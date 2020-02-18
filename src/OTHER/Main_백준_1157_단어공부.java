package OTHER;

import java.util.Scanner;

public class Main_백준_1157_단어공부 {

	static char[] arr = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
			'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	static int[] check = new int[26];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		for (int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			int b = a;
			if (b > 90) {
				b = b - 32;
			}
			b = b - 65;
			check[b]++;
		}
		int max = 0;
		int flag = 0;
		for (int i = 0; i < 26; i++) {
			if (max < check[i]) {
				max = check[i];
				flag = i;
			}
		}
		char result = '0';
		for (int i = 0; i < 26; i++) {
			if (i != flag) {
				if (max == check[i])
					result = '?';
			}
		}
		if (result != '?')
			result = arr[flag];
		System.out.println(result);

	}

}
