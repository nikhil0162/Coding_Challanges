import java.util.*;
public class Palindrome {
    public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		String temp="";

		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == str.charAt(str.length()-(i+1)))
			{
				char c = str.charAt(i);
				String s = Character.toString(c);
				temp += s;
			}
		}

		if(str.equals(temp))
		{
			System.out.println("true");
		}else
		{
			System.out.println("false");
		}       
    }
}
