package d0902;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 촌수계산(BFS)
public class BOJ2644_BFS_DP {

	static int N, M;
	static int start, end;
	static int[][] map;
	static int[] dis;
	static boolean[] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		start = sc.nextInt();
		end = sc.nextInt();
		map = new int[N + 1][N + 1];
		dis = new int[N + 1];
		visited = new boolean[N + 1];
		M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			map[start][end] = 1;
			map[end][start] = 1;
		}

		BFS();
		if (dis[end] != 0) {
			System.out.println(dis[end]);
		} else {
			System.out.println(-1);
		}
		sc.close();

	}

	public static void BFS() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == end)
				return;
			for (int i = 1; i <= N; i++) {
				if (visited[i])
					continue;
				if (map[cur][i] == 1) {
					visited[i] = true;
					dis[i] = dis[cur] + 1;
					q.offer(i);
				}
			}
		}
	}
}
