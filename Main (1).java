abstract class BankAccount {

    private final String accountNumber;
    private final String accountHolderName;
    private double balance;

    BankAccount(String accNo, String name) {
        accountNumber = accNo;
        accountHolderName = name;
        balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    abstract String getAccountDetails();
}
class SavingsAccount extends BankAccount {

    SavingsAccount(String accNo, String name) {
        super(accNo, name);
    }

    @Override
    public String getAccountDetails() {
        return "Account: " + getAccountNumber() + ", Holder: " + getAccountHolderName() + ", Balance: " + getBalance();
    }
}
class Main {
    public static void main(String[] args) {

        SavingsAccount acc = new SavingsAccount("101", "Sonam");

        acc.deposit(1000);
        acc.withdraw(300);

        System.out.println(acc.getAccountDetails());
    }
}
