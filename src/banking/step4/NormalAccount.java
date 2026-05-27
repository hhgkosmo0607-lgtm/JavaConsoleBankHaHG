package banking.step4;

public class NormalAccount extends Account{

	public NormalAccount(String accountNumber, String name, int money, int normalRate) {
		super(accountNumber, name, money, normalRate);
	}
	
	/*
	 Account에서 받아와서 암튼 계산인데 어캐하는건데..
	 */
	@Override
	public void deposit(int amount) {

		int balance = getMoney();

		balance = balance
				+ (balance * getNormalRate() / 100)
				+ amount;

		setMoney(balance);
	}
	
	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("--------------");
	}
	
	
}
