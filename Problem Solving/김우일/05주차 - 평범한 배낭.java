package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj12865 {

	static Integer[][] dp;
	static int[] weight;
	static int[] value;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int itemCount = Integer.parseInt(st.nextToken());
		int maxWeight = Integer.parseInt(st.nextToken());

		weight = new int[itemCount];
		value = new int[itemCount];

		dp = new Integer[itemCount][maxWeight + 1];

		for (int i = 0; i < itemCount; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(itemCount - 1, maxWeight));

	}

	static int solution(int depth, int index) {

		if (depth < 0)
			return 0;

		if (dp[depth][index] == null) {
			if (weight[depth] > index) {
				dp[depth][index] = solution(depth - 1, index);
			} else {
				dp[depth][index] = Math.max(solution(depth - 1, index),
						solution(depth - 1, index - weight[depth]) + value[depth]);
			}
		}
		return dp[depth][index];
	}
}
