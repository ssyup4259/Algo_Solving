package SIMULATION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_백준_2174_로봇시뮬레이션 {
	static final int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int A, B, N, M, map[][];
	static List<Info> robotList = new ArrayList<>();
	static String result;

	static class Info {
		int r, c, d;

		public Info(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Info [r=" + r + ", c=" + c + ", d=" + d + "]";
		}

	}

	static boolean isRange(int r, int c) {
		if (r < 1 || r > B || c < 1 || c > A) {
			return false;
		}
		return true;
	}

	static void solve(int num, String order, int cnt) {
		Info robot = robotList.get(num);
		for (int i = 0; i < cnt; i++) {
			if (order.equals("L")) {
				robot.d = ((robot.d + 4) - 1) % 4;
			} else if (order.equals("R")) {
				robot.d = (robot.d + 1) % 4;
			} else {
				map[robot.r][robot.c] = 0;
				robot.r = robot.r + dir[robot.d][0];
				robot.c = robot.c + dir[robot.d][1];
				if (!isRange(robot.r, robot.c)) {
					result = "Robot " + num + " crashes into the wall";
					return;
				}
				if (map[robot.r][robot.c] != 0) {
					result = "Robot " + num + " crashes into robot " + map[robot.r][robot.c];
					return;
				}
				map[robot.r][robot.c] = num;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[B + 1][A + 1];
		robotList.add(null);
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			y = (B + 1) - y;
			String d = sc.next();
			int dd = -1;
			if (d.equals("E")) {
				dd = 0;
			} else if (d.equals("S")) {
				dd = 1;
			} else if (d.equals("W")) {
				dd = 2;
			} else {
				dd = 3;
			}
			map[y][x] = i + 1;
			robotList.add(new Info(y, x, dd));
		}

		result = "OK";
		for (int j = 0; j < M; j++) {
			int num = sc.nextInt();
			String order = sc.next();
			int cnt = sc.nextInt();
			solve(num, order, cnt);
			if (!result.equals("OK")) {
				break;
			}
		}
		System.out.println(result);
	}

}
