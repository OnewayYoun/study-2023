package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2623 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int singerCount = Integer.parseInt(st.nextToken());
		int pdCount = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> numbers = new ArrayList<>();
		for (int i = 0; i < singerCount + 1; i++) {
			numbers.add(new ArrayList<>());
		}
		int[] count = new int[singerCount + 1];

		for (int i = 0; i < pdCount; i++) {
			st = new StringTokenizer(br.readLine());
			int singerCountByPd = Integer.parseInt(st.nextToken());
			int firstSinger = Integer.parseInt(st.nextToken());
			for (int j = 0; j < singerCountByPd - 1; j++) {
				int nextSinger = Integer.parseInt(st.nextToken());
				numbers.get(firstSinger).add(nextSinger);
				count[nextSinger] += 1;
				firstSinger = nextSinger;
			}
		}

		Queue<Integer> stayList = new LinkedList<>();
		for (int i = 1; i < singerCount + 1; i++) {
			if (count[i] == 0) {
				stayList.add(i);
			}
		}
		Queue<Integer> answer = new LinkedList<>();
		while (!stayList.isEmpty()) {
			int singer = stayList.poll();
			answer.add(singer);
			for (int x : numbers.get(singer)) {
				count[x]--;
				if (count[x] == 0) {
					stayList.add(x);
				}
			}
		}
		Boolean finishFlag = true;
		for (int i = 1; i < numbers.size(); i++) {
			if (count[i] != 0) {
				finishFlag = false;
			}
		}

		if (finishFlag) {
			while (!answer.isEmpty()) {
				System.out.println(answer.poll());
			}
		} else {
			System.out.println(0);
		}

	}
}
