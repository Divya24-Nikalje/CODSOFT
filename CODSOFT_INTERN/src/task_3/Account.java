package task_3;

public class Account {

	    private double balance;

	    public Account(double initialBalance) {
	        if (initialBalance >= 0) {
	            this.balance = initialBalance;
	        } else {
	            this.balance = 0;
	        }
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	        }
	    }

	    public boolean withdraw(double amount) {
	        if (amount > 0 && amount <= balance) {
	            balance -= amount;
	            return true;
	        }
	        return false;
	    }
	}
