import java.util.*;
public class GenerateParenthesis_Program{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        GenerateParenthesis(0, 0, n, "");
        
    }
    public static void GenerateParenthesis(int open, int close, int n, String ans) {

		if (open == n && close == n) {
			System.out.println(ans);
			return;
		}

		if (open > n || close > n || close > open) {
			return;
		}

		GenerateParenthesis(open, close + 1, n, ans + ")");
		GenerateParenthesis(open + 1, close, n, ans + "(");

	}

}