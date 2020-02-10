package OTHER;

import java.util.Scanner;

public class Main_백준_10952 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		while (!str.equals("0 0")) {
			int A = Integer.parseInt(str.substring(0, 1));
			int B = Integer.parseInt(str.substring(2, 3));
			str = sc.nextLine();
			System.out.println(A + B);
		}
	}

}
