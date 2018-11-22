import java.util.*;

class SumRecursion{
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      String str = sc.next();
     System.out.println(getResult(str, 0, 0));
            
    }
    public static int getResult(String str, int j, int sum)
    {
      if(j == str.length())
      {
        return 0;
      }
        
        sum = getResult(str, j+1, sum);     
        
        Integer num = Integer.valueOf(str.charAt(j));
        num -= 48;
        sum += num;
      
        return sum;
  }
}