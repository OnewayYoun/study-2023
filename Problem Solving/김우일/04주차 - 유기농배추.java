package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1012 {

	static int width, length, plantCount;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] plant;
	static boolean[][] visit;

	static void dfs(int x, int y) {
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nearX = x + dx[i];
			int nearY = y + dy[i];
			if (nearX >= 0 && nearY >= 0 && nearX < width && nearY < length && !visit[nearX][nearY]
					&& plant[nearX][nearY] == 1) {
				dfs(nearX, nearY);
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalTestCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < totalTestCase; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			width = Integer.parseInt(st1.nextToken());
			length = Integer.parseInt(st1.nextToken());
			plant = new int[width][length];
			visit = new boolean[width][length];
			plantCount = Integer.parseInt(st1.nextToken());

			for (int j = 0; j < plantCount; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				plant[Integer.parseInt(st2.nextToken())][Integer.parseInt(st2.nextToken())] = 1;
			}

			int worm = 0;

			for (int k = 0; k < width; k++) {
				for (int v = 0; v < length; v++) {
					if (plant[k][v] == 1 && !visit[k][v]) {
						dfs(k, v);
						worm++;
					}
				}
			}
			System.out.println(worm);
		}
	}
}
