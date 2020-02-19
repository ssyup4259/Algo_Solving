package GRAPH;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_백준_1753_최단경로 {
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

			for (int i = 0; i < adj[nowN].size(); i++) {
				int nextW = adj[nowN].get(i).w;
				int nextN = adj[nowN].get(i).node;

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

		dist = new int[V + 1];

		pq.add(new Info(start, 0));

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
