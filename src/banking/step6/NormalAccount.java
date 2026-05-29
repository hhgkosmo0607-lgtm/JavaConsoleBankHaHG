package banking.step6;

public class NormalAccount extends Account{

	public NormalAccount(String accountNumber, String name, int money, int normalRate) {
		super(accountNumber, name, money, normalRate);
	}
	
	
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
