
import java.util.*;

class Queue {

	protected int size;

	protected int front;
	protected int[] data;

	public Queue() {
		this.size = 0;
		this.front = 0;
		this.data = new int[5];
	}

	public Queue(int cap) {
		this.size = 0;
		this.front = 0;
		this.data = new int[cap];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void enqueue(int item) throws Exception {
		if (this.size() == this.data.length) {
			int[] oa = this.data;
			int[] na = new int[oa.length * 2];
			for (int i = 0; i < this.size(); i++) {
				int idx = (i + front) % oa.length;
				na[i] = oa[idx];
			}

			this.data = na;
			this.front = 0;
		}

		this.data[(front + size) % this.data.length] = item;
		size++;

	}

	public int dequeue() throws Exception {
		if (this.size == 0) {
			throw new Exception("queue is empty");

		}

		int rv = this.data[front];
		front = (front + 1) % this.data.length;
		size--;

		return rv;

	}

	public int getFront() throws Exception {
		if (this.size == 0) {
			throw new Exception("queue is empty");
		}

		int rv = this.data[front];

		return rv;
	}

	public void display() {
		System.out.println();
		for (int i = 0; i < size; i++) {
			int idx = (i + front) % this.data.length;
			System.out.print(this.data[idx] + " ");
		}
        System.out.print("END");
	}

	
    public static void Sum(int[] arr,int n,int k) throws Exception{ 
	
    	int result = 0;
    	int i = 0;
    	while(i+k <= arr.length)
    	{
    		int s = i+k;
    		int cap = i;
    		int ts = getResult(arr, n, k, i, s);
    		result = ts + result;
    		i = cap+1;
    	}
    	System.out.println(result);
    	
    }
    public static int getResult(int[] arr, int n, int k, int i, int s) throws Exception
    {
    	Queue q = new Queue(k);
    	int max = Integer.MIN_VALUE;
    	int min = Integer.MAX_VALUE;
    	while(i != s)
    	{
    		q.enqueue(arr[i]);
    		i++;
    	}
    	while(!q.isEmpty())
    	{
    		int temp = q.dequeue();
    		if(max < temp)
    			max = temp;

    		if(min > temp)
    			min = temp;
    	}
    	int ret = min + max;  
    	return ret;
    }



	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

        int t = scn.nextInt();
        
        while(t > 0){
		    int n = scn.nextInt();
		    int k = scn.nextInt();
		
		    int[] arr = new int[n];
		
		    for(int i = 0;i < n;i++){
		        arr[i] = scn.nextInt();
		    }
		    
		    Sum(arr,n,k);
		 
		t--;
	    }
	}
}

