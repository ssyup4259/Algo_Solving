package SIMULATION;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_19235_모노미노도미노 {
	static int[][] map = new int[10][10];
	static int score = 0;

	static void delete_two() {
		int cnt = 0;
		boolean check_right = false;
		for (int r = 0; r < 4; r++) {
			if (map[r][4] == 1) {
				cnt++;
				check_right = true;
				break;
			}
		}
		for (int r = 0; r < 4; r++) {
			if (map[r][5] == 1) {
				cnt++;
				check_right = true;
				break;
			}
		}
		// cnt 갯수만큼 줄 삭제, cnt 갯수만큼 땡겨오면 삭제된것
		for (int r = 0; r < 4; r++) {
			for (int c = 9; c >= 4; c--) {
				map[r][c] = map[r][c - cnt];
			}
		}

		cnt = 0;
		boolean check_down = false;
		for (int c = 0; c < 4; c++) {
			if (map[4][c] == 1) {
				cnt++;
				check_down = true;
				break;
			}
		}
		for (int c = 0; c < 4; c++) {
			if (map[5][c] == 1) {
				cnt++;
				check_down = true;
				break;
			}
		}
		for (int i = 0; i < cnt; i++) {
			for (int c = 0; c < 4; c++) {
				map[9 - i][c] = 0;
			}
		}
		for (int c = 0; c < 4; c++) {
			for (int r = 9; r >= 4; r--) {
				map[r][c] = map[r - cnt][c];
			}
		}
	}

	static void delete_block() {
		while (true) {
			boolean flag = false;
			for (int i = 6; i < 10; i++) {
				int sum_right = 0;
				int sum_down = 0;
				for (int j = 0; j < 4; j++) {
					sum_right += map[j][i];
					sum_down += map[i][j];
				}
				// 4칸 다 블록을로 가득 찼다면
				if (sum_right == 4) {
					flag = true;
					score++;
					for (int j = 0; j < 4; j++) {
						map[j][i] = 0;
					}
					for (int j = 0; j < 4; j++) {
						int cnt = 0;
						for (int k = 9; k >= 4; k--) {
							if (map[j][k] == 0) {
								cnt++;
							} else {
								map[j][k] = 0;
								map[j][k + cnt] = 1;
							}
						}
					}
				}

				if (sum_down == 4) {
					flag = true;
					score++;
					for (int j = 0; j < 4; j++) {
						map[i][j] = 0;
					}
					for (int j = 0; j < 4; j++) {
						int cnt = 0;
						for (int k = 9; k >= 4; k--) {
							if (map[k][j] == 0) {
								cnt++;
							} else {
								map[k][j] = 0;
								map[k + cnt][j] = 1;
							}
						}
					}
				}
			}
			if (!flag) {
				break;
			}
		}
	}

	static void move_block(int t, int r, int c) {
		if (t == 1) { // 1*1짜리 블록
			boolean flag_right = false;
			boolean flag_down = false;
			for (int i = 0; i < 10; i++) {
				if (map[r][i] == 1) {
					flag_right = true;
					map[r][i - 1] = 1;
				}
				if (map[i][c] == 1) {
					flag_down = true;
					map[i - 1][c] = 1;
				}
			}
			if (!flag_right) {
				map[r][9] = 1;
			}
			if (!flag_down) {
				map[9][c] = 1;
			}
		} else if (t == 2) { // 가로로 긴거
			boolean flag_right = false;
			for (int i = 0; i < 10; i++) {
				if (map[r][i] == 1) {
					flag_right = true;
					map[r][i - 1] = 1;
					map[r][i - 2] = 1;
					break;
				}
			}
			if (!flag_right) {
				map[r][8] = 1;
				map[r][9] = 1;
			}
			int min = 9;
			for (int i = 9; i >= 0; i--) {
				if (map[i][c] == 1) {
					if (min > i - 1) {
						min = i - 1;
					}
				}
				if (map[i][c + 1] == 1) {
					if (min > i - 1) {
						min = i - 1;
					}
				}
			}
			map[min][c] = 1;
			map[min][c + 1] = 1;
		} else { // 세로로 긴거
			boolean flag_down = false;
			for (int i = 0; i < 10; i++) {
				if (map[i][c] == 1) {
					flag_down = true;
					map[i - 1][c] = 1;
					map[i - 2][c] = 1;
					break;
				}
			}
			if (!flag_down) {
				map[8][c] = 1;
				map[9][c] = 1;
			}
			int min = 9;
			for (int i = 9; i >= 0; i--) {
				if (map[r][i] == 1) {
					if (min > i - 1) {
						min = i - 1;
					}
				}
				if (map[r + 1][i] == 1) {
					if (min > i - 1) {
						min = i - 1;
					}
				}
			}
			map[r][min] = 1;
			map[r + 1][min] = 1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int t = sc.nextInt();
			int x = sc.nextInt(); // 행
			int y = sc.nextInt(); // 열
			move_block(t, x, y);
			delete_block();
			delete_two();
		}
		int cnt = 0;
		for (int i = 0; i < 10; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(score);
		System.out.println(cnt);
	}

}
