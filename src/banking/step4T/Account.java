package banking.step4T;

public class Account {
	
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
	
	
	//중복제거를 위한 오버라이딩
	@Override
	public int hashCode() {
		System.out.println("해시코드 호출");
		//인스턴스가 가진 해시값(참조값을 숫자로 반환)을 비교
		return accountNumber.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("이퀄스 호출");
		//인스턴스가 가진 내용에 대한 비교 
		Account accObj = (Account) obj; 
		if(accountNumber.equals(accObj.accountNumber))
			return true;
		else
			return false; 
	}
}


