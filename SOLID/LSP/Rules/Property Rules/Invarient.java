// Invarient : balance of this class should never be < 0
class Account {
    int balance;

    public Account() {
        balance = 0;
    }

    public void deposit (int amt) {
        this.balance += amt;
        System.out.println("Deposited");
    }

    public void withdraw(int amt) {
        if(this.balance - amt < 0) {
            System.out.println("You have sufficient amount to withdraw.");
        }
        this.balance -= amt;
        System.out.println("Withdrawn");
    }

    public void printBalance() {
        System.out.println("current balance: " + this.balance);
    }
}


// Breaks the invarient of the parent  --> breaks LSP
class CheatAccount extends Account {
    @Override
    public void withdraw(int amt) {
        this.balance -= amt;
        System.out.println("Withdrawn");
    }
}

public class Invarient {
    public static void main(String[] args) {
        Account acc = new CheatAccount();
        acc.deposit(50);
        acc.printBalance();
    }
}
