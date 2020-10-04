package SIMULATION;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_백준_16235_나무재테크 {
	static final int[][] dir = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
	static int N, M, K, A[][], B[][];
	static PriorityQueue<Info>[][] map;
	static List<Info> fiveList;

	static class Info implements Comparable<Info> {
		int r, c, age, status;

		public Info(int r, int c, int age, int status) {
			this.r = r;
			this.c = c;
			this.age = age;
			this.status = status;
		}

		@Override
		public int compareTo(Info o) {
			return Integer.compare(this.age, o.age);
		}
	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N) {
			return false;
		}
		return true;
	}

	// 봄과 여름
	static void springAndSummer() {
		List<Info> deathList = new ArrayList<>();
		// 5의 배수는 번식을 할 수 있으니 목록을 구성해야 한다.
		fiveList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				List<Info> aliveList = new ArrayList<>();
				while (!map[i][j].isEmpty()) {
					Info info = map[i][j].poll();
					if (info.age <= B[i][j]) {
						B[i][j] -= info.age;
						info.age++;
						aliveList.add(info);
						if (info.age % 5 == 0) {
							fiveList.add(info);
						}
					} else {
						// 양분이 부족하다면 죽은 애들
						deathList.add(info);
					}
				}
				for (Info info : aliveList) {
					map[i][j].add(info);
				}
			}
		}

		for (Info info : deathList) {
			B[info.r][info.c] += (info.age / 2);
		}
	}

	// 가을과 겨울
	static void authumAndWinter() {
		for (Info info : fiveList) {
			for (int d = 0; d < 8; d++) {
				int nextR = info.r + dir[d][0];
				int nextC = info.c + dir[d][1];
				if (isRange(nextR, nextC)) {
					map[nextR][nextC].add(new Info(nextR, nextC, 1, 0));
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				B[i][j] += A[i][j];
			}
		}
	}

	static int solve() {
		for (int i = 0; i < K; i++) {
			springAndSummer();
			authumAndWinter();
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j].size();
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new PriorityQueue[N][N];
		A = new int[N][N];
		B = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = sc.nextInt();
				B[i][j] = 5;
				map[i][j] = new PriorityQueue<>();
			}
		}
		for (int i = 0; i < M; i++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			int age = sc.nextInt();
			map[r][c].add(new Info(r, c, age, 0));
		}
		System.out.println(solve());

	}

}
