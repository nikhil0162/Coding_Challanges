public class PolinomialPower{	
	public static void main(String[] args) {
		int n = 5;
		int x = 3;

	System.out.println(nom(x, n));;	
	}
	public static int nom(int x, int n)
	{
		int power = x;
		int sum = 0;
		for(int i = n; i>=1; i--)
		{
			sum += (i * power);
			power = power *x;
		}
		return sum;
	}
}