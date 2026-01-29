abstract class BankAccount {
    double balance = 0;

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        balance -= amount;
    }

    abstract void showDetails();
}
class SavingsAccount extends BankAccount {

    void applyInterest() {
        balance += balance * 0.02;
    }

    @Override
    void showDetails() {
        System.out.println("Savings Balance: " + balance);
    }
}
class CheckingAccount extends BankAccount {

    @Override
    void withdraw(double amount) {
        balance -= amount;
        System.out.println("Overdraft allowed");
    }

    @Override
    void showDetails() {
        System.out.println("Checking Balance: " + balance);
    }
}
class Task {

    public static void main(String[] args) {

        BankAccount[] accounts = new BankAccount[2];

        accounts[0] = new SavingsAccount();
        accounts[1] = new CheckingAccount();

        accounts[0].deposit(200);
        accounts[1].withdraw(100);

        ((SavingsAccount) accounts[0]).applyInterest();

        for (BankAccount acc : accounts) {
            acc.showDetails();
        }
    }
}
