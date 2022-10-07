
import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        System.out.println("Enter valid number:");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        factorial(n);




    }
    static void factorial(int n){
        int fact=1;

        for (int i=1;i<=n;i++){
            fact*=i;


        }
        System.out.println("Factorial of "+n+" is "+fact);

    }
}
