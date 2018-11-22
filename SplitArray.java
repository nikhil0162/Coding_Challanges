import java.util.*;

class SplitArray{
static Scanner sc = new Scanner(System.in);
static int count = 0;
    public static void main(String... args)
    {
      int size = sc.nextInt();
     int[] arr = new int[size];
    for(int i = 0; i < size; i++)
    {
      arr[i] = sc.nextInt();
    }
    System.out.println(getSplitCount(arr, 0, 0, "", 0, ""));
      getSplit(arr, 0, 0, "", 0, "");
    }
    public static int getSplitCount(int[] arr, int vidx, int sumL, String ansL, int sumR, String ansR)
    {
      if(vidx == arr.length)
      {
        if(sumL == sumR)
        {
          count += 1;
        }
        return count += 0;
      }
      getSplitCount(arr, vidx+1, sumL+arr[vidx], ansL+arr[vidx]+" ", sumR, ansR);
      getSplitCount(arr, vidx+1, sumL, ansL, sumR+arr[vidx], ansR+arr[vidx]+" ");
      
      return count;
    }
    public static void getSplit(int[] arr, int vidx, int sumL, String ansL, int sumR, String ansR)
    {
      if(vidx == arr.length)
      {
        if(sumL == sumR)
        {
          System.out.println(ansL + "and "+ ansR);
        }
        return;
      }
      getSplit(arr, vidx+1, sumL+arr[vidx], ansL+arr[vidx]+" ", sumR, ansR);
      getSplit(arr, vidx+1, sumL, ansL, sumR+arr[vidx], ansR+arr[vidx]+" ");
      
    } 
  }