package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_13913_숨바꼭질4 {
	static int N, K;

	static boolean isRange(int r) {
		if (r < 0 || r > 100000) {
			return false;
		}
		return true;
	}

	static void solve() {
		Queue<Integer> que = new LinkedList<>();
		int[] visited = new int[100001];
		int[] path = new int[100001];

		que.add(N);
		visited[N] = 1;
		path[N] = N;

		while (!que.isEmpty()) {
			int now = que.poll();

			if (now == K) {
				System.out.println(visited[now] - 1);
				StringBuilder sb = new StringBuilder();
				sb.append(N);
				// 경로 출력
				while (now != path[now]) {
					// 루트 나올대가지 반복
					now = path[now];
				}
				System.out.println(result);
				return;
			}

			// +1 칸 이동
			int next = now + 1;
			if (isRange(next) && visited[next] == 0) {
				visited[next] = visited[now] + 1;
				path[next] = now;
				que.add(next);
			}

			next = now - 1;
			if (isRange(next) && visited[next] == 0) {
				visited[next] = visited[now] + 1;
				path[next] = now;
				que.add(next);
			}

			next = now * 2;
			if (isRange(next) && visited[next] == 0) {
				visited[next] = visited[now] + 1;
				path[next] = now;
				que.add(next);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		solve();
	}

}
