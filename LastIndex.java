import java.util.*;
public class LastIndex {
	
    public static void main(String args[]) {

    	Scanner sc = new Scanner(System.in);

// System.out.println("Enter the size");
    	int size = sc.nextInt();
    	System.out.println("Enter the target");
    	int target = sc.nextInt();
    	System.out.println("enter elements");

    	int[] arr = new int[size];

    	for(int i = 0; i < size; i++)
    	{
    		arr[i] = sc.nextInt();
    	}

    	System.out.println(getResult(arr, 0, target));

    }

    public static int getResult(int[] arr, int j, int target)
    {
   		if(j == arr.length)
   		{
   			return -1;
   		}

   		int index = getResult(arr, j+1, target);

   		if(arr[j] == target && index == -1)
   			index = j;
   		else
   			return index;

   		return index;
    }
}
