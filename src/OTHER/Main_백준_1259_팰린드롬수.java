package OTHER;

import java.util.Scanner;

public class Main_백준_1259_팰린드롬수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int num = sc.nextInt();
			if (num == 0) {
				break;
			}
			String str = Integer.toString(num);
			boolean flag = true;
			for (int i = 0; i < str.length() / 2; i++) {
				if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
					System.out.println("no");
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println("yes");
			}
		}
	}

}
