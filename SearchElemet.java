import java.util.*;
public class SearchElemet{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++)
    {
      arr[i] = sc.nextInt();
    }    
    int target = sc.nextInt();

    System.out.println(getIndex(arr, target, 0));
  }
  public static int getIndex(int[] arr, int target, int count)
  {
    if(count == arr.length)
    {
      return -1;
    }
    if(arr[count] == target)
    {
      return count;
    }
    return getIndex(arr, target, count+1);
  }
}