import java.util.*;

public class Strongest_Fighters{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int len = sc.nextInt();

		int[] arr = new int[len];

		for(int i = 0; i < len; i++)
		{
			arr[i] = sc.nextInt();
		}
		int group = sc.nextInt();

		getResult(arr, group);
	}

	public static void getResult(int[] arr, int group)
	{
		for(int i = 0; i < arr.length; i++)
		{
			if( i+2 < arr.length)
				System.out.print(getMax(arr, i, i+2)+" ");
		}
	}
	public static int getMax(int[] arr, int si , int ei)
	{
		int temp = 0;
		for(int i = si; i <= ei; i++)
		{
			if(temp < arr[i])
			{
				temp = arr[i];
			}
		}
		return temp;
	}
}