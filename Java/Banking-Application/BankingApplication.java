import java.util.Scanner;

public class BankingApplication{
    public static void main(String[] args) {
        
        System.out.println();
        String cName;
        System.out.println("Hello Customer!");
        System.out.print("Please Register Your Name: ");
        Scanner in = new Scanner(System.in);
        cName = in.nextLine();

        double doubleRandomNumber = Math.random() * 1000;
        int cId = (int)doubleRandomNumber;

        BankAccount obj = new BankAccount(cName, cId);
        obj.showMenu();

        in.close();
    }
}

class BankAccount
{
    int balance;
    int previousTransaction;
    int amount;
    String customerName;
    int customerId;

    BankAccount(String cname, int cID){
        customerName = cname;
        customerId = cID;
    }

    // Deposit method
    void Deposit(int amount){
        if(amount!=0){
            balance = balance + amount;
            previousTransaction = amount;
            System.out.println("Amount Deposited Successfully !");
        }
        else{
            System.out.println("ERROR : ENTER A VALID AMOUNT TO DEPOSIT");
        }
    }

    // Withdraw method
    void Withdraw(int amount){
        if(amount!=0){
            balance = balance - amount;
            previousTransaction = -amount;
            System.out.println("Amount Withdrawn Successfully !");
        }
        else{
            System.out.println("ERROR: ENTER A VALID AMOUNT TO WITHDRAW");
        }
    }

    // previousTransaction method
    void previous_transaction(){
        if(previousTransaction>0){
            System.out.println("Deposited: "+ previousTransaction);
        }
        else if(previousTransaction<0){
            System.out.println("Withdrawl: "+ Math.abs(previousTransaction));
        }
        else{
            System.out.println("No Transaction History !");
        }
    }

    // show menu method
    void showMenu(){

        Scanner in = new Scanner(System.in);
        char option;

        System.out.println();
        System.out.println("Welcome, "+ customerName + " !");
        System.out.println("Your Id is "+ customerId);
        System.out.println();
        

        System.out.println("================================");
        System.out.println("Please Select An Option");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Check Previous Transaction");
        System.out.println("E. Exit");
        System.out.println("================================");


        do{
            System.out.println();
            System.out.print("Enter an option: ");
            option = in.next().charAt(0);

            switch(option) {
                case 'A':
                    System.out.println();
                    System.out.println("Current Balance = "+ balance);
                    System.out.println("================================");
                    break;

                case 'B':
                    System.out.print("Enter your amount: ");
                    amount = in.nextInt();
                    System.out.println();
                    Deposit(amount);
                    System.out.println("================================");
                    break;

                case 'C':
                    System.out.print("Enter your amount: ");
                    amount = in.nextInt();
                    System.out.println();
                    Withdraw(amount);
                    System.out.println("================================");
                    break;

                case 'D':
                    System.out.println();
                    previous_transaction();
                    System.out.println("================================");
                    break;

                case 'E':
                    System.out.println("Exiting....");
                    System.out.println();
                    break;

                default:
                    System.out.println("Choose a valid option !");
                    break;
            }

        } while(option!='E');

        System.out.println("Thanks for banking with us :)");
        System.out.println();

        in.close();
    }
}