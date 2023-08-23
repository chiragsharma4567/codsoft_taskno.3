import java.util.*;
public class atminterface_task3 
{
    public static void main(String[] args)
     {
        ATM atm = new ATM();
        atm.start();
    }
}


class UserBankAccount {
    private double currentBalance;

    public UserBankAccount(double initialBalance) {
        this.currentBalance = initialBalance;
    }

    public double getBalance() {
        return currentBalance;
    }

    public void deposit(double amount) {
        currentBalance = currentBalance + amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= currentBalance) {
            currentBalance = currentBalance - amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM {
    private UserBankAccount ATMBankAccount;
    private Scanner scanner;
    public ATM() {
        ATMBankAccount = new UserBankAccount(1000);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            displayMenu();
            int ch = scanner.nextInt();
            scanner.nextLine(); 

            switch (ch) {
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
                    exit();
                    return;
                default:
                    System.out.println("!!!!!!!Invalid choice. Please try again.!!!!!!!");
            }
        }
    }

    private void displayMenu() {
        System.out.println("----Displaying the ATM Menu----");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private void deposit() {
        System.out.print("Enter the deposit amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 

        ATMBankAccount.deposit(amount);
        System.out.println("Deposit successful. New balance is:-> " + ATMBankAccount.getBalance());
    }

    private void withdraw() {
        System.out.print("Enter the withdrawal amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (ATMBankAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance is:-> " + ATMBankAccount.getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void checkBalance() {
        System.out.println("Current balance is : " + ATMBankAccount.getBalance());
    }

    private void exit() {
        System.out.println("Thank you for using the ATM. PLEASE VISIT AGAIN");
    }
}