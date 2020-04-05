package OTHER;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_7662_이중우선순위큐 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int k = sc.nextInt();
			PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o2, o1);
				}
			});
			for (int i = 0; i < k; i++) {
				String d = sc.next();
				int n = sc.nextInt();
				if (d.equals("I")) {
					pq.add(n);
				} else if (d.equals("D")) {
					if (n == 1) {
						pq.poll();
					} else {
						Queue<Integer> que = new LinkedList<>();
						while (pq.size() > 1) {
							int a = pq.poll();
							que.add(a);
						}
						pq.poll();
						while (!que.isEmpty()) {
							pq.add(que.poll());
						}
					}
				}
			}
			if (pq.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.print(pq.poll() + " ");
				if (pq.size() >= 1) {
					while (pq.size() > 1) {
						pq.poll();
					}
				}
				System.out.println(pq.poll());
			}
		}
	}

}
