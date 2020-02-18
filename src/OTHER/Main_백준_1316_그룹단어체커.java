package OTHER;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_백준_1316_그룹단어체커 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			ArrayList<String> list = new ArrayList<>();
			String start = str.substring(0, 1);
			list.add(start);
			boolean flag = true;
			for (int j = 1; j < str.length(); j++) {
				String temp = str.substring(j, j + 1);
				if (!temp.equals(start)) {
					if (list.contains(temp)) {
						flag = false;
						break;
					}
				} else {
					continue;
				}
				list.add(temp);
				start = temp;
			}
			if (flag) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
