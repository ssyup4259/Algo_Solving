package SAMSUNG;

import java.util.Scanner;

public class Ex14891 {
	static int[][] tob;

	// 회전
	static void rotate(int tobType, int dir) {
		if (dir == 1) { // 시계방향 회전
			int temp = tob[tobType][7];
			for (int i = 7; i > 0; i--) {
				tob[tobType][i] = tob[tobType][i - 1];
			}
			tob[tobType][0] = temp;
		} else { // 반시계
			int temp = tob[tobType][0];
			for (int i = 0; i < 7; i++) {
				tob[tobType][i] = tob[tobType][i + 1];
			}
			tob[tobType][7] = temp;
		}
	}

	// 하나의 톱을 돌리고 극을 비교하면 안된다. 돌리기전에 극들이 같은지 1,2,3,4 다 비교해야한다.
	static void solve(int tobType, int dir) {
		if (tobType == 1) {
			// 1번과 2번 다르면
			if (tob[1][2] != tob[2][6]) {
				// 2번과 3번 다르면
				if (tob[2][2] != tob[3][6]) {
					// 3번과 4번다르면
					if (tob[3][2] != tob[4][6]) {
						rotate(4, -dir);
					}
					rotate(3, dir);
				}
				rotate(2, -dir);
			}
			rotate(1, dir);
		} else if (tobType == 2) {
			// 1번과 2번이 다르면 1번돌린다. 여기서는 1번 먼저 돌려도 3,4번에 영향을 끼치지 않는다.
			if (tob[1][2] != tob[2][6]) {
				rotate(1, -dir);
			}
			// 2번과 3번 다르면
			if (tob[2][2] != tob[3][6]) {
				// 3번과 4번다르면
				if (tob[3][2] != tob[4][6]) {
					rotate(4, dir);
				}
				rotate(3, -dir);
			}
			rotate(2, dir);
		} else if (tobType == 3) {
			if (tob[3][2] != tob[4][6]) {
				rotate(4, -dir);
			}
			if (tob[2][2] != tob[3][6]) {
				if (tob[2][6] != tob[1][2]) {
					rotate(1, dir);
				}
				rotate(2, -dir);
			}
			rotate(3, dir);
		} else {
			if (tob[3][2] != tob[4][6]) {
				if (tob[2][2] != tob[3][6]) {
					if (tob[2][6] != tob[1][2]) {
						rotate(1, -dir);
					}
					rotate(2, dir);
				}
				rotate(3, -dir);
			}
			rotate(4, dir);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tob = new int[5][8];

		// 1번 톱의 정보는 tob의 1 행에 저장
		for (int i = 1; i <= 4; i++) {
			String str = sc.nextLine();
			int flag = Integer.parseInt(str);
			for (int j = 7; j >= 0; j--) {
				tob[i][j] = flag % 10;
				flag = flag / 10;
			}
		}

		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int tobType = sc.nextInt();
			int dir = sc.nextInt();
			solve(tobType, dir);
		}

		int sum = 0;
		if (tob[1][0] == 1) {
			sum += 1;
		}
		if (tob[2][0] == 1) {
			sum += 2;
		}
		if (tob[3][0] == 1) {
			sum += 4;
		}
		if (tob[4][0] == 1) {
			sum += 8;
		}
		System.out.println(sum);
	}

}
