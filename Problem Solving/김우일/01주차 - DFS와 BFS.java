package bj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bj1260 {

	private static int[][] graph;
	private static boolean[] checkList;
	private static int node, line, startNode;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		node = sc.nextInt();
		line = sc.nextInt();
		startNode = sc.nextInt();
		checkList = new boolean[node + 1];
		graph = new int[node + 1][node + 1];

		for (int i = 0; i < line; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x][y] = 1;
			graph[y][x] = 1;

		}

		dfs(startNode);
		System.out.println();
		checkList = new boolean[node + 1];
		bfs(startNode);

	}

	public static void dfs(int startNode) {
		checkList[startNode] = true;
		System.out.print(startNode + " ");

		for (int i = 0; i <= node; i++) {
			if (!checkList[i] && graph[startNode][i] == 1) {
				dfs(i);
			}
		}

	}

	public static void bfs(int startNode) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(startNode);
		checkList[startNode] = true;
		System.out.print(startNode + " ");

		while (!q.isEmpty()) {
			int number = q.poll();
			for (int i = 0; i <= node; i++) {
				if (graph[number][i] == 1 && !checkList[i]) {
					q.add(i);
					checkList[i] = true;
					System.out.print(i + " ");
				}
			}
		}

	}

}
