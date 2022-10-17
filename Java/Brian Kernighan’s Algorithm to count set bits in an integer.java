class Main
{
    public static int countsetbites(int n)
    {
        int c = 0;
 
        while (n != 0)
        {
            n = n & (n - 1);  
            c++;
        }
 
        return c;
    }
 
    public static void main(String[] args)
    {
        int n = -1;
 
        System.out.println(n + " in binary is " + Integer.toBinaryString(n));
        System.out.println("The total number of set bits in " + n + " is " +
            countsetbites(n));
    }
}
