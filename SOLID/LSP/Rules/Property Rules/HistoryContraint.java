// Constraint : Withdraw is allowed
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


// Breaks the constraint of the parent  --> breaks LSP --> FD cant be a child of acc
class FixedAccount extends Account {
    @Override
    public void withdraw(int amt) {
        System.out.println("Error!!");
    }
}

public class HistoryContraint {
    public static void main(String[] args) {
        Account acc = new FixedAccount();
        acc.deposit(50);
        acc.printBalance();
    }
}
