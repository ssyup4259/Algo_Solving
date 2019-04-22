package OTHER;

import java.util.Scanner;

public class Ex3568 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		//first는 나중에 더해줄 처음 형식
		String first = str.substring(0, str.indexOf(" "));
		String[] arr = str.split(", ");
		
		//arr[0] 는 first를 포함하고 있다.
		arr[0] = arr[0].substring(str.indexOf(" ") + 1, arr[0].length());
		
		//차피 모든 변수에 ;를 입력해야하니;를 지워준다
		arr[arr.length - 1] = arr[arr.length - 1].replaceAll(";", "");
		
		//결과값 저장할 새로운 배열
		String[] arr2 = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arr2[i] = "";
			for (int j = arr[i].length() - 1; j >= 0; j--) {
				if (arr[i].substring(j).equals("*") || arr[i].substring(j).equals("&")) {
					//뒤부터 짤라 앞으로 더한다.
					String flag = arr[i].substring(j, j + 1);
					arr2[i] = arr2[i] + flag;
					arr[i] = arr[i].substring(0, j);
				} else if (arr[i].substring(j).equals("]")) {
					String flag = "[]";
					arr2[i] = arr2[i] + flag;
					arr[i] = arr[i].substring(0, j - 1);
				}
			}
			System.out.println(first + arr2[i] + " " + arr[i] + ";");
		}
	}

}
