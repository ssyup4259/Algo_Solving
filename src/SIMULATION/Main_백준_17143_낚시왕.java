package SIMULATION;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_백준_17143_낚시왕 {
	static final int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int R, C, M;
	static List<Info> sharkList = new ArrayList<>();
	static PriorityQueue<Info>[][] map;

	// 상어 클래스
	static class Info implements Comparable<Info> {
		int r, c, s, d, z;

		public Info(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public int compareTo(Info o) {
			return Integer.compare(this.z, o.z);
		}
	}

	static boolean isRange(int r, int c) {
		if (r < 1 || r > R || c < 1 || c > C) {
			return false;
		}
		return true;
	}

	static void moveShark() {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				map[i][j] = new PriorityQueue<>();
			}
		}
		for (int i = 0; i < sharkList.size(); i++) {
			Info shark = sharkList.get(i);
			int nextR = shark.r;
			int nextC = shark.c;

			for (int j = 0; j < shark.s; j++) {
				nextR += dir[shark.d][0];
				nextC += dir[shark.d][1];
				if (!isRange(nextR, nextC)) {
					nextR -= dir[shark.d][0] * 2;
					nextC -= dir[shark.d][1] * 2;
					if (shark.d == 0) {
						shark.d = 1;
					} else if (shark.d == 1) {
						shark.d = 0;
					} else if (shark.d == 2) {
						shark.d = 3;
					} else {
						shark.d = 2;
					}
				}
			}
			shark.r = nextR;
			shark.c = nextC;
			map[nextR][nextC].add(shark);
		}

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j].size() > 1) {
					// 지도에서 상어가 2마리 이상이라면 제일 큰 상어가 다 잡아먹는다.
					while (map[i][j].size() > 1) {
						Info shark = map[i][j].poll();
						sharkList.remove(shark);
					}
				}
			}
		}
	}

	static void solve() {
		int result = 0;
		// 사람은 오른쪽으로 한칸씩 이동
		for (int human = 1; human <= C; human++) {
			for (int i = 1; i <= R; i++) {
				if (!map[i][human].isEmpty()) {
					Info shark = map[i][human].poll();
					result += shark.z;
					sharkList.remove(shark);
					break;
				}
			}
			moveShark();
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		M = sc.nextInt();
		map = new PriorityQueue[R + 1][C + 1];

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				map[i][j] = new PriorityQueue<>();
			}
		}

		for (int i = 0; i < M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt() - 1;
			int z = sc.nextInt();
			Info shark = new Info(r, c, s, d, z);
			map[r][c].add(shark);
			sharkList.add(shark);
		}
		solve();
	}

}
