package SIMULATION;
import java.util.Scanner;

public class Ex8911 {
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int[][] map = new int[1000][1000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.nextLine();
			int d = 0; // 처음 북쪽
			int w = 0;
			int h = 0;
			//(0,0)에서 시작
			int minW = 0;
			int minH = 0;
			int maxW = 0;
			int maxH = 0;
			for (int i = 0; i < str.length(); i++) {
				char idx = str.charAt(i);
				if (idx == 'F') {
					h += dir[d][0];
					w += dir[d][1];
				} else if (idx == 'B') {
					h -= dir[d][0];
					w -= dir[d][1];
				} else if (idx == 'L') {
					d = (d + 3) % 4;
				} else if (idx == 'R') {
					d = (d + 1) % 4;
				}

				if (minH > h) {
					minH = h;
				}
				if (minW > w) {
					minW = w;
				}
				if (maxH < h) {
					maxH = h;
				}
				if (maxW < w) {
					maxW = w;
				}
			}
			System.out.println((maxH - minH) * (maxW - minW));
		}

	}

}
