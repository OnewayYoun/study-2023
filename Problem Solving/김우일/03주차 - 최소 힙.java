package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Bj1927 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numberCount = Integer.parseInt(br.readLine());

		int inputNumber;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for (int i = 0; i < numberCount; i++) {
			inputNumber = Integer.parseInt(br.readLine());
			if (inputNumber > 0) {
				queue.add(inputNumber);
			} else {
				if (!queue.isEmpty()) {
					System.out.println(queue.poll());
				} else {
					System.out.println(0);
				}
			}
		}
		br.close();
	}

}
