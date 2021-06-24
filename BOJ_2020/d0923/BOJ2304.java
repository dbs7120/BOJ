package d0923;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 창고다각형
public class BOJ2304 {
	static class Pillar implements Comparable<Pillar> {
		int start;
		int height;

		public Pillar(int start, int height) {
			this.start = start;
			this.height = height;
		}

		@Override
		public int compareTo(Pillar o) {
			return this.start - o.start;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		Pillar[] pillars = new Pillar[N];
		int max = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			pillars[i] = new Pillar(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			if (max < pillars[i].height) { // 최대값 미리 계산해놓기
				max = pillars[i].height;
			}

		}
		Arrays.sort(pillars);

		int maxCnt = 0;
		int left = 0;
		int right = 0;
		for (int i = 0; i < N; i++) {
			if (pillars[i].height == max) { // 최대값의 갯수 카운터
				maxCnt++;
			}
			if (maxCnt == 1 && pillars[i].height == max) { // 최대값의 시작부분
				left = pillars[i].start;
			} else if (maxCnt >= 2 && pillars[i].height == max) { // 최대값의 끝나는부분 (여러개일때)
				right = pillars[i].start + 1;
			}
		}

		int size = 0;

		// 최대기둥넓이더하기
		if (maxCnt == 1) { // 최대기둥이 한개일때
			size += max * maxCnt;
		} else { // 최대기둥이 평행으로 여러개일때
			size += max * (right - left);
		}

		// 올라가는 형태일때 (앞에서부터 넓이구하기)
		Stack<Pillar> s = new Stack<Pillar>();
		s.push(pillars[0]);
		for (int i = 1; i < N; i++) {
			int temp = 0;
			Pillar cur = s.peek();
			if (cur.height < pillars[i].height) {
				s.pop();
				s.push(pillars[i]);
				temp = (pillars[i].start - cur.start) * cur.height;
				size += temp;
			} else {
				continue;
			}
		}

		// 내려가능 형태일때 (뒤에서부터 같은방식으로 넓이구하기)
		s = new Stack<Pillar>();
		s.push(pillars[N - 1]);
		for (int i = N - 2; i >= 0; i--) {
			int temp = 0;
			Pillar cur = s.peek();
			if (cur.height < pillars[i].height) {
				s.pop();
				s.push(pillars[i]);
				temp = (cur.start - pillars[i].start) * cur.height;
				size += temp;
			} else {
				continue;
			}
		}

		System.out.println(size);

	}

}
