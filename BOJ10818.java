import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ10818 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);

		int min = 1000001;
		int max = -1000001;
		int temp;

		for (int i = 0; i < N; i++) {

			temp = Integer.parseInt(stk.nextToken());
			if (min > temp)
				min = temp;
			if (max < temp)
				max = temp;
		}
		bw.write((min + " " + max) + "\n");
		bw.flush();
		bw.close();
	}
}
