package OTHER;

import java.util.Scanner;

public class Ex9205 {

	// a,b 지점사이의 맨헤튼 거리
	static int len(int ar, int ac, int br, int bc) {
		int len = Math.abs(ar - br) + Math.abs(ac - bc);
		return len;
	}

	public static void main(String[] ar) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt(); // 편의점 개수

			int[] c = new int[n + 2]; // c좌표들
			int[] r = new int[n + 2]; // r좌표들
			int[][] map = new int[n + 2][n + 2];

			for (int i = 0; i < n + 2; i++) {
				c[i] = sc.nextInt();
				r[i] = sc.nextInt();
			}

			for (int i = 0; i < n + 2; i++) {
				// 그자리 그대로는 1
				map[i][i] = 1;
				for (int j = i + 1; j < n + 2; j++) {
					// i좌표와 j 좌표 사이의 맨헤튼 거리
					int len = len(r[i], c[i], r[j], c[j]);
					// 20병을 50미터씩 마시니깐 거리가 1000이 넘어가면 안된다.
					// 1번 편의점과 2번 편의점의 거리가 1000이하면 갈수 있다고 표시 한다.
					if (len <= 1000) {
						map[i][j] = 1;
						map[j][i] = 1;
					}

				}
			}

			// 플로이드 와샬
			for (int k = 0; k < n + 2; k++) {
				for (int i = 0; i < n + 2; i++) {
					for (int j = 0; j < n + 2; j++) {
						// EX) 집에서 1번 편의점을 들려 2번 편의점을 갈수 있따면
						// 집에서 2번 편의점을 갈 수있다고 표시한다.
						// 순차적으로 모두 갈 수 있다면 집에서 락페 까지 가는 map이 1이된다.
						if (map[i][k] == 1 && map[k][j] == 1) {
							map[i][j] = 1;
							map[j][i] = 1;
						}
					}
				}
			}

			if (map[0][n + 1] == 1) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
		}
	}
}