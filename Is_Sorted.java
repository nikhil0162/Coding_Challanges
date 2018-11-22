import java.util.*;
public class Is_Sorted {
	
    public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of array");
		int size = sc.nextInt();
		char[] ch = new char[size];
		for(int i = 0; i < size; i++)
		{
			ch[i] = sc.next().charAt(0);
		}


		 System.out.println(getResult(ch, 0));;      
    }

    public static boolean getResult(char[] ch, int j)
    {

    	if(j == ch.length-1)
    	{
    		return true;
    	}

    	if(ch[j] > ch[j+1])
    	{
    		return false;
    	}
    	return getResult(ch, j+1);
    }
}
