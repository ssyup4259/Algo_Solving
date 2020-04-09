import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_백준_8982_수족관1 {
	static class Info {
		int r, c;

		public Info(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] col = new int[40001];
		int max = 0;

		sc.nextInt();
		sc.nextInt();
		for (int i = 0; i < N / 2 - 1; i++) {
			int ac = sc.nextInt();
			int ar = sc.nextInt();
			int bc = sc.nextInt();
			int br = sc.nextInt();
			for (int j = ac; j <= bc; j++) {
				col[j] = ar;
			}
			max = bc;
		}
		sc.nextInt();
		sc.nextInt();

		List<Info> list = new ArrayList<>();
		int K = sc.nextInt();
		for (int i = 0; i < K; i++) {
			int ac = sc.nextInt();
			int ar = sc.nextInt();
			int bc = sc.nextInt();
			int br = sc.nextInt();
			list.add(new Info(ar, ac));
		}

		int[] sur = new int[40001];
		for (int i = 0; i < list.size(); i++) {
			Info now = list.get(i);
			int nowR = now.r;
			int nowC = now.c;

			for (int j = nowC; j >= 0; --j) {
				nowR = nowR > col[j] ? col[j] : nowR;
				sur[j] = nowR > sur[j] ? nowR : sur[j];
			}

			nowR = now.r;
			nowC = now.c;

			for (int j = nowC; j < max; ++j) {
				nowR = nowR > col[j] ? col[j] : nowR;
				sur[j] = nowR > sur[j] ? nowR : sur[j];
			}
		}
		
		int sum = 0;
		for (int i = 0; i < max; i++) {
			sum += col[i] - sur[i];
		}
		System.out.println(sum);
	}

}
