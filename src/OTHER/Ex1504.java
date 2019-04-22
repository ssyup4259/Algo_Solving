package OTHER;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Ex1504 {
	static int N, E;
	static int[][] map;
	// 다익스트라 입력
	static int[] dist;
	static final int MAX = Integer.MAX_VALUE;

	static class Info implements Comparable<Info> {
		int start, w;

		Info(int start, int w) {
			this.start = start;
			this.w = w;
		}

		@Override
		public int compareTo(Info o) {
			if (this.w < o.w) {
				return -1;
			}
			return 1;
		}
	}

	static int solve(int start, int end) {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(start, 0));
		dist[start] = 0;

		// 출발지점을 제외하고 전체 제일큰수로
		for (int i = 1; i <= N; i++) {
			if (start == i) {
				continue;
			}
			dist[i] = MAX;
		}

		while (!pq.isEmpty()) {
			int st = pq.peek().start;
			int w = pq.poll().w;

			// st에서 i로 가는 길이 있다면 dist[i] 와 st에서 i로 가는 가중치 비교해서 작은 값으로 갱신
			for (int i = 1; i <= N; i++) {
				if (map[st][i] != 0) {
					if (dist[i] > dist[st] + map[st][i]) {
						dist[i] = dist[st] + map[st][i];
						pq.add(new Info(i, dist[i]));
					}
				}
			}
		}
		return dist[end];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		E = sc.nextInt();
		map = new int[N + 1][N + 1];
		dist = new int[N + 1];
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			// 다익스트라는 양방향 a에서 b로 b 에서 a 로
			map[a][b] = c;
			map[b][a] = c;
		}
		int node1 = sc.nextInt();
		int node2 = sc.nextInt();

		// 1->node1->node2->N 으로 가는법
		int result1 = MAX;
		int temp0 = solve(1, node1);
		if (temp0 < MAX) {
			int temp2 = solve(node1, node2);
			if (temp2 < MAX) {
				int temp3 = solve(node2, N);
				if (temp3 < MAX) {
					result1 = temp0 + temp2 + temp3;
				}
			}
		}

		// 1->node2->node1->N 으로 가는법
		int result2 = MAX;
		int temp1 = solve(1, node2);
		if (temp1 < MAX) {
			int temp2 = solve(node2, node1);
			if (temp2 < MAX) {
				int temp3 = solve(node1, N);
				if (temp3 < MAX) {
					result2 = temp1 + temp2 + temp3;
				}
			}
		}

		// 둘다 MAX라면 가는 경로가 없다는 뜻
		if (result1 == MAX && result2 == MAX) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(result1, result2));
		}
	}

}
