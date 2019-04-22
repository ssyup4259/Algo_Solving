import java.util.Scanner;

public class Ex15953 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] arrA = { {}, { 500, 1 }, { 300, 3 }, { 200, 6 }, { 50, 10 }, { 30, 15 }, { 10, 21 } };
		int[][] arrB = { {}, { 512, 1 }, { 256, 3 }, { 128, 7 }, { 64, 15 }, { 32, 31 } };
		for (int tc = 1; tc <= T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int sum = 0;
			if (a == 1) {
				sum += 500;
			} else {
				for (int i = 1; i < 6; i++) {
					if (arrA[i][1] < a && arrA[i + 1][1] >= a) {
						sum += arrA[i + 1][0];
					}
				}
			}
			if (b == 1) {
				sum += 512;
			} else {
				for (int i = 1; i < 5; i++) {
					if (arrB[i][1] < b && arrB[i + 1][1] >= b) {
						sum += arrB[i + 1][0];
					}
				}
			}
			sum *= 10000;
			System.out.println(sum);
		}

	}

}
