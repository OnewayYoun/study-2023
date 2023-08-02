package bj;

import java.util.*;

public class Bj12847 {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int num1 = kb.nextInt();
		int num2 = kb.nextInt();

		int money[] = new int[num1];
		for (int i = 0; i < num1; i++) {
			money[i] = kb.nextInt();
		}

		long sum = 0;
		long max = 0;
		for (int i = 0; i < num2; i++) {
			sum += money[i];

		}
		max = sum;
		for (int i = num2; i < num1; i++) {

			sum = sum + money[i] - money[i - num2];
			max = Math.max(max, sum);

		}

		System.out.println(max);
	}
}