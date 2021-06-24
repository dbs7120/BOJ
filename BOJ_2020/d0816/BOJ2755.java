package d0816;

import java.util.Scanner;

// 이번학기 평점은 몇점? 
public class BOJ2755 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.next();
		double sum = 0; // 성적의 총합
		int sumPoint = 0;	// 학점의 총합
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			String grade = str.substring(str.length() - 2, str.length());
			grade = grade.trim();	// F => F(뒷공백제거)
			int point;
			if (!grade.equals("F"))	// F학점은 단일문자
				point = Integer.parseInt(str.substring(str.length() - 4, str.length() - 3));
			else
				point = Integer.parseInt(str.substring(str.length() - 3, str.length() - 2));
			
			sumPoint += point;			
			// 성적별로계산
			switch (grade) {
			case "A+":
				sum += 4.3 * point;
				break;
			case "A0":
				sum += 4.0 * point;
				break;
			case "A-":
				sum += 3.7 * point;
				break;
			case "B+":
				sum += 3.3 * point;
				break;
			case "B0":
				sum += 3.0 * point;
				break;
			case "B-":
				sum += 2.7 * point;
				break;
			case "C+":
				sum += 2.3 * point;
				break;
			case "C0":
				sum += 2.0 * point;
				break;
			case "C-":
				sum += 1.7 * point;
				break;
			case "D+":
				sum += 1.3 * point;
				break;
			case "D0":
				sum += 1.0 * point;
				break;
			case "D-":
				sum += 0.7 * point;
				break;
			case "F":
				sum += 0.0 * point;
				break;
			}
		}
		System.out.println(String.format("%.2f", sum / sumPoint));
		sc.close();
	}
}
