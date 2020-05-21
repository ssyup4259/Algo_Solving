package OTHER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_백준_11723_집합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int set = 0;
		StringBuilder result = new StringBuilder("");
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			String str = st.nextToken();
			if (str.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				if ((set & (1 << num - 1)) == 0) {
					set = set | 1 << num - 1;
				}
			} else if (str.equals("remove")) {
				int num = Integer.parseInt(st.nextToken());
				if ((set & (1 << num - 1)) > 0) {
					set = set & ~(1 << num - 1);
				}
			} else if (str.equals("check")) {
				int num = Integer.parseInt(st.nextToken());
				if ((set & (1 << num - 1)) > 0) {
					result.append("1\n");
				} else {
					result.append("0\n");
				}
			} else if (str.equals("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				if ((set & (1 << num - 1)) > 0) {
					set = set & ~(1 << num - 1);
				} else {
					set = set | (1 << num - 1);
				}
			} else if (str.equals("all")) {
				set = ~(1 << 21);
			} else {
				set = 0;
			}
		}
		System.out.println(result);
	}

}
