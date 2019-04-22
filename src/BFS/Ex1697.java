package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex1697 {
	static int N, K;
	static boolean[] visit = new boolean[100001];

	static class Info {
		int r, time;

		Info(int r, int time) {
			this.r = r;
			this.time = time;
		}
	}

	static boolean isRange(int r) {
		if (r < 0 || r > 100000) {
			return false;
		}
		return true;
	}

	static void bfs() {
		Queue<Info> que = new LinkedList<>();
		que.add(new Info(N, 0));
		visit[N] = true;

		while (!que.isEmpty()) {
			int now = que.peek().r;
			int time = que.poll().time;

			if (now == K) {
				System.out.println(time);
				return;
			}

			// 3방향으로 bfs
			int next = now - 1;
			if (isRange(next) && !visit[next]) {
				que.add(new Info(next, time + 1));
				visit[next] = true;
			}

			next = now + 1;
			if (isRange(next) && !visit[next]) {
				que.add(new Info(next, time + 1));
				visit[next] = true;
			}

			next = now * 2;
			if (isRange(next) && !visit[next]) {
				que.add(new Info(next, time + 1));
				visit[next] = true;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		bfs();
	}

}
