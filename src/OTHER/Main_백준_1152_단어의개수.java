package OTHER;

import java.util.Scanner;

public class Main_백준_1152_단어의개수 {

	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String[] str1 = str.split(" ");
		int count = 0;

		for (int i = 0; i < str1.length; i++) {
			if (str1[i].equals(""))
				count++;

		}

		System.out.println(str1.length - count);

	}
}
