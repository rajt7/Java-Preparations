import java.util.Scanner;

class AccountHolder{
    private long accNo;
    private String name;
    private double balance;

    public AccountHolder(long no, String name, double balance){
        this.accNo = no;
        this.name = name;
        this.balance = balance;
    }
    
    public long getAccNo() {
        return accNo;
    }
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        balance =  balance + amount;
    }

    public void withdraw(double amount){
        balance = balance - amount;
    }
    @Override
    public String toString() {
        return "AccountHolder [accNo=" + accNo + ", name=" + name + ", balance=" + balance + "]";
    }
}


public class Account {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        AccountHolder[] accounts = new AccountHolder[10];
        int choice=0, noOfAccountsCreated=0;

        while(choice != 5){
            System.out.println("Menu\n" + 
                    "1. Add record for account holder.\n" + 
                    "2. Display all accounts.\n" + 
                    "3. Deposit an amount into particular amount.\n" + 
                    "4. Withdraw an amount into particular amount.\n" + 
                    "5. Exit\n");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter your account number: ");
                    long no = sc.nextLong();
                    System.out.println("Enter your account name: ");
                    String name = sc.next();
                    System.out.println("Enter your account balance: ");
                    double balance = sc.nextDouble();
                    accounts[noOfAccountsCreated] = new AccountHolder(no, name, balance);
                    noOfAccountsCreated++;
                    break;
                case 2:
                    for(int i=0; i<noOfAccountsCreated; i++){
                        System.out.println(accounts[i]);
                    }
                    break;
                case 3:
                    System.out.println("Enter your account number: ");
                    long accNo = sc.nextLong();
                    for(int i=0; i<noOfAccountsCreated; i++){
                        if(accounts[i].getAccNo() == accNo){
                            System.out.println(accounts[i]);
                            System.out.println("Enter the deposit amount: ");
                            double amount = sc.nextDouble();
                            accounts[i].deposit(amount);
                        }
                        else{
                            System.out.println("Enter valid account number.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter your account number: ");
                    long accNo1 = sc.nextLong();
                    for(int i=0; i<noOfAccountsCreated; i++){
                        if(accounts[i].getAccNo() == accNo1){
                            System.out.println("Enter the withdraw amount: ");
                            double amount = sc.nextDouble();
                            accounts[i].withdraw(amount);
                        }
                        else{
                            System.out.println("Enter valid account number.");
                        }
                    }
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Wrong Choice....");
            }
        }
        sc.close();
    }
    
}
