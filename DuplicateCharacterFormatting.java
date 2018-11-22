import java.util.*;
public class DuplicateCharacterFormatting {
  public static void main(String... args)
  {
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine();
    char mark = sc.next().charAt(0);
    System.out.println(getResult(str, 0, mark));
  }

  public static String getResult(String str, int j, char mark)
  {
    if(j == str.length()-1)
    {
      return str;
    }

    if(str.charAt(j) == str.charAt(j+1))
    {
      str = str.substring(0,j+1)+mark+str.substring(j+1);
    }
    return getResult(str, j+1, mark);
  }
}