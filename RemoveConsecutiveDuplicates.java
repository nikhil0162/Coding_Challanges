import java.util.*;
class RemoveConsecutiveDuplicates{
  public static void main(String... args)
  {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    int len = str.length();
        System.out.println(getRemoveDuplicate(str, len, 0));                    
      }
    public static String getRemoveDuplicate(String str, int len, int s)
      { 
        if(s >= len)
        {
          return str;
        }
        for(int j = 0; j < str.length()-1; j++)
        {
          if(str.charAt(j) == str.charAt(j+1))
          {
            str = str.substring(0,j)+str.substring(j+1);
          }
        }
        return getRemoveDuplicate(str, len, s+1);
      }
  }