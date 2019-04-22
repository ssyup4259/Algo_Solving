package SAMSUNG;

import java.util.Scanner;

public class Ex5373 {

	static char[][][] cube;
	static String[] com;

	public static void turn2(int target, char dir) {
		if (dir == '+') {
			char temp = cube[target][0][0];
			cube[target][0][0] = cube[target][2][0];
			cube[target][2][0] = cube[target][2][2];
			cube[target][2][2] = cube[target][0][2];
			cube[target][0][2] = temp;
			temp = cube[target][0][1];
			cube[target][0][1] = cube[target][1][0];
			cube[target][1][0] = cube[target][2][1];
			cube[target][2][1] = cube[target][1][2];
			cube[target][1][2] = temp;

		} else if (dir == '-') {

			char temp = cube[target][0][0];
			cube[target][0][0] = cube[target][0][2];
			cube[target][0][2] = cube[target][2][2];
			cube[target][2][2] = cube[target][2][0];
			cube[target][2][0] = temp;
			temp = cube[target][0][1];
			cube[target][0][1] = cube[target][1][2];
			cube[target][1][2] = cube[target][2][1];
			cube[target][2][1] = cube[target][1][0];
			cube[target][1][0] = temp;
		}
	} // 해당 면에 대한 회전 수행

	public static void turn(String com) {

		char target = com.charAt(0);
		char dir = com.charAt(1);

		if (dir == '+') {
			if (target == 'U') {//
				turn2(0, dir);

				char temp1 = cube[1][0][0];
				char temp2 = cube[1][0][1];
				char temp3 = cube[1][0][2];

				cube[1][0][0] = cube[2][0][0];
				cube[1][0][1] = cube[2][0][1];
				cube[1][0][2] = cube[2][0][2];

				cube[2][0][0] = cube[3][0][0];
				cube[2][0][1] = cube[3][0][1];
				cube[2][0][2] = cube[3][0][2];

				cube[3][0][0] = cube[4][0][0];
				cube[3][0][1] = cube[4][0][1];
				cube[3][0][2] = cube[4][0][2];

				cube[4][0][0] = temp1;
				cube[4][0][1] = temp2;
				cube[4][0][2] = temp3;
			} else if (target == 'F') {//
				turn2(2, dir);

				char temp1 = cube[0][2][0];
				char temp2 = cube[0][2][1];
				char temp3 = cube[0][2][2];

				cube[0][2][0] = cube[1][2][2];
				cube[0][2][1] = cube[1][1][2];
				cube[0][2][2] = cube[1][0][2];

				cube[1][0][2] = cube[5][0][0];
				cube[1][1][2] = cube[5][0][1];
				cube[1][2][2] = cube[5][0][2];

				cube[5][0][0] = cube[3][2][0];
				cube[5][0][1] = cube[3][1][0];
				cube[5][0][2] = cube[3][0][0];

				cube[3][2][0] = temp3;
				cube[3][1][0] = temp2;
				cube[3][0][0] = temp1;
			} else if (target == 'L') {//
				turn2(1, dir);

				char temp1 = cube[0][0][0];
				char temp2 = cube[0][1][0];
				char temp3 = cube[0][2][0];

				cube[0][0][0] = cube[4][2][2];
				cube[0][1][0] = cube[4][1][2];
				cube[0][2][0] = cube[4][0][2];

				cube[4][2][2] = cube[5][0][0];
				cube[4][1][2] = cube[5][1][0];
				cube[4][0][2] = cube[5][2][0];

				cube[5][0][0] = cube[2][0][0];
				cube[5][1][0] = cube[2][1][0];
				cube[5][2][0] = cube[2][2][0];

				cube[2][0][0] = temp1;
				cube[2][1][0] = temp2;
				cube[2][2][0] = temp3;
			} else if (target == 'R') {//
				turn2(3, dir);

				char temp1 = cube[0][2][2];
				char temp2 = cube[0][1][2];
				char temp3 = cube[0][0][2];

				cube[0][2][2] = cube[2][2][2];
				cube[0][1][2] = cube[2][1][2];
				cube[0][0][2] = cube[2][0][2];

				cube[2][2][2] = cube[5][2][2];
				cube[2][1][2] = cube[5][1][2];
				cube[2][0][2] = cube[5][0][2];

				cube[5][2][2] = cube[4][0][0];
				cube[5][1][2] = cube[4][1][0];
				cube[5][0][2] = cube[4][2][0];

				cube[4][0][0] = temp1;
				cube[4][1][0] = temp2;
				cube[4][2][0] = temp3;
			} else if (target == 'D') {//
				turn2(5, dir);
				char temp1 = cube[2][2][0];
				char temp2 = cube[2][2][1];
				char temp3 = cube[2][2][2];

				cube[2][2][0] = cube[1][2][0];
				cube[2][2][1] = cube[1][2][1];
				cube[2][2][2] = cube[1][2][2];

				cube[1][2][0] = cube[4][2][0];
				cube[1][2][1] = cube[4][2][1];
				cube[1][2][2] = cube[4][2][2];

				cube[4][2][0] = cube[3][2][0];
				cube[4][2][1] = cube[3][2][1];
				cube[4][2][2] = cube[3][2][2];

				cube[3][2][2] = temp3;
				cube[3][2][1] = temp2;
				cube[3][2][0] = temp1;
			} else if (target == 'B') {
				turn2(4, dir);

				char temp1 = cube[0][0][2];
				char temp2 = cube[0][0][1];
				char temp3 = cube[0][0][0];

				cube[0][0][2] = cube[3][2][2];
				cube[0][0][1] = cube[3][1][2];
				cube[0][0][0] = cube[3][0][2];

				cube[3][2][2] = cube[5][2][0];
				cube[3][1][2] = cube[5][2][1];
				cube[3][0][2] = cube[5][2][2];

				cube[5][2][0] = cube[1][0][0];
				cube[5][2][1] = cube[1][1][0];
				cube[5][2][2] = cube[1][2][0];

				cube[1][0][0] = temp1;
				cube[1][1][0] = temp2;
				cube[1][2][0] = temp3;
			}

		} else if (dir == '-') {

			if (target == 'U') {//
				turn2(0, dir);

				char temp1 = cube[1][0][0];
				char temp2 = cube[1][0][1];
				char temp3 = cube[1][0][2];

				cube[1][0][0] = cube[4][0][0];
				cube[1][0][1] = cube[4][0][1];
				cube[1][0][2] = cube[4][0][2];

				cube[4][0][0] = cube[3][0][0];
				cube[4][0][1] = cube[3][0][1];
				cube[4][0][2] = cube[3][0][2];

				cube[3][0][0] = cube[2][0][0];
				cube[3][0][1] = cube[2][0][1];
				cube[3][0][2] = cube[2][0][2];

				cube[2][0][0] = temp1;
				cube[2][0][1] = temp2;
				cube[2][0][2] = temp3;

			} else if (target == 'F') {//
				turn2(2, dir);

				char temp1 = cube[0][2][0];
				char temp2 = cube[0][2][1];
				char temp3 = cube[0][2][2];

				cube[0][2][0] = cube[3][0][0];
				cube[0][2][1] = cube[3][1][0];
				cube[0][2][2] = cube[3][2][0];

				cube[3][2][0] = cube[5][0][0];
				cube[3][1][0] = cube[5][0][1];
				cube[3][0][0] = cube[5][0][2];

				cube[5][0][0] = cube[1][0][2];
				cube[5][0][1] = cube[1][1][2];
				cube[5][0][2] = cube[1][2][2];

				cube[1][0][2] = temp3;
				cube[1][1][2] = temp2;
				cube[1][2][2] = temp1;
			} else if (target == 'L') {//
				turn2(1, dir);

				char temp1 = cube[0][0][0];
				char temp2 = cube[0][1][0];
				char temp3 = cube[0][2][0];

				cube[0][0][0] = cube[2][0][0];
				cube[0][1][0] = cube[2][1][0];
				cube[0][2][0] = cube[2][2][0];

				cube[2][0][0] = cube[5][0][0];
				cube[2][1][0] = cube[5][1][0];
				cube[2][2][0] = cube[5][2][0];

				cube[5][0][0] = cube[4][2][2];
				cube[5][1][0] = cube[4][1][2];
				cube[5][2][0] = cube[4][0][2];

				cube[4][2][2] = temp1;
				cube[4][1][2] = temp2;
				cube[4][0][2] = temp3;
			} else if (target == 'R') {//
				turn2(3, dir);

				char temp1 = cube[0][2][2];
				char temp2 = cube[0][1][2];
				char temp3 = cube[0][0][2];

				cube[0][2][2] = cube[4][0][0];
				cube[0][1][2] = cube[4][1][0];
				cube[0][0][2] = cube[4][2][0];

				cube[4][0][0] = cube[5][2][2];
				cube[4][1][0] = cube[5][1][2];
				cube[4][2][0] = cube[5][0][2];

				cube[5][2][2] = cube[2][2][2];
				cube[5][1][2] = cube[2][1][2];
				cube[5][0][2] = cube[2][0][2];

				cube[2][2][2] = temp1;
				cube[2][1][2] = temp2;
				cube[2][0][2] = temp3;
			} else if (target == 'D') {
				turn2(5, dir);
				char temp1 = cube[2][2][0];
				char temp2 = cube[2][2][1];
				char temp3 = cube[2][2][2];

				cube[2][2][0] = cube[3][2][0];
				cube[2][2][1] = cube[3][2][1];
				cube[2][2][2] = cube[3][2][2];

				cube[3][2][2] = cube[4][2][2];
				cube[3][2][1] = cube[4][2][1];
				cube[3][2][0] = cube[4][2][0];

				cube[4][2][0] = cube[1][2][0];
				cube[4][2][1] = cube[1][2][1];
				cube[4][2][2] = cube[1][2][2];

				cube[1][2][0] = temp1;
				cube[1][2][1] = temp2;
				cube[1][2][2] = temp3;
			} else if (target == 'B') {
				turn2(4, dir);

				char temp1 = cube[0][0][2];
				char temp2 = cube[0][0][1];
				char temp3 = cube[0][0][0];

				cube[0][0][2] = cube[1][0][0];
				cube[0][0][1] = cube[1][1][0];
				cube[0][0][0] = cube[1][2][0];

				cube[1][0][0] = cube[5][2][0];
				cube[1][1][0] = cube[5][2][1];
				cube[1][2][0] = cube[5][2][2];

				cube[5][2][0] = cube[3][2][2];
				cube[5][2][1] = cube[3][1][2];
				cube[5][2][2] = cube[3][0][2];

				cube[3][2][2] = temp1;
				cube[3][1][2] = temp2;
				cube[3][0][2] = temp3;
			}

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		cube = new char[6][6][6];
		char[] color = { 'w', 'g', 'r', 'b', 'o', 'y' };
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			com = new String[N];
			for (int i = 0; i < color.length; i++) {
				for (int j = 0; j < 3; j++) {
					for (int j2 = 0; j2 < 3; j2++) {
						cube[i][j][j2] = color[i];
					}
				}
			} // 큐브 초기화

			for (int i = 0; i < N; i++) {
				com[i] = sc.next();
			}

			for (int i = 0; i < N; i++) {
				turn(com[i]);
			} // 각 명형 수행

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(cube[0][i][j]);
				}
				System.out.println();
			}
		}

	}

}
