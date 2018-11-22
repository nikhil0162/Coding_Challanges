import java.util.*;

public class Redundant_Parenthesis{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int n = sc.nextInt();
				
		for(int i = 0; i < n; i++)
		{
			String str = sc.next();
			LinkedList<Character> q1 = new LinkedList<Character>();
			
			for(int j = 0; j < str.length(); j++)
			{
					q1.addLast(str.charAt(j));				
			}
			System.out.println(getRedundant(q1));
		}
	}

	  public static String getRedundant(LinkedList<Character> q1)
	  {
	    LinkedList<Character> q2 = new LinkedList<>();
	    Stack<Character> st = new Stack<Character>();
	    
	    char rev = '!';
	    boolean one = false;
	    Stack<Integer> check = new Stack<>();
	    int temp = 0;
	    while(!q1.isEmpty())
	    {
	      char ch = q1.removeFirst();
	        
	     // inserting
	      if(ch == '(' && q1.getFirst() == '(')
	      {
	    	  temp = 2;
	    	  one = true;
	    	  q2.addLast(ch);
	    	  q2.addLast(q1.removeFirst());
	      }else if(ch == '(' && rev == '(')
	      {
	    	  temp++;
	    	  one = true;
	    	  q2.addLast(ch);
	      }else if(ch == '('){
	    	  one = false;
	    	  st.push(ch);
	      }else if(rev == '('){
	    	  check.push(temp);
	      }

	      
	      //deleting  
	      if(ch == ')' && !q1.isEmpty() && q1.getFirst() == ')')
	      {
	    	  if(temp == 0)
	    	  {
	    		  if(!check.isEmpty())
	    			  temp = check.pop();
	    	  }
	    	  if(one && temp >= 2)
	    	  {
	    		  return "Duplicate";
	    	  }else if(!st.isEmpty())
	    	  {
	    		  st.pop();
	    	  }
	      }else if(ch == ')'){
	    	  if(!st.isEmpty())
	    	  {
	    		  st.pop();
	    	  }else {
	    		  temp--;
	    		  q2.removeFirst();
	    	  }
	      }
	      
	      if(st.isEmpty())
	    	  one = true;
	    	 
	    rev = ch;
	  }
	    return "Not Duplicates";
	}
}







//(((a+(b))+(c+d)))
//((a+(b))+(c+d))
//(((a+(b)))+(c+d))
//(a(A((ab))n)n)
//(((a-b+c)+((a+d)+(d+e))++((f+d)+(f+e)))
//(((a((b)v)c)))