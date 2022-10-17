class Main
{
	public static int KNAPSAK(int[] v, int[] w, int n, int c)
	{
		// base case: Negative capacity
		if (c < 0) {
			return Integer.MIN_VALUE;
		}

		// base case: no items left or capacity becomes 0
		if (n < 0 || c == 0) {
			return 0;
		}
		int include = v[n] + knapsack(v, w, n - 1, c - w[n]);
		// remaining items `n-1`
		int exclude = KNAPSAK(v, w, n - 1, c);

		// return maximum value we get by including or excluding the current item
		return Integer.max(include, exclude);
	}

	// 0–1 Knapsack problem
	public static void main(String[] args)
	{
		int[] x = { 20, 5, 10, 40, 15, 25 };
		int[] y = { 1, 2, 3, 8, 7, 4 };

		// knapsack capacity
		int Y = 10;

		System.out.println("value is " +
				KNAPSAK(x, y, x.length - 1, Y));
	}
}
