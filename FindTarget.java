import java.util.*;
public class FindTarget {
	
    public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		

		int[] ch = new int[size];
		for(int i = 0; i < size; i++)
		{
			ch[i] = sc.nextInt();
		}

		int target = sc.nextInt();
		System.out.println(getResult(ch, target, 0));

    }

    public static boolean getResult(int[] ch, int target, int j)
    {
    	if(j == ch.length)
    	{
    		return false;
    	}
    	if(ch[j] == target)
    	{
    		return true;
    	}
    	
    	return getResult(ch, target, j+1);
    }
}
