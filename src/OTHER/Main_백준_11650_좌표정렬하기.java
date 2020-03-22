package OTHER;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_백준_11650_좌표정렬하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				}
				return Integer.compare(o1[0], o2[0]);
			}
		});
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			pq.add(new int[] { x, y });
		}

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			System.out.println(now[0] + " " + now[1]);
		}
	}
}
