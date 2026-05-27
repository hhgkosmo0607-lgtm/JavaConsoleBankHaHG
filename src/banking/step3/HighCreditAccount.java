package banking.step3;

public class HighCreditAccount extends Account{
	String creditRating;
	int highRate;
	
	public HighCreditAccount(String accountNumber, String name, int money, int normalRate, 
			String creditRating) {
		super(accountNumber, name, money, normalRate);
		this.creditRating = creditRating;
		if(creditRating.equals("A")) {
			highRate = 7;
		}
		else if(creditRating.equals("B")) {
			highRate = 4;
		}
		else {
			highRate = 2;
		}
	}
	
	/*
	 Account에서 받아와서 암튼 계산이랄까
	 */
	@Override
	public void deposit(int amount) {
		System.out.println("현재 highRate=" + highRate);
		int balance = getMoney();

		balance = balance
				+ (balance * getNormalRate() / 100)
				+ (balance * highRate / 100)
				+ amount;

		setMoney(balance);
	}
	
	
	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("신용등급> " + creditRating);
		System.out.println("--------------");
	}
	
	


}
