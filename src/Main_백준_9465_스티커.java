import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_9465_스티커 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] arr = new int[2][n];
			int[][] memo = new int[2][n];

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			memo[0][0] = arr[0][0];
			memo[1][0] = arr[1][0];
			memo[0][1] = memo[1][0] + arr[0][1];
			memo[1][1] = memo[0][0] + arr[1][1];
			int result = 0;
			for (int i = 2; i < n; i++) {
				for (int r = 0; r < 2; r++) {
					int a = memo[(r + 1) % 2][i - 2];
					int b = memo[(r + 1) % 2][i - 1];
					int max = Math.max(a, b);
					memo[r][i] = max + arr[r][i];
					if (result < memo[r][i]) {
						result = memo[r][i];
					}
				}
			}
			System.out.println(result);
		}
	}

}
