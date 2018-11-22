import java.util.*;

public class CBNumber
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int len = sc.nextInt();
		
		String str = sc.next();

		try{
			if(str.length() != len)
			{
				throw new StringIndexOutOfBoundsException();
			}
		}catch(StringIndexOutOfBoundsException e)
		{
				System.out.println(e);
		}

			
		ArrayList<String> l = new ArrayList<>();
		System.out.println(getResult(str, l, 0, 0));
	}
	public static int getResult(String str, ArrayList<String> l, int count, int k)
	{
		if(str.length() == 0)
		{
			return count;
		}


			String ros = str.substring(1);

		int ts =0;
		if(ros.length() >= 1)
		{
			 ts = Integer.parseInt(ros);
		
			 if(l.indexOf(ros) == -1)
			{
				count++;
				l.add(ros);	
			}
		}
		

		getResult(str.substring(1), l, count, 0);
		getResult(str.substring(0, str.length()-1), l, count, 1);
		return count;
		
	}


	public static boolean checkPrime(int p)
	{
		boolean check = false;
	    boolean[] arr = new boolean[p+1];

    Arrays.fill(arr, true);
    if(p == 0 || p == 1)
    	return false;


     arr[0] = false;
        arr[1] = false;

    for(int table = 2; table * table <= p; table++)
    {
      if(arr[table] == false)
      {
        continue;
      }

      for(int multiplier = 2; multiplier * table <= p; multiplier++)
      {
        
          arr[table*multiplier] = false;
        
      }
    }

    for(int i = 2; i <= p; i++)
    {
      if(arr[i])
      {
      	if(i == p)
        {
        	check = true;
        }
      }
    }

    return check;
	}
}