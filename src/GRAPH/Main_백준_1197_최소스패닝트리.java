package GRAPH;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// 프림으로 풀거임
public class Main_백준_1197_최소스패닝트리 {
	static int V, E;
	static List<Info>[] adj;
	static boolean[] visit;

	static class Info implements Comparable<Info> {
		int nowN, nextN, w;

		public Info(int nowN, int nextN, int w) {
			super();
			this.nowN = nowN;
			this.nextN = nextN;
			this.w = w;
		}

		@Override
		public int compareTo(Info o) {
			return Integer.compare(this.w, o.w);
		}
	}

	static void prim() {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(0, 1, 0)); // 출발 지점
		int result = 0; // 만들어진 스패닝 가중치
		int cnt = 0; // 연결된 구간 여러개

		while (!pq.isEmpty()) {
			Info info = pq.poll();

			if (!visit[info.nextN]) {
				visit[info.nextN] = true;
				cnt++;
				result += info.w;
				if (cnt > V - 1) {
					System.out.println(result);
					return;
				}
				for (int i = 0; i < adj[info.nextN].size(); i++) {
					Info newInfo = adj[info.nextN].get(i);
					if (!visit[newInfo.nextN]) {
						pq.add(newInfo);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		visit = new boolean[V + 1];
		adj = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			adj[a].add(new Info(a, b, w));
			adj[b].add(new Info(b, a, w));
		}
		prim();
	}

}
