import java.util.*;
class StringToInteger
{
  public static void main(String... args)
  {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
        System.out.println(convertToInteger(str, 0, 0));                    
  }
    public static int convertToInteger(String str, int j, int ansint)
      {         
        if(str.length() == 0)
        {
          return ansint;
        }
        char ch =str.charAt(0); 
          String ros = str.substring(1);

          Integer con = Integer.valueOf(ch);
          int shape = con-48;
          ansint = ansint*10+shape;
       return convertToInteger(ros, j+1, ansint);
      }
}







  // public static void main(String... args)
  // {
  
  //   String str = "1234";
  //       System.out.println(convertToInteger(str, 0));                    
  //     }
  //   public static boolean convertToInteger(String str, int j)
  //     {     
  //       if(j == str.length())
  //       {
  //         Integer inr = Integer.valueOf(str);
  //         if(inr instanceof Integer)
  //           return true;
  //         else
  //         return false;
  //       }
  //      return convertToInteger(str, j+1);
  //     }