package DFS;
import java.util.Arrays;
import java.util.Scanner;

public class Ex1759 {
	static int L, C;
	static char[] arr;
	static int count = 0;

	static void dfs(int depth, String s) {
		if (count == L) {
			if (check(s))
				System.out.println(s);
			return;
		}
		//���ڸ� �迭���� ������ �ϳ��� �ø��� ���غ���.
		for (int i = depth; i < C; i++) {
			count++;
			dfs(i + 1, s + arr[i]);
			//��Ʈ��ŷ
			count--;
		}
	}

	static boolean check(String s) {
		int moeum = 0;
		int jaeum = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				moeum++;
			} else {
				jaeum++;
			}
		}
		if (moeum >= 1 && jaeum >= 2) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		arr = new char[C];
		for (int i = 0; i < C; i++) {
			arr[i] = sc.next().charAt(0);
		}
		
		//�����ϴ¼�
		Arrays.sort(arr);
		dfs(0, "");
	}
}