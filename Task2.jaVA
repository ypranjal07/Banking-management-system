abstract class BankAccount {

    protected double balance;

    BankAccount() {
        balance = 0;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void withdraw(double amount) {
        balance = balance - amount;
    }

    abstract String getAccountDetails();
}
class SavingsAccount extends BankAccount {

    private double interestRate;

    SavingsAccount(double rate) {
        interestRate = rate;
    }

    public void applyInterest() {
        balance = balance + (balance * interestRate);
    }

    public String getAccountDetails() {
        return "Savings Account Balance: " + balance;
    }
}
class CheckingAccount extends BankAccount {

    private double overdraftLimit;

    CheckingAccount(double limit) {
        overdraftLimit = limit;
    }

    public void withdraw(double amount) {
        if (balance - amount >= -overdraftLimit) {
            balance = balance - amount;
        }
    }

    public String getAccountDetails() {
        return "Checking Account Balance: " + balance;
    }
}
class Task2 {
    public static void main(String[] args) {

        SavingsAccount s = new SavingsAccount(0.02);
        s.deposit(1000);
        s.applyInterest();
        System.out.println(s.getAccountDetails());

        CheckingAccount c = new CheckingAccount(500);
        c.deposit(200);
        c.withdraw(250);
        System.out.println(c.getAccountDetails());
    }
}
