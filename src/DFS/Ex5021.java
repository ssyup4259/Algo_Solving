package DFS;

import java.util.Scanner;

public class Ex5021 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		String king = sc.nextLine();
		String[] arr = new String[n+1]; // 사람들이름 정보
		arr[0] = king;
		
		String[][] name = new String[n+1][4];
		int flag;
		for (int i = 1; i <= n; i++) {
			String str = sc.nextLine();
			arr[i] = str;
			name[i][0] = str.substring(0, str.indexOf(" ")); // 본인
			str = str.substring(str.indexOf(" ") + 1);
			name[i][1] = str.substring(0, str.indexOf(" ")); // 부모1
			if(name[i][1].equals(king)) {
				flag = i;
			}
			str = str.substring(str.indexOf(" ") + 1);
			name[i][2] = str; // 부모2
			if(name[i][1].equals(king)) {
				flag = i;
			}
		}
		
		//name[i][3] = Integer.toString(Integer.parseInt(name[name[i][1]][3])+Integer.parseInt(arr[arr[i][1]][3])); //점수 저장
		String[] want = new String[m]; // 왕위 계승원하는자
		for (int i = 0; i < m; i++) {
			want[i] = sc.nextLine();
		}

	}

}
