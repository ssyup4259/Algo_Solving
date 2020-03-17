
import java.util.ArrayList;
import java.util.List;

public class day4 {

	public static void main(String[] args) {
		String rule = "zothf";
		String A = "otz";
		String B = "hh";

		System.out.println(solution(rule, A, B));

	}

	public static String solution(String rule, String A, String B) {
		int digit = rule.length(); // N진법의 N
		String alpha = "abcdefghijkl"; // 10진법이 넘어갈 경우에 대비
		String answer = "";

		// 알파벳 ->N진수
		long nA = alphaToN(A, rule);
		long nB = alphaToN(B, rule);

		// rule.length 진수 nA, nB를 십진수로
		long tenA = Long.parseLong(Long.toString(nA), rule.length());
		long tenB = Long.parseLong(Long.toString(nB), rule.length());

		long minus = (tenA - tenB);
		// 10진수의 minus를 rule.length 진수로
		String result = Long.toString(minus, rule.length());

		// N진수 -> 알파벳
		for (int i = 0; i < result.length(); i++) {
			if (Character.isDigit(result.charAt(i))) {
				answer += rule.charAt(result.charAt(i) - 48);
			} else {
				answer += rule.charAt(alpha.indexOf(result.charAt(i)) + 10);
			}
		}
		return answer;

	}

	public static long alphaToN(String N, String rule) {
		String strN = "";

		for (int i = 0; i < N.length(); i++) {
			strN += Integer.toString(rule.indexOf(N.charAt(i)));

		}
		return Long.parseLong(strN);
	}
}