import java.util.*;
public class ReverseArray {
	
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the size");
		int size = sc.nextInt();

		int[] arr = new int[size];
		for(int i = 0; i < size; i++)
		{
			arr[i] = sc.nextInt();
		}

		int[] temp = new int[size];

		int[] print = getResult(arr, 0, size-1, temp);

		for(int sorted : print)
		{
			System.out.println(sorted);
		}

    }

    public static int[] getResult(int[] arr, int i, int j, int[] temp)
    {
    	if(j < 0 && i == arr.length)
    	{
    		int[] ch = new int[0];
    		return ch;
    	}
    	if(j >= 0)
    	{	
    		temp[i] = arr[j];
    	}

    	getResult(arr, i + 1,j-1, temp);

    		return temp;
   	
    }
}
