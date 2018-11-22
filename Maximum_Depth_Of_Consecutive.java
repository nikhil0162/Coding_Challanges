import java.util.*;

public class Maximum_Depth_Of_Consecutive{

  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
  
      
    int n = sc.nextInt();
        
    for(int i = 0; i < n; i++)
    {
      String str = sc.next();
      LinkedList<Character> q1 = new LinkedList<Character>();
      
      for(int j = 0; j < str.length(); j++)
      {
          q1.addLast(str.charAt(j));        
      }
      System.out.println(getMaximumConsecutive(q1, str));
    }
  }
  
  public static int getMaximumConsecutive(LinkedList<Character> q1, String str)
  {
    Stack<Character> stack = new Stack<Character>(); 
    if(!isBalanced(str, stack))
    {
      return -1;
    }
    if(q1.getFirst() == ')' || q1.size() == 1)
    {
      return -1;
    }
    int one = 0;
    int two = 0;
    int count = 0;
    int ans = 0;
    while(!q1.isEmpty())
    {
      char ch = q1.removeFirst();
      if(ch == '(')
      {
        one++;
        count++;
        two = 0;
      }
      if(ch == ')')
      {
        count++;
        two++;
        
        if(ans < one)
        {
          ans = one;
        }
        if(ans < two){
          ans = two;
        }
        one = 0;
      }
    }
    if(count % 2 != 0)
      return -1;
    else
      return ans;
  }
  
  
  
  
  public static boolean isBalanced(String str, Stack<Character> stack) 
  {
     int i = 0;
        while(i < str.length())
        {
          if(str.charAt(i) == '(')
          {
            stack.push(str.charAt(i));
          }
          
          if(str.charAt(i) == ')')
          {
            if(!stack.isEmpty())
            {
              stack.pop();
            }else {
              return false;
            }
          }
          i++;
        }
        if(stack.size() != 0)
          return false;
        else
          return true;
    }
  
}





// 3
// (((X))(((Y))))
// (p((q))((s)t))
// b)(c)()








