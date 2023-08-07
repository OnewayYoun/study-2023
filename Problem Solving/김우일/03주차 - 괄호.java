package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class Bj9012 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int stringCount = Integer.parseInt(br.readLine());

		String[] answer = new String[stringCount];
		String[] sentences = new String[stringCount];
		for (int i = 0; i < stringCount; i++) {

			sentences[i] = br.readLine();

		}

		for (int i = 0; i < stringCount; i++) {
			Queue<Character> queue = new LinkedList<Character>();
			for (char x : sentences[i].toCharArray()) {
				if (x == '(') {
					queue.add(x);
				} else {
					if (queue.isEmpty()) {
						queue.add(x);
						break;
					} else {
						queue.poll();
					}
				}
			}
			if (queue.isEmpty()) {
				answer[i] = "YES";
			} else {
				answer[i] = "NO";
			}
		}

		for (String x : answer) {
			System.out.println(x);
		}
	}

}
