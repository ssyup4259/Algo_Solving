package OTHER;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_백준_1544_사이클단어 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<String> list = new ArrayList<>();
		String str = sc.next();
		list.add(str);
		int cnt = 1;
		for (int i = 0; i < N - 1; i++) {
			String strCheck = sc.next();
			boolean check = false;
			for (int j = 0; j < strCheck.length(); j++) {
				strCheck = strCheck.substring(1) + strCheck.charAt(0);
				if (list.contains(strCheck)) {
					check = true;
					break;
				}
			}
			if (check == false) {
				str = strCheck;
				list.add(str);
				cnt++;
			}
		}
		System.out.println(cnt);

	}

}
