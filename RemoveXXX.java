import java.util.*;

class RemoveXXX{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String str = sc.next();

    for(int j = 0; j< str.length(); j++)
    {
      if(str.charAt(j) == 'x')
      {
        str = str.substring(0, j)+str.substring(j+1);
        str+='x';
      }
    }
    System.out.println(str);

  }
}