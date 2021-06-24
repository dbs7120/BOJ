package d0804;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 양방향 그래프 dfs, bfs
//
public class BOJ1260 {
	static int N;
	static int M;
	static int V;

	static ArrayList<Integer>[] map;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점수
		M = sc.nextInt(); // 간선수
		V = sc.nextInt(); // 시작위치

		map = new ArrayList[N + 1]; // 인덱스 0번 사용안함

		for (int i = 1; i < N + 1; i++) {
			map[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			map[from].add(to);
			map[to].add(from);

		}

		// 문제조건
		// 정점이 여러 개인 경우에는
		// 정점 번호가 작은 것을 먼저 방문
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(map[i]); // 각 리스트배열들 정렬
		}

//		for (int i = 1; i < N + 1; i++) {
//			System.out.println(map[i].toString());
//		}

		visited = new boolean[N + 1];
		dfs(V);
		System.out.println();

		visited = new boolean[N + 1];
		bfs();

		sc.close();

	}

	private static void dfs(int start) {
		visited[start] = true;

		System.out.print(start + " ");

		for (int idx : map[start]) {
			if (!visited[idx]) { // 방문하지 않으면
				dfs(idx); // 재귀호출
			}
		}

	}

	private static void bfs() {
		int start = V;
		Queue<Integer> q = new LinkedList<Integer>();

		visited[start] = true;
		q.offer(start);

		while (!q.isEmpty()) {
			int temp = q.poll();

			System.out.print(temp + " ");

			for (int i : map[temp]) {
				if (!visited[i]) { // 방문하지 않으면
					q.offer(i); // 큐빼기
					visited[i] = true;
				}
			}

		}

	}

}