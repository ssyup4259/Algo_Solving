package SIMULATION;

import java.util.Scanner;

public class Ex1022 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r1 = sc.nextInt();
		int c1 = sc.nextInt();
		int r2 = sc.nextInt();
		int c2 = sc.nextInt();
		int[][] map = new int[50][50]; // r1과 r2, c1과 c2 의 차이 각각 최대 49
		int max = 0;

		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				int r = i - r1;
				int c = j - c1;

				if (i > j) { // 제일 긴 두개의 대각선을 기준으로 왼쪽과 아래쪽
					if (i + j > 0) { // 왼쪽
						map[r][c] = (i * 2 + 1) * (i * 2 + 1) - i + j;
					} else { // 아래쪽
						map[r][c] = (j * 2) * (j * 2) - j + 1 + i;
					}
				} else if (i == j) {
					if (i >= 0) {
						map[r][c] = (i * 2 + 1) * (i * 2 + 1);
					} else {
						map[r][c] = (i * (-2)) * (i * (-2)) + 1;
					}
				} else { // 제일 긴 두개의 대각선을 기준으로 오른쪽과 위쪽
					if (i + j < 0) { // 위쪽
						map[r][c] = (i * 2) * (i * 2) + i - j + 1;
					} else { // 오른쪽
						map[r][c] = (j * 2 - 1) * (j * 2 - 1) + j - i;
					}
				}
				if (map[r][c] > max) { // map에서 가장 큰 수의 자릿수를 알기위해
					max = map[r][c];
				}
			}
		}

		int strLen = Integer.toString(max).length();
		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				int r = i - r1;
				int c = j - c1;
				if (Integer.toString(map[r][c]).length() < strLen) { // 제일 큰 수의 자릿수보다 현재 숫자의 자릿수가 작다면
					for (int k = 0; k < strLen - Integer.toString(map[r][c]).length(); k++)
						System.out.print(" "); // 앞쪽에 공백 추가
				}
				if (j == c2) {
					System.out.println(map[r][c]);
				} else {
					System.out.print(map[r][c] + " ");
				}
			}
		}
	}

}
