import java.util.Scanner;

public class Main_백준_3019_테트리스 {
	static int C, P;
	static int[] arr;

	static int solve1() {
		int sum = 0;
		sum += C;
		int cnt = 1;
		int flag = arr[0];
		for (int i = 1; i < C; i++) {
			if (arr[i] == flag) {
				cnt++;
			} else {
				cnt = 1;
				flag = arr[i];
			}
			if (cnt >= 4) {
				sum++;
			}
		}
		return sum;
	}

	static int solve2() {
		int sum = 0;
		int cnt = 1;
		int flag = arr[0];
		for (int i = 1; i < C; i++) {
			if (arr[i] == flag) {
				cnt++;
			} else {
				cnt = 1;
				flag = arr[i];
			}
			if (cnt >= 2) {
				sum++;
			}
		}
		return sum;
	}

	static int solve3() {
		int sum = 0;
		for (int i = 2; i < C; i++) {
			boolean flag = true;
			for (int j = 1; j <= 2; j++) {
				if (arr[i] - arr[i - j] != 1) {
					flag = false;
				}
			}
			if (flag) {
				sum++;
			}
		}
		for (int i = 0; i < C - 1; i++) {
			if (arr[i] - arr[i + 1] == 1) {
				sum++;
			}
		}
		return sum;
	}

	static int solve4() {
		int sum = 0;
		for (int i = 0; i < C - 2; i++) {
			boolean flag = true;
			for (int j = 1; j <= 2; j++) {
				if (arr[i] - arr[i + j] != 1) {
					flag = false;
				}
			}
			if (flag) {
				sum++;
			}
		}
		for (int i = 0; i < C - 1; i++) {
			if (arr[i + 1] - arr[i] == 1) {
				sum++;
			}
		}
		return sum;
	}

	static int solve5() {
		int sum = 0;
		int cnt = 1;
		int flag = arr[0];
		for (int i = 1; i < C; i++) {
			if (arr[i] == flag) {
				cnt++;
			} else {
				cnt = 1;
				flag = arr[i];
			}
			if (cnt >= 3) {
				sum++;
			}
		}
		for (int i = 0; i < C - 1; i++) {
			if (arr[i + 1] - arr[i] == 1) {
				sum++;
			}
		}
		for (int i = 0; i < C - 1; i++) {
			if (arr[i] - arr[i + 1] == 1) {
				sum++;
			}
		}
		for (int i = 1; i < C - 1; i++) {
			if (arr[i - 1] - arr[i] == 1) {
				if (arr[i + 1] - arr[i] == 1) {
					sum++;
				}
			}
		}
		return sum;
	}

	static int solve6() {
		int sum = 0;
		int cnt = 1;
		int flag = arr[0];
		for (int i = 1; i < C; i++) {
			if (arr[i] == flag) {
				cnt++;
			} else {
				cnt = 1;
				flag = arr[i];
			}
			if (cnt >= 3) {
				sum++;
			}
		}
		cnt = 1;
		flag = arr[0];
		for (int i = 1; i < C; i++) {
			if (arr[i] == flag) {
				cnt++;
			} else {
				cnt = 1;
				flag = arr[i];
			}
			if (cnt >= 2) {
				sum++;
			}
		}
		for (int i = 0; i < C - 2; i++) {
			boolean fflag = true;
			for (int j = 1; j <= 2; j++) {
				if (arr[i + j] - arr[i] != 1) {
					fflag = false;
				}
			}
			if (fflag) {
				sum++;
			}
		}
		for (int i = 0; i < C - 1; i++) {
			if (arr[i] - arr[i + 1] == 2) {
				sum++;
			}
		}
		return sum;
	}

	static int solve7() {
		int sum = 0;
		int cnt = 1;
		int flag = arr[0];
		for (int i = 1; i < C; i++) {
			if (arr[i] == flag) {
				cnt++;
			} else {
				cnt = 1;
				flag = arr[i];
			}
			if (cnt >= 3) {
				sum++;
			}
		}
		for (int i = 0; i < C - 1; i++) {
			if (arr[i + 1] - arr[i] == 2) {
				sum++;
			}
		}
		for (int i = 2; i < C; i++) {
			boolean fflag = true;
			for (int j = 1; j <= 2; j++) {
				if (arr[i - j] - arr[i] != 1) {
					fflag = false;
				}
			}
			if (fflag) {
				sum++;
			}
		}
		cnt = 1;
		flag = arr[0];
		for (int i = 1; i < C; i++) {
			if (arr[i] == flag) {
				cnt++;
			} else {
				cnt = 1;
				flag = arr[i];
			}
			if (cnt >= 2) {
				sum++;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		P = sc.nextInt();
		arr = new int[C];
		int R = 0;
		for (int i = 0; i < C; i++) {
			arr[i] = sc.nextInt();
			if (R < arr[i]) {
				R = arr[i];
			}
		}
		R += 5;
		int[][] map = new int[R][C];
		for (int i = 0; i < C; i++) {
			int a = arr[i];
			for (int j = 0; j < a; j++) {
				map[j][i] = 1;
			}
		}

		switch (P) {
		case 1:
			System.out.println(solve1());
			break;
		case 2:
			System.out.println(solve2());
			break;
		case 3:
			System.out.println(solve3());
			break;
		case 4:
			System.out.println(solve4());
			break;
		case 5:
			System.out.println(solve5());
			break;
		case 6:
			System.out.println(solve6());
			break;
		case 7:
			System.out.println(solve7());
			break;
		}
	}

}
