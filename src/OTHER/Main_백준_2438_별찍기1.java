package OTHER;

import java.util.Scanner;

public class Main_백준_2438_별찍기1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		String result = "";
		for (int i = 0; i < N; i++) {
			result += "*";
			System.out.println(result);
		}

	}

}
