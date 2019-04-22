package DFS;

import java.util.Scanner;

public class Ex6603 {
	static int k;
	static int[] s;
	static int[] arr = new int[6];

	static void dfs(int idx, int depth) {
		// 6개의 숫자를 고르면 종료
		if (idx == 6) {
			for (int i = 0; i < 6; i++) {
				if (i != 5) {
					System.out.print(arr[i] + " ");
				} else {
					System.out.println(arr[i]);
				}
			}
			return;
		}

		// 0번째 수는 s[0]~s[k-1], 1번째 수는 s[0+1]~s[k-2+1]....
		for (int i = depth; i < k; i++) {
			arr[idx] = s[i];
			dfs(idx + 1, i + 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			k = sc.nextInt();
			if (k == 0) {
				break;
			}
			s = new int[k];
			for (int i = 0; i < k; i++) {
				s[i] = sc.nextInt();
			}
			dfs(0, 0);
			System.out.println();
		}

	}

}
