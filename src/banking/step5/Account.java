package banking.step5;

import java.io.Serializable;

public class Account implements Serializable{
	
	private String accountNumber;
	private String name;
	private int money;
	private int normalRate;

	

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getNormalRate() {
		return normalRate;
	}

	public void setNormalRate(int normalRate) {
		this.normalRate = normalRate;
	}

	public Account(String accountNumber, String name, int money, int normalRate) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.money = money;
		this.normalRate = normalRate;
	}

	public void showAccInfo() {

		System.out.println("--------------");
		System.out.println("계좌번호> " + accountNumber);
		System.out.println("고객이름> " + name);
		System.out.println("잔고>" + money);
		System.out.println("기본이자%(정수형태로입력)>" + normalRate);
		
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
	
	@Override
	public int hashCode() {
		return accountNumber.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		Account accObj = (Account)obj;
		return(accountNumber.equals(accObj.accountNumber));
	}
	
}