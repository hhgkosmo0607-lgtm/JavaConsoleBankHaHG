package banking.step1;

public class Account {
	
	private String accountNumber;
	private String name;
	private int money;

	public Account(String accountNumber, String name, int money) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.money = money;
	}

	public void showAccInfo() {

		System.out.println("--------------");
		System.out.println("계좌번호 : " + accountNumber);
		System.out.println("고객이름 : " + name);
		System.out.println("잔고 : " + money);
		System.out.println("--------------");
	}

	public String getAccNum() {
		return accountNumber;
	}

	public void deposit(int amount) {
		money += amount;
	}

	public void withdraw(int amount) {
		money -= amount;
	}
}