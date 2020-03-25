package OTHER;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_10845_큐 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> que = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			if (str.equals("push")) {
				int num = sc.nextInt();
				que.add(num);
			} else if (str.equals("pop")) {
				if (que.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(que.poll());
				}
			} else if (str.equals("size")) {
				System.out.println(que.size());
			} else if (str.equals("front")) {
				if (que.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(que.peek());
				}
			} else if (str.equals("empty")) {
				if (que.size() == 0) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (str.equals("back")) {
				Queue<Integer> newQue = new LinkedList<>();
				if (que.isEmpty()) {
					System.out.println(-1);
				} else {
					while (que.size() > 1) {
						newQue.add(que.poll());
					}
					System.out.println(que.peek());
					newQue.add(que.poll());
					while (!newQue.isEmpty()) {
						que.add(newQue.poll());
					}
				}
			}
		}
	}

}
