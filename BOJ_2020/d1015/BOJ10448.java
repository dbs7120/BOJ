package d1015;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 유레카 이론
// T44 => 44 * 45 / 2 = 990
// T45 => 45 * 46 / 2 = 1035
// ==> 45까지만 계산
public class BOJ10448 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		int[] trinumbers = new int[45];
		for (int i = 1; i < 45; i++) {
			trinumbers[i] = i * (i + 1) / 2;
		}
		loop: for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			for (int i = 1; i < 45; i++) {
				for (int j = 1; j < 45; j++) {
					for (int k = 1; k < 45; k++) {
						if (trinumbers[i] + trinumbers[j] + trinumbers[k] == N) {
							System.out.println(1);
							continue loop;
						}
					}
				}

			}
			System.out.println(0);

		}

	}
}
