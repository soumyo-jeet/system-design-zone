interface  Account {
    void deposit(int amt);
    void withdraw(int amt);
    void printBalance();
}

class SavingsAccount implements  Account {
    int balance;

    public SavingsAccount() {
        balance = 0;
    }

    @Override
    public void deposit (int amt) {
        this.balance += amt;
        System.out.println("Deposited");
    }

    @Override
    public void withdraw(int amt) {
        this.balance -= amt;
        System.out.println("Withdrawn");
    }

    @Override
    public void printBalance() {
        System.out.println("current balance: " + this.balance);
    }
    
}


class FixedAccount implements  Account {
    int balance;

    public FixedAccount() {
        balance = 0;
    }

    @Override
    public void deposit (int amt) {
        this.balance += amt;
        System.out.println("Deposited");
    }

    @Override
    public void withdraw(int amt) {
        System.out.println("Error!!"); 
        // LSP broke -> if we substitute Acc with FD we may get error with a method
    }

    @Override
    public void printBalance() {
        System.out.println("current balance: " + this.balance);
    }
    
}


class LSP_violated {
    public static void main (String [] args) {
        Account acc = new SavingsAccount(); // this is exactly what LSP tells
        acc.deposit(50); 
        acc.printBalance();
    }
}