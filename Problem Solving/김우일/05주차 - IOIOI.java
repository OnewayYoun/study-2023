package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj5525 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		int length = Integer.parseInt(br.readLine());
		char[] sentence = br.readLine().toCharArray();

		int answer = 0;
		int tempCount = 0;
		for (int j = 1; j < length - 1; j++) {
			if (sentence[j - 1] == 'I' && sentence[j] == 'O' && sentence[j + 1] == 'I') {
				tempCount++;
				if (tempCount == number) {
					tempCount--;
					answer++;
				}
				j++;
			} else {
				tempCount = 0;
			}

		}
		System.out.println(answer);
	}
}
