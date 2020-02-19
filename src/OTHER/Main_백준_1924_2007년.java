package OTHER;

import java.util.Scanner;

public class Main_백준_1924_2007년 {

	public static void main(String[] args) {
		int[] month = new int[12];
		month[0] = 31;
		month[1] = 28;
		month[2] = 31;
		month[3] = 30;
		month[4] = 31;
		month[5] = 30;
		month[6] = 31;
		month[7] = 31;
		month[8] = 30;
		month[9] = 31;
		month[10] = 30;
		month[11] = 31;

		Scanner scan = new Scanner(System.in);

		int x = scan.nextInt();
		int y = scan.nextInt();
		int sum1 = 0;
		int sum2 = 0;
		int day = 0;
		if (1 <= x && x <= 12) {
			for (int i = 0; i < x - 1; i++) {
				sum1 += month[i];
			}
			if (1 <= y && y <= 31) {
				sum2 = sum1 + y;
			} else {
				System.out.println("잘못된 입력");
			}
		} else {
			System.out.println("잘못된 입력");
		}

		day = sum2 % 7;
		switch (day) {
		case 0:
			System.out.println("SUN");
			break;
		case 1:
			System.out.println("MON");
			break;
		case 2:
			System.out.println("TUE");
			break;
		case 3:
			System.out.println("WED");
			break;
		case 4:
			System.out.println("THU");
			break;
		case 5:
			System.out.println("FRI");
			break;
		case 6:
			System.out.println("SAT");
			break;

		}
	}

}
