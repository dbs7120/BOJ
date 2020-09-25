package d0924;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 개미
public class BOJ10158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int P = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(br.readLine().trim());

		// X축 Y축을 따로 나누어 생각
		int x = (P + time) / W; // t초동안 움직이게될 W의 총 갯수(주기: W)
		int y = (T + time) / H; // t초동안 움직이게될 H의 총 갯수(주기: H)

		if (x % 2 == 0) // 주기계산후 x가 짝수이면 좌측에서 우측으로
			P = 0 + (P + time) % W;
		else // 홀수면 우측에서 좌측으로
			P = W - ((P + time) % W);

		if (y % 2 == 0)
			T = 0 + (T + time) % H;
		else
			T = H - ((T + time) % H);

		System.out.print(P);
		System.out.println(" " + T);

	}

}
