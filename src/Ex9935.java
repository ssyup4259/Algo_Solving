
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex9935 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		char[] str = str1.toCharArray();
		char[] bomb = str2.toCharArray();
		Queue<Integer> que = new LinkedList<>();

		int start = 0;
		while (true) {
			if (que.isEmpty()) {
				start = 0;
			} else {
				if (que.peek() >= bomb.length) {
					start = que.poll() - bomb.length;
				} else {
					start = 0;
				}
			}
			for (int i = start; i < str.length; i++) {
				boolean flag = true;
				if (str[i] == bomb[0]) {
					for (int j = 1; j < bomb.length; j++) {
						if (str[i + j] != bomb[j]) {
							flag = false;
							break;
						}
					}
					if (flag) {
						que.add(i);
						for (int j = 0; j < str.length - i - bomb.length; j++) {
							str[i + j] = str[i + j + bomb.length];
						}
						for (int j = str.length - bomb.length; j < str.length; j++) {
							str[j] = '.';
						}
					}
				}
			}
			if (que.isEmpty()) {
				break;
			}
		}
		int cnt = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] != '.') {
				System.out.print(str[i]);
				cnt++;
			}
		}
		if (cnt == 0) {
			System.out.println("FRULA");
		}

	}

}
