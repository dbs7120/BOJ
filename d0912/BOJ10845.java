package d0912;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 큐 ( ArrayList로 구현)
public class BOJ10845 {

	// push x / pop / size / empty / front / back
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> list = new ArrayList<Integer>();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < N; i++) {
			String cmd = br.readLine();
			if (cmd.equals("pop")) {
				if (list.size() != 0) {
					int num = list.remove(0);
					bw.append(num + "\n");
				} else {
					bw.append("-1\n");
				}
			} else if (cmd.equals("size")) {
				bw.append(list.size() + "\n");

			} else if (cmd.equals("empty")) {
				if (list.size() == 0) {
					bw.append("1\n");
				} else
					bw.append("0\n");

			} else if (cmd.equals("front")) {
				if (list.size() != 0) {
					int num = list.get(0);
					bw.append(num + "\n");
				} else {
					bw.append("-1\n");
				}

			} else if (cmd.equals("back")) {
				if (list.size() != 0) {
					int num = list.get(list.size() - 1);
					bw.append(num + "\n");
				} else {
					bw.append("-1\n");
				}

			} else { // push X
				st = new StringTokenizer(cmd, " ");
				st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				list.add(num);
			}
		}

		bw.flush();
		bw.close();

	}

}