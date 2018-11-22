import java.util.*;
public class Prime_Visits{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int testCases = sc.nextInt();
	for(int i = 0; i < testCases; i++)
	{
		int a = sc.nextInt();
		int b = sc.nextInt();

		 boolean[] arr = new boolean[b+1];
		 
		    Arrays.fill(arr, true);
		    
	    arr[0] = false;
	    arr[1] = false;


		System.out.println(getResult(arr, a, b));
	}
}
public static int getResult(boolean[] arr, int start, int end)
{
	    for(int table = 2; table * table <= end; table++)
		{
	      if(arr[table] == false)
	      {
	        continue;
	      }

	      for(int multiplier = 2; multiplier * table <= end; multiplier++)
	      {
	        
	          arr[table*multiplier] = false;
	        
	      }
	    }
	    	int times = 0;
	    for(int i = start; i <= end; i++)
		{
  			if(arr[i])
  			{
    			times++;
  			}
		}

		return times;
}
}
