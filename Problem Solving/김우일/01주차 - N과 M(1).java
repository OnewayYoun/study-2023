package codingTest;

import java.util.Scanner;

public class NandM {

	public static int[] numberList;
	public static boolean[] checkList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number1 = sc.nextInt();
		int number2 = sc.nextInt();
		numberList = new int[number2];
		checkList = new boolean[number1];
		solution(number1, number2, 0);
	}

	public static void solution(int number1, int number2, int depth) {
		if (number2 == depth) {
			for (int number : numberList) {
				System.out.print(number + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < number1; i++) {
			if (!checkList[i]) {
				checkList[i] = true;
				numberList[depth] = i + 1;
				solution(number1, number2, depth + 1);
				checkList[i] = false;
			}
		}
		return;
	}
}
