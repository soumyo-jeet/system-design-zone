interface  WOWAccount {
    void deposit(int amt);
    void printBalance();
}

interface  WWAccount {
    void deposit(int amt);
    void withdraw(int amt);
    void printBalance();
}

class SavingsAccount implements  WWAccount { // since saving acc has withdraw functionality
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


class FixedAccount implements  WOWAccount { // since saving acc has no withdraw functionality
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
    public void printBalance() {
        System.out.println("current balance: " + this.balance);
    }
    
}


class LSP_followed {
    public static void main (String [] args) {
        // this are exactly what LSP tells
        WWAccount acc1 = new SavingsAccount(); 
        WOWAccount acc2 = new FixedAccount(); 

        acc1.deposit(80);
        acc1.withdraw(20);
        acc1.printBalance();

        acc2.deposit(80);
        acc2.printBalance();
    }
} 