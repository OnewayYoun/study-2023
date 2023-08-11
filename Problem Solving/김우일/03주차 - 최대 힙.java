package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Bj11279 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numberCount = Integer.parseInt(br.readLine());

		int inputNumber;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
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
