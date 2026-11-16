package org.example;

import java.util.Scanner;

public class Main{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        // Log in
        System.out.println("please enter your 4-digit PIN");
        int pin =scanner.nextInt();
        int count = 0;

        while (pin != 1234){
            System.out.println("PIN is wrong");
            count++;
            if(count == 3){
                System.out.println("your account has been locked");
                break;
            } else {
                System.out.println("Try Again");
                pin =scanner.nextInt();
            }

        }
        if(pin != 1234){
            return;
        }else {
            System.out.println("Welcome");
        }

        double balance = 2500.75;
        int depositCount=0;
        int withdrawCount=0;
    // the menu
        int checkBalance = 1;
        int Deposit = 2;
        int Withdraw = 3;
        int ShowAccountStatus =4;
        int Exit =5;
        int chose ;
        do{
            System.out.println("""
                    Please select an operation:\s
                    1. Check Balance
                    2. Deposit
                    3. Withdraw
                    4. Show Account Status
                    5. Exit
                    """);
            chose = scanner.nextInt();
            if(chose < 1 || 5 < chose){
                System.out.println(" Invalid option");
            }
            //switch
            switch (chose){
                //Check Balance
                case 1:
                    System.out.println("your balance is" + balance);
                    break;
                //Deposit
                case 2:
                    System.out.println("enter deposit amount ");
                    double depositamount = scanner.nextDouble();
                    if(depositamount <= 0){
                        System.out.println("Invlid amount");
                    } else{
                        balance += depositamount;
                        depositCount++;
                        System.out.println("New balance "+ balance);
                    }

                    break;
                //Withdraw
                case 3:
                    System.out.println("enter Withdraw amount ");
                    double withdrawamount = scanner.nextDouble();
                    if(withdrawamount < 0){
                        System.out.println("Invlid amount");
                    } else if(withdrawamount == 0){
                        System.out.println("transaction cancelled");
                    }else if(withdrawamount > balance){
                        System.out.println("Insufficient balance");
                    }else{
                        balance -= withdrawamount;
                        if(balance == 0){
                            System.out.println("Warning: your account is empty");
                        }
                        withdrawCount++;
                        System.out.println("New balance "+ balance);
                    }
                    break;
                //Account Status
                case 4 :
                    if(balance >= 5000){
                        System.out.println("VIP Customer");
                    }else if ( balance >= 1000 )
                    {
                        System.out.println("Regular Customer");
                    }else{
                        System.out.println("Low Balance");
                    }

                    break;

            }


        }while (chose !=5);
        //Exit
        if(chose == 5){
            System.out.println("Successful deposit transactions: " + depositCount);
            System.out.println("Successful withdrawal transactions: " + withdrawCount);
            System.out.println("your current balance: " + balance);
            System.out.println("Thank you for using our ATM.");
        }

    }
}
