import java.util.Scanner;

public class Ex6731 {
	static int N;
	static char[][] map;
	static int[][] board;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new char[N][N];
			sc.nextLine();
			for (int i = 0; i < N; i++) {
				String str = sc.nextLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			int cnt = 0;
			for (int r = 0; r < N; r++)
				if(map[r][])
			}
		}
	}

}
