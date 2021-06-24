package d0804;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class LocationTomato { // 위치 좌표
	int y;
	int x;

	public LocationTomato(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

// 4방위로 퍼짐(대각선X)
// 모두다 익은 토마토(1)로 채워지는 최소 일수
// 1: 익은 토마토
// 0: 익지않은 토마토
// -1: 토마토가 없는 칸

public class BOJ7576 {

	static int[][] map;
	static int[][] distance; // <==> day저장배열
	static int[] dy = { -1, 1, 0, 0 }; // 4 방위 y
	static int[] dx = { 0, 0, -1, 1 }; // 4 방위 x
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();	// 입력 가로칸
		N = sc.nextInt();	// 입력 세로칸

		map = new int[N][M];
		distance = new int[N][M];

		for (int i = 0; i < N; i++) {	// 토마토 정보들
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		bfs();

//		//출력확인용
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				// -1: 없는칸, 0: 처음의 익은토마토 이거나 가지못하는 칸
//				// 나머지 숫자: 퍼진 거리(시간)
//				System.out.print(distance[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				// -1: 없는 칸, 1: 익은 토마토(처음으로 부터 퍼진)
//				// 0: 갈 수 없는 곳
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

		int day = -1;
		boolean flag = true;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0 && distance[i][j]==0) {	// 두 저장소 모두 0이있다면 모두 익지못하는 상황 존재
					flag = false;
				}
				if(distance[i][j] > day) {
					day = distance[i][j];
				}
			}
		}

		if(flag) {
			System.out.println(day);
		}else {
			System.out.println(-1);
		}


		sc.close();

	}

	static void bfs() { // BFS map(토마토저장정보), distance(익은(퍼진) 거리(시간))
		Queue<LocationTomato> q = new LinkedList<LocationTomato>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {	// 익은 토마토들 먼저 찾기
					q.offer(new LocationTomato(i, j));
				}
				if (map[i][j] == -1) {	// 토마토 없는칸은 -1 처리
					distance[i][j] = -1;
				}
			}
		}

		while (!q.isEmpty()) {
			LocationTomato temp = new LocationTomato(q.peek().y, q.peek().x); // 현재 피크값을 임시로 넣어 주위 판단
			q.poll();
			for (int d = 0; d < 4; d++) { // 4방위 탐색하기

				int ny = temp.y + dy[d];
				int nx = temp.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M) { // 경계체크
					continue;
				}

				if (map[ny][nx] == 0) {
					q.offer(new LocationTomato(ny, nx));
					map[ny][nx] = 1;
					distance[ny][nx] = distance[temp.y][temp.x] + 1;
				}
			}
		}
	}
}
