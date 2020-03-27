package OTHER;

import java.util.Scanner;

public class Main_백준_15829_Hashing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next();
		long result = 0;
		for (int i = 0; i < str.length(); i++) {
			int h = str.charAt(i) - 'a' + 1;
			long num = 1;
			for (int j = 0; j < i; j++) {
				num *= 31;
			}
			result += h * num;
		}
		System.out.println(result);
	}

}
