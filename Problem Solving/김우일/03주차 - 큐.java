package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj10845 {
	static int[] que = new int[10001];
	static int first = 0;
	static int last = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numberCount = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numberCount; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String inputText = st.nextToken();

			switch (inputText) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(pop()).append("\n");
				break;
			case "size":
				sb.append(size()).append("\n");
				break;
			case "empty":
				sb.append(empty()).append("\n");
				break;
			case "front":
				sb.append(front()).append("\n");
				break;
			case "back":
				sb.append(back()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}

	public static void push(int inputNumber) {
		que[last] = inputNumber;
		last++;
	}

	public static int pop() {
		if (last - first == 0) {
			return -1;
		} else {
			int P = que[first];
			first++;
			return P;
		}
	}

	public static int size() {
		return last - first;
	}

	public static int empty() {
		if (last - first == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public static int front() {
		if (last - first == 0) {
			return -1;
		} else {
			int firstNumber = que[first];
			return firstNumber;
		}
	}

	public static int back() {
		if (last - first == 0) {
			return -1;
		} else {
			int lastNumber = que[last - 1];
			return lastNumber;
		}
	}
}
