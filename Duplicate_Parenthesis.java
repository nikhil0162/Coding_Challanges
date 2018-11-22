// ((a + b) + ((c+d)))
// this example is only valid for Balanced expression
import java.util.*;
public class Duplicate_Parenthesis{
	static boolean check = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		boolean b = false;
		if(s.length() > 1)
		{
			b = getResult(s, s.length()-1, 0);
		}
		else
			System.out.println("False");			

		if(b)
		{
			System.out.println("True");
		}else
		System.out.println("False");
	}

	public static boolean getResult(String str, int size, int i)
	{
		if(i == size)
		{
			return check;
		}

		if(str.charAt(i) == '(' && str.charAt(i+1) == '(')
		{
			check = true;
		}
		else if(i >=1 && str.charAt(i) == '(' && str.charAt(i-1) != '('){
			check = false;
		}
		if(str.charAt(i) == ')' && str.charAt(i+1) == ')')
		{
			return check;
		}else if(str.charAt(i) == ')' && str.charAt(i - 1) != ')'){
			check = false;
		}

		return getResult(str, size, i+1);
	}
}