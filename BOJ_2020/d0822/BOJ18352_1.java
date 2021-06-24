package d0822;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 특정 거리의 도시 찾기
public class BOJ18352_1 {

	static int N, M, K, X;

	static ArrayList<Integer>[] map;
	static ArrayList<Integer> ans;

	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 도시
		M = sc.nextInt(); // 도로
		K = sc.nextInt(); // 거리정보
		X = sc.nextInt(); // 출발

		map = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		ans = new ArrayList<Integer>();

		for (int i = 1; i < N + 1; i++) {
			map[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			map[from].add(to); // 단방향
		}

		BFS(X);

		Collections.sort(ans);

		boolean check = false;
		for (int e : ans) {
			System.out.println(e);
			check = true;
		}
		if (!check)
			System.out.println(-1);

		sc.close();
	}

	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<Integer>();

		visited[start] = true;
		q.offer(start);
		int distance = 0;

		Q: while (!q.isEmpty()) {
			int size = q.size(); // 반복문내부에서 Q사이즈가 바뀌기떄문에 따로넣기
			for (int i = 0; i < size; i++) {
				int temp = q.poll();

				if (distance > K) {
					continue Q;
				}
				if (distance == K) {
					ans.add(temp);
				}

				for (int idx : map[temp]) {
					if (!visited[idx]) {
						q.offer(idx);
						visited[idx] = true;
					}
				}
			}
			distance++;

		}
	}
}