package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_백준_16236_아기상어 {
	static final int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int N, map[][];
	static Info shark;
	static List<Info> fishList = new ArrayList<>();
	static int result;
	static boolean flag;

	static class Info {
		int r, c, size, eat;

		public Info(int r, int c, int size, int eat) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.eat = eat;
		}
	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N) {
			return false;
		}
		return true;
	}

	static void solve() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] == o2[2]) {
					if (o1[0] == o2[0]) {
						return Integer.compare(o1[1], o2[1]);
					}
					return Integer.compare(o1[0], o2[0]);
				}
				return Integer.compare(o1[2], o2[2]);
			}
		});

		boolean[][] visit = new boolean[N][N];
		pq.add(new int[] { shark.r, shark.c, 0 });
		visit[shark.r][shark.c] = true;

		while (!pq.isEmpty()) {
			int[] temp = pq.poll();
			int nowR = temp[0];
			int nowC = temp[1];
			int nowCnt = temp[2];

			if (map[nowR][nowC] != 0 && map[nowR][nowC] < shark.size) {
				result += nowCnt; // 이동 거리 증가
				map[nowR][nowC] = 0; // 먹었으니 맵에서 물고기 지움
				shark.r = nowR; // 상어 위치 조정
				shark.c = nowC;
				shark.eat++; // 상어 먹은갯수 증가
				flag = true;
				if (shark.eat == shark.size) {
					shark.eat = 0;
					shark.size++;
				}

				for (int i = 0; i < fishList.size(); i++) {
					Info fish = fishList.get(i);
					if (fish.r == nowR && fish.c == nowC) {
						fishList.remove(fish);
						break;
					}
				}
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nextR = nowR + dir[d][0];
				int nextC = nowC + dir[d][1];
				if (isRange(nextR, nextC)) {
					if (map[nextR][nextC] <= shark.size && !visit[nextR][nextC]) {
						visit[nextR][nextC] = true;
						pq.add(new int[] { nextR, nextC, nowCnt + 1 });
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					shark = new Info(i, j, 2, 0);
					map[i][j] = 0;
				} else if (map[i][j] >= 1 && map[i][j] <= 6) {
					Info fish = new Info(i, j, map[i][j], 0);
					fishList.add(fish);
				}
			}
		}

		while (true) {
			flag = false;
			for (int i = 0; i < fishList.size(); i++) {
				Info fish = fishList.get(i);
				if (fish.size < shark.size) {
					solve();
					break;
				}
			}
			if (!flag) {
				break;
			}
		}
		System.out.println(result);
	}
}