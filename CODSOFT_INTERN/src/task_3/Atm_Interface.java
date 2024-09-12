package task_3;

public class Atm_Interface {

	    public static void main(String[] args) {
	        
	        Account account = new Account(1000.00);
	        ATM atm = new ATM(account);

	        atm.showMenu();
	    }
	}

