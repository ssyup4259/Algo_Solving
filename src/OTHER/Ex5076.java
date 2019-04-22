package OTHER;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex5076 {
	static List<String> list;
	static String result;

	static void makeList(String str) {
		int start = str.indexOf("<");
		int end = str.indexOf(">");
		if (start == -1 && end == -1) { // 괄호가 없으면 끝
			return;
		}
		String newStr = str.substring(start, end + 1);
		str = str.substring(end + 1);
		list.add(newStr);
		makeList(str);
	}

	static void solve() {
		for (int i = 0; i < list.size(); i++) { // 외태그 애들 다 제외
			String str = list.get(i);
			if (str.indexOf("/>") != -1) {
				list.remove(i);
				i--;
			}
		}
		
		if (list.size() % 2 != 0) { // 외테그 제외 했는데 홀수개이면 illegal
			result = "illegal";
			return;
		}
		
		for (int i = 0; i < list.size() / 2; i++) {
			// Ex) 4개의 태그가 잇을때 1번째 태그와 4번째 태그 같고 2번째와 3번째 태그 같아야한다.
			String str1 = list.get(i);
			String str2 = list.get(list.size() - 1 - i);
			String[] str1Arr = str1.split(" "); // 속성 태그들 제외 시키고, 클로징 태크는 속성 없다.
			str1Arr[0] = str1Arr[0].replaceAll("<", "");
			str1Arr[0] = str1Arr[0].replaceAll(">", "");
			str1Arr[0] = str1Arr[0].replaceAll("/", "");
			str2 = str2.replaceAll("<", "");
			str2 = str2.replaceAll(">", "");
			str2 = str2.replaceAll("/", "");
			if (!str1Arr[0].equals(str2)) { // 오프닝과 클로징이 다르면 illegal
				result = "illegal";
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String str = sc.nextLine();
			if (str.equals("#")) {
				break;
			}
			result = "legal";
			list = new ArrayList<>();
			makeList(str);
			solve();
			System.out.println(result);
		}
	}

}
