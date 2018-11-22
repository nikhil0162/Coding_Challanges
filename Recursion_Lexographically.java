import java.util.*;
public class Recursion_Lexographically{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int end = sc.nextInt();
    getLexographical(0, end);  
    sc.close();
  }
  public static void getLexographical(int current, int end)
  {
    if(current > end)
    {
      return;
    }

    System.out.println(current);
          
   if(current !=0)
   {
      for(int i = 0; i <= 9; i++)
      {
       getLexographical(current*10+i, end);
      }
   }

    if(current+1 <= 9)
    {
      getLexographical(current+1, end);
    }

  }
}