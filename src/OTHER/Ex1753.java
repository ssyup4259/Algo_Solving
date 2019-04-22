package OTHER;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ex1753 {
	static int V, E;
	static List<Info>[] adj;
	static int[] dist;
	static PriorityQueue<Info> pq = new PriorityQueue<>();

	static class Info implements Comparable<Info> {
		int node, w;

		Info(int node, int w) {
			this.node = node;
			this.w = w;
		}

		@Override
		public int compareTo(Info o) {
			if (this.w > o.w) {
				return 1;
			}
			return -1;
		}

	}

	static void dijkstra() {
		while (!pq.isEmpty()) {
			int nowN = pq.peek().node;
			int nowW = pq.poll().w;

			// 인접한 행렬 탐색
			for (int i = 0; i < adj[nowN].size(); i++) {
				int nextW = adj[nowN].get(i).w;
				int nextN = adj[nowN].get(i).node;

				// 가중치의 합이 원래 적힌 숫자 보다 작다면 갱신하고 우선순위큐에 삽입
				if (nowW + nextW < dist[nextN]) {
					dist[nextN] = nowW + nextW;
					pq.add(new Info(nextN, nowW + nextW));
				}
			}

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		int start = sc.nextInt();

		// n번 노드의 가중치 입력용
		dist = new int[V + 1];

		// 시작점 입력
		pq.add(new Info(start, 0));

		// 각 노드의 인접행렬 저장용 리스트 배열
		adj = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			adj[u].add(new Info(v, w));
		}

		// 무한대 설정이지만 여기서는 최대값으로
		for (int i = 2; i <= V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		dijkstra();

		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}

}
