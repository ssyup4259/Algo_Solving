package SIMULATION;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_17825_주사위윷놀이 {
	static int[] arr = new int[10];
	static int[] point = new int[4]; // 0~3번 말들이 어느 자리에 있는지 위치
	static int[] score = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 13, 16, 19, 25, 22, 24, 22, 24, 26, 28, 30, 28, 27,
			26, 30, 35, 40, 32, 34, 36, 38, 0 }; // 0 출발, 32 도착, 1~31 번 위치의 점수
	static int[][] map = { { 0, 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5, 6 }, { 2, 3, 4, 5, 6, 7 }, { 3, 4, 5, 6, 7, 8 },
			{ 4, 5, 6, 7, 8, 9 }, { 5, 11, 12, 13, 14, 25 }, { 6, 7, 8, 9, 10, 17 }, { 7, 8, 9, 10, 17, 18 },
			{ 8, 9, 10, 17, 18, 19 }, { 9, 10, 17, 18, 19, 20 }, { 10, 15, 16, 14, 25, 26 }, { 11, 12, 13, 14, 25, 26 },
			{ 12, 13, 14, 25, 26, 27 }, { 13, 14, 25, 26, 27, 32 }, { 14, 25, 26, 27, 32, 32 },
			{ 15, 16, 14, 25, 26, 27 }, { 16, 14, 25, 26, 27, 32 }, { 17, 18, 19, 20, 21, 28 },
			{ 18, 19, 20, 21, 28, 29 }, { 19, 20, 21, 28, 29, 30 }, { 20, 21, 28, 29, 30, 31 },
			{ 21, 22, 23, 24, 14, 25 }, { 22, 23, 24, 14, 25, 26 }, { 23, 24, 14, 25, 26, 27 },
			{ 24, 14, 25, 26, 27, 32 }, { 25, 26, 27, 32, 32, 32 }, { 26, 27, 32, 32, 32, 32 },
			{ 27, 32, 32, 32, 32, 32 }, { 28, 29, 30, 31, 27, 32 }, { 29, 30, 31, 27, 32, 32 },
			{ 30, 31, 27, 32, 32, 32 }, { 31, 27, 32, 32, 32, 32 } };

	static int sum = 0;
	static int max = 0;

	// 각 순번에 어느 말을 이동 시킬지 정한다.
	static void makeOrder(int idx) {
		if (idx >= 10) {
			if (max < sum) {
				max = sum;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			int location = point[i]; // 출발지점
			if (location == 32) {
				continue;
			}
			int p = map[location][arr[idx]]; // 도착지점
			boolean flag = true;
			for (int j = 0; j < 4; j++) {
				if (j != i && p != 32 && p == point[j]) { // 도착 지점에 다른 말이 있으면 안된다.
					// System.out.println("출발: " + location + " 도착: " + p);
					// System.out.println(Arrays.toString(point));
					flag = false;
					break;
				}
			}

			if (!flag) {
				continue;
			}
			point[i] = p; // 이동
			sum += score[p]; // 이동하고 나서 점수 추가
			makeOrder(idx + 1);
			sum -= score[p];
			point[i] = location; // 원래 자리로
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}
		makeOrder(0);
		System.out.println(max);
	}

}
