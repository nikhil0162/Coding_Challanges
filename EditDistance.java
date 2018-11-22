import java.util.Scanner;

public class EditDistance {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		
		String s1 = sc.next();
		String s2 = sc.next();
		
		System.out.println(getEditDistance(s1, s2));
	
	}
	
	public static int getEditDistance(String s1, String s2)
	{
		
		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length(); row >= 0; row--) {

			for (int col = s2.length(); col >= 0; col--) {

				if (row == s1.length()) {
					strg[row][col] = s2.length() - col;
					continue;
				}

				if (col == s2.length()) {
					strg[row][col] = s1.length() - row;
					continue;
				}

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1];
				} else {

					int insert = strg[row + 1][col];
					int delete = strg[row][col + 1];
					int replace = strg[row + 1][col + 1];

					strg[row][col] = Math.min(replace, Math.min(insert, delete)) + 1;

				}

			}
		}

		return strg[0][0];

	}

}