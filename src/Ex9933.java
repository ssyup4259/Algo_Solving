
import java.util.Scanner;

public class Ex9933 {
	// String을 앞뒤 바꿔서 리턴
	static String solve(String str) {
		char[] arr = str.toCharArray();
		for (int i = 0; i < str.length() / 2; i++) {
			char temp = arr[i];
			arr[i] = arr[str.length() - 1 - i];
			arr[str.length() - 1 - i] = temp;
		}
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextLine();
		}

		// 자기자신이 펠린드롭이라면 비밀번호가 될 수 있으니깐
		for (int i = 0; i < N - 1; i++) {
			// 자기 자신도 포함(j=i)
			for (int j = i; j < N; j++) {
				// arr[i] 와 arr[j]의 앞뒤 바꾼것이 같다면
				if (arr[i].equals(solve(arr[j]))) {
					System.out.println(arr[i].length() + " " + arr[i].charAt(arr[i].length() / 2));
					return;
				}
			}
		}

	}

}
