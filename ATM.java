package Bank;

import java.util.*;
public class ATM
{
    public static Balance Obj = new Balance();

    public static void withdraw() 
    {   
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to be withdrawn:");
        double withdraw = sc.nextDouble();
        double Balance = Obj.getBalance();

        if (withdraw > 0 && withdraw <= Balance) {
            Balance -= withdraw;
            Obj.setBalance(Balance);
            System.out.println("Transaction Successfull");
        } 
        else 
        System.out.println("Insufficient balance or invalid amount");
    }

    public static void deposit() 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to deposit:");
        double deposit = sc.nextDouble();
        double Balance = Obj.getBalance();
        if (deposit > 0) 
        {
            Balance += deposit;
            Obj.setBalance(Balance);
            System.out.println("Deposited Successfully");
        } 
        else
        System.out.println("Deposit failed. Please enter a valid amount");
            
    }

    public static void checkBalance() 
    {
        double Balance = Obj.getBalance();
        System.out.println("Your current balance is:"+Balance);
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the ATM");
        boolean flag=true;
        while (flag) 
        {
            System.out.println("\nChoose the option below:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    flag=false; 
                    break;
                default:
                    System.out.println("INVALID INPUT. Please try again.");
                    break;
            }
        }
        sc.close();
    }
}