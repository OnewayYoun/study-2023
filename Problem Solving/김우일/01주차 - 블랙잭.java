package bj;

import java.util.Scanner;

public class FindCloseMaxSumSet {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numberCount = sc.nextInt();
		int goalNumber = sc.nextInt();
		int[] numberList = new int[numberCount];
		for (int i = 0; i < numberCount; i++) {
			numberList[i] = sc.nextInt();
		}

		int answer = solution(numberCount, goalNumber, numberList);
		System.out.print(answer);

	}

	public static int solution(int numberCount, int goalNumber, int[] numberList) {

		int answer = 0;
		for (int i = 0; i < numberCount - 2; i++) {
			for (int j = i + 1; j < numberCount - 1; j++) {
				for (int k = j + 1; k < numberCount; k++) {
					int currentSum = numberList[i] + numberList[j] + numberList[k];
					if (currentSum == goalNumber) {
						return currentSum;
					}

					if (currentSum < goalNumber) {
						answer = Math.max(currentSum, answer);
					}
				}
			}
		}
		return answer;

	}

}
