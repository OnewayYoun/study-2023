package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj4948 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int number = Integer.parseInt(br.readLine());
			if (number == 0)
				break;
			int answer = 0;

			for (int i = number + 1; i <= 2 * number; i++) {
				if (isPrime(i)) {
					answer++;
				}
			}
			System.out.println(answer);
		}
	}

	public static boolean isPrime(int number) {
		if (number == 1)
			return false;
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
