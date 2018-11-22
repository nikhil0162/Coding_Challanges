import java.util.*;
public class Tower_Of_Hanoi{
  static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int n = sc.nextInt();
		
		getHanoi(n, "T1", "T3", "T2");
		System.out.println(count);
	}
	
	public static void getHanoi(int n, String src, String helper, String dest)
	{
		if(n == 0)
			return;
		
		getHanoi(n-1, src, dest, helper);
	
		count++;
		System.out.println("Move "+n+"th"+ " disc from "+ src + " to "+ dest);
		
		getHanoi(n-1, helper, src, dest);
		
	}
}