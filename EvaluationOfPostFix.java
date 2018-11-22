import java.util.Scanner;
import java.util.Stack;

public class EvaluationOfPostFix{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCases = sc.nextInt();
		String str = "";
		for(int i = 0; i < testCases; i++)
		{
			str = sc.next();
			Stack<Integer> st = new Stack<Integer>();
			System.out.println(getEvaluationPostFix(str, 0, st));
		}
	}
	
	public static int getEvaluationPostFix(String str, int i, Stack<Integer> st)
	{
		
		if(i == str.length())
			return st.pop();
		
		if(str.charAt(i) >=48 && str.charAt(i) <= 57)
		{
			int ch = str.charAt(i) - 48;
			st.push(ch);
		}else {
			
			if(str.charAt(i) == '/')
			{
				int one = st.pop();
				int two = st.pop();
				int ans = two / one;
				st.push(ans);
			}else if(str.charAt(i) == '*')
			{
				int one = st.pop();
				int two = st.pop();
				
				int ans = two * one;
				st.push(ans);
			}else if(str.charAt(i) == '+')
			{
				int one = st.pop();
				int two = st.pop();
				
				int ans = two + one;
				st.push(ans);
			}else if(str.charAt(i) == '-'){
				int one = st.pop();
				int two = st.pop();
				
				int ans = two - one;
				st.push(ans);
			}
		}
		
		return getEvaluationPostFix(str, i+1, st);
		
	}
}