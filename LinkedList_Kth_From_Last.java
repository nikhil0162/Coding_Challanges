import java.util.*;
public class LinkedList_Kth_From_Last {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> ll = new LinkedList<>();
        while(true)
        {
        	int n = sc.nextInt();
        	if(n < 0)
        	{
        		ll.add(n);
        		break;
        	}else{
        		ll.add(n);
 			}   
        }
        int target = sc.nextInt()+1;
    	System.out.println(getResult(ll, target));
    }
    public static int getResult(LinkedList<Integer> ll, int idx)
    {
    	int i = 1;
    	while(!ll.isEmpty())
    	{
    		if(i == idx)
    		{
    			return ll.removeLast();
    		}
    		ll.removeLast();
    		i++;
    	}

    	return -1;
    }
}
