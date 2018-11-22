import java.util.*;
class Recursion_IsBalanced{
  static boolean dec = false;
    
    public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       String str = sc.nextLine();
       sc.close();
//      String str = "[a + {b + (c + d) + e} + f]";
      ArrayList<Character> first = new ArrayList<Character>(70);


      for(int i=0; i < str.length(); i++)
      { 
        if(str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(')
        {
          first.add(str.charAt(i));
        }
        if(str.charAt(i) == '}' || str.charAt(i) == ']' || str.charAt(i) == ')')
        { 
          first.add(str.charAt(i));
        }
      }                  
      System.out.println(getResult(0, first, first.size()-1));
    }    

    public static boolean getResult(int j, ArrayList<Character> first, int size)
    {

      if(j == first.size()-1)
      {
        return dec;
      }
      if(first.get(j) == '{') {
        if(first.get(size-j) == '}' || first.get(j+1) == '}')
        {
          dec = true;
        }else {
          return false;
        }
      }
      if(first.get(j) == '[') {
        if(first.get(size-j) == ']' || first.get(j+1) == ']')
        {
          dec = true;
        }else {
          return false;
        }
      }
      if(first.get(j) == '(') {
        if(first.get(size-j) == ')' || first.get(j+1) == ')')
        {
          dec = true;
        }else {
          return false;
        }
      }
       return getResult(j+1, first, size);      
    }
}