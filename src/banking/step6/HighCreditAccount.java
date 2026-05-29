package banking.step6;

public class HighCreditAccount extends Account{
	String creditRating;
	int highRate;
	
	public HighCreditAccount(String accountNumber, String name, int money, int normalRate, 
			String creditRating) {
		super(accountNumber, name, money, normalRate);
		this.creditRating = creditRating;
		if(creditRating.equalsIgnoreCase("A")) {
			highRate = ICustomDefine.A;
		}
		else if(creditRating.equalsIgnoreCase("B")) {
			highRate = ICustomDefine.B;
		}
		else if(creditRating.equalsIgnoreCase("C")) {
			highRate = ICustomDefine.C;
		}
	}
	
	/*
	 Account에서 받아와서 암튼 계산이랄까
	 */
	@Override
	public void deposit(int amount) {
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
