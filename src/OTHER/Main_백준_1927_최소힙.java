package OTHER;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_백준_1927_최소힙 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		});
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num == 0) {
				if (pq.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(pq.poll());
				}
			} else {
				pq.add(num);
			}
		}
	}

}
