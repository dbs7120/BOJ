package d0905;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18405 {

	static class Virus {
		int y;
		int x;
		int num;
		int time;

		public Virus(int y, int x, int num, int time) {
			this.y = y;
			this.x = x;
			this.num = num;
			this.time = time;
		}

	}

	static int N, K; // 맵크기, 바이러스수
	static int[][] map;
	static int S; // 시간
	static int x, y;
	static Queue<Virus> q;
	static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		q = new LinkedList<Virus>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		S = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken()) - 1;
		y = Integer.parseInt(st.nextToken()) - 1;

		BFS();

//		for (int[] e : map) {
//			for (int f : e) {
//				System.out.print(f + " ");
//			}
//			System.out.println();
//		}

		bw.write(String.valueOf(map[x][y]) + "\n");
		bw.flush();
		bw.close();

	}

	public static void BFS() {
		ArrayList<Virus> list = new ArrayList<Virus>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0)
					list.add(new Virus(i, j, map[i][j], 0));
			}
		}
		Collections.sort(list, new Comparator<Virus>() {
			@Override
			public int compare(Virus o1, Virus o2) {
				return o1.num - o2.num;
			}
		});

		for (int i = 0; i < list.size(); i++)
			q.add(list.get(i));

		while (!q.isEmpty()) {
			Virus cur = q.poll();
			if (cur.time == S)
				break;

			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N)
					continue;
				if (map[ny][nx] != 0)
					continue;
				map[ny][nx] = cur.num;
				q.offer(new Virus(ny, nx, cur.num, cur.time + 1));

			}
		}

	}

}
