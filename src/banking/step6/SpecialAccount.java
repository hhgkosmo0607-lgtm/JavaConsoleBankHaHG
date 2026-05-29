package banking.step6;

/*
 자 생각이란걸 해보자
 노말이랑 계산식을 똑같이 가고
 홀수 짝수 조건을 걸어서 짝수는 +500
 몇회차 입금은 어캐알지?
 플러스 변동이 있으면 입금인줄 알 수 있잖아
 디파짓이 실행될 때 카운트하는 변수
 */

public class SpecialAccount extends NormalAccount {
	
	int depCount = 0;
	
	public SpecialAccount(String accountNumber, String name, int money, int normalRate) {
		super(accountNumber, name, money, normalRate);
	}
	
	@Override
	public void deposit(int amount) {
		depCount++;
		
		int balance = getMoney();

		balance = balance
				+ (balance * getNormalRate() / 100)
				+ amount;
		if(depCount % 2 == 0) {
			balance += 500;
		}

		setMoney(balance);
		
		System.out.println("입금횟수:" + depCount);
		
	}
	
	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("--------------");
	}

	
	
}
