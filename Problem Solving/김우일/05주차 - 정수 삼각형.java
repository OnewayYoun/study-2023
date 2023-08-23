package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1932 {

	static int[][] numbers;
	static Integer[][] dp;
	static int numberCount;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numberCount = Integer.parseInt(br.readLine());

		numbers = new int[numberCount][numberCount];
		dp = new Integer[numberCount][numberCount];

		StringTokenizer st;

		for (int i = 0; i < numberCount; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i + 1; j++) {
				numbers[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < numberCount; i++) {
			dp[numberCount - 1][i] = numbers[numberCount - 1][i];
		}

		System.out.print(solution(0, 0));
	}

	static int solution(int depth, int index) {
		if (depth == numberCount - 1) {
			return dp[depth][index];
		}

		if (dp[depth][index] == null) {
			dp[depth][index] = Math.max(solution(depth + 1, index), solution(depth + 1, index + 1))
					+ numbers[depth][index];
		}
		return dp[depth][index];
	}

}
