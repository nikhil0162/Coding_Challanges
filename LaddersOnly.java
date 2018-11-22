import java.util.*;
public class LaddersOnly{
static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		boolean[] arr = new boolean[size + 1];
		
		ArrayList<Integer> l = getPrimes(size, arr); // all prime numbers
		System.out.println(onlyCountLadder(0, size, l, "")); // count
		onlyLadder(0, size, l, ""); // steps
		sc.close();
	}

	public static int onlyCountLadder(int curr, int n, ArrayList<Integer> l, String ans) {
		if (curr == n) {
			return count+=1;
		}
		if (curr > n)
			return count+=0;

				for (int i = 1; i <= 6; i++) {
			onlyCountLadder(curr + i, n, l, ans + curr + " ");

			for(int j = 0; j < l.size()/2; j++)
			{
				if(curr == l.get(j))
				{
					int cut = l.size()-1;
					int eq = l.get(cut-j);
					curr = eq;
				}
			} 			
		} 
		return count;
	}
	
	public static void onlyLadder(int curr, int n, ArrayList<Integer> l, String ans) {
		if (curr == n) {
			System.out.print(ans + "END" + ", ");
			return;
		}
		if (curr > n)
			return;

		for (int i = 1; i <= 6; i++) {
			onlyLadder(curr + i, n, l, ans + curr + " ");

			for(int j = 0; j < l.size()/2; j++)
			{
				if(curr == l.get(j))
				{
					int cut = l.size()-1;
					int eq = l.get(cut-j);
					curr = eq;
				}
			} 					
		} 
	}
	

	public static ArrayList<Integer> getPrimes(int range, boolean[] arr)
	{
		Arrays.fill(arr, true);
		arr[0] = false;
		arr[1] = false;
		ArrayList<Integer> l = new ArrayList<>();

		for (int i = 2; i * i <= range; i++) {
			if (arr[i] == false) {
				continue;
			}

			for (int k = 2; k * i <= range; k++) {
				arr[k * i] = false;
			}

		}

		for (int j = 2; j <= range; j++) {
			if (arr[j]) {
				l.add(j);
			}
		}
		return l;
	}
}
