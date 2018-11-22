import java.util.*;

class Triangle{
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      int num = sc.nextInt();
     System.out.println(getResult(num, 0));
            
    }
    public static int getResult(int num, int sum)
    {
      if(num == 0)
      {
        return 0;
      }
        
        sum = getResult(num-1, sum);             
        sum+=num;
        return sum;
  }
}