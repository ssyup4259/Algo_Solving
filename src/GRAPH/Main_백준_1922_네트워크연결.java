package GRAPH;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_백준_1922_네트워크연결 {

		static int N, M;
		static PriorityQueue<Info> pq = new PriorityQueue<>();
		static int[] p;

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

		static int findSet(int node) {
			if (p[node] != node) {
				return findSet(p[node]);
			}
			return node;
		}

		static void unionSet(int nodeA, int nodeB) {
			//nodeA = findSet(nodeA);
			//nodeB = findSet(nodeB);

			if (nodeA != nodeB) {
				if (nodeA < nodeB) {
					p[nodeB] = nodeA;
				} else {
					p[nodeA] = nodeB;
				}
			}
		}

		static void krusckal() {
			int cnt = 0;
			int result = 0;
			while (!pq.isEmpty()) {
				Info info = pq.poll();
				
			
				if (findSet(info.nowN) != findSet(info.nextN)) {
					unionSet(findSet(info.nowN), findSet(info.nextN));
					cnt++;
					result += info.w;
				}
				if (cnt == N - 1) {
					System.out.println(result);
					return;
				}
			}
		}

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			M = sc.nextInt();
			p = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				p[i] = i;
			}
			for (int i = 0; i < M; i++) {
				pq.add(new Info(sc.nextInt(), sc.nextInt(), sc.nextInt()));
			}
			krusckal();
		}

	}
