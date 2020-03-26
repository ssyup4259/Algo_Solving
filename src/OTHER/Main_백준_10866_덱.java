package OTHER;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_백준_10866_덱 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			if (str.equals("push_back")) {
				int num = sc.nextInt();
				dq.addLast(num);
			} else if (str.equals("push_front")) {
				int num = sc.nextInt();
				dq.addFirst(num);
			} else if (str.equals("pop_front")) {
				System.out.println(dq.isEmpty() ? -1 : dq.pop());
			} else if (str.equals("pop_back")) {
				System.out.println(dq.isEmpty() ? -1 : dq.removeLast());
			} else if (str.equals("size")) {
				System.out.println(dq.size());
			} else if (str.equals("empty")) {
				System.out.println(dq.isEmpty() ? 1 : 0);
			} else if (str.equals("front")) {
				System.out.println(dq.isEmpty() ? -1 : dq.peek());
			} else if (str.equals("back")) {
				System.out.println(dq.isEmpty() ? -1 : dq.peekLast());
			}

		}
	}

}
