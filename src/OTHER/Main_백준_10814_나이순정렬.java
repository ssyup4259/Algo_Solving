package OTHER;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_백준_10814_나이순정렬 {
	static class Info implements Comparable<Info> {
		int age;
		String name;
		int order;

		public Info(int age, String name, int order) {
			super();
			this.age = age;
			this.name = name;
			this.order = order;
		}

		@Override
		public int compareTo(Info o) {
			if (this.age == o.age) {
				return Integer.compare(this.order, o.order);
			}
			return Integer.compare(this.age, o.age);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Info> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int age = sc.nextInt();
			String name = sc.next();
			pq.add(new Info(age, name, i));
		}

		while (!pq.isEmpty()) {
			Info now = pq.poll();
			System.out.println(now.age + " " + now.name);
		}
	}

}
