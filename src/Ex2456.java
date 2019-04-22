import java.util.Scanner;

public class Ex2456 {
	static class Info {
		int a, b, sum;

		Info(int a, int b, int sum) {
			this.a = a;
			this.b = b;
			this.sum = sum;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][3];
		int[][] board = new int[3][3];
		int aSum = 0;
		int bSum = 0;
		int cSum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 3) {
					board[0][j]++;
				} else if (map[i][j] == 2) {
					board[1][j]++;
				}
				if (j == 0) {
					aSum += map[i][j];
				} else if (j == 1) {
					bSum += map[i][j];
				} else {
					cSum += map[i][j];
				}
			}
		}
		board[2][0] = aSum;
		board[2][1] = bSum;
		board[2][2] = cSum;
		Info a = new Info(board[0][0], board[1][0], board[2][0]);
		Info b = new Info(board[0][1], board[1][1], board[2][1]);
		Info c = new Info(board[0][2], board[1][2], board[2][2]);
		

		int max = Math.max(aSum, Math.max(bSum, cSum));
		int cnt = 0;
		int flag = -1;
		for (int i = 0; i < 3; i++) {
			if (board[2][i] == max) {
				cnt++;
				flag = i;
			}
		}

		if (cnt == 1) {
			System.out.println((flag + 1) + " " + board[2][flag]);
		} else {
			
		}
	}

}
