package banking.step1;

public class AccountManager {
	
	private Account[] accounts;
	private int numOfaccounts;
	
	

	public AccountManager(int num) {
		accounts = new Account[num];
		numOfaccounts = 0;
	
	}
	
	/*
	 입력받고 저장
	 */
	public void makeAccount() {
		String accountNumber, name;
		int money;
		System.out.println("***신규계좌개설***");
		System.out.println("계좌번호");
		accountNumber = BankingSystemMain.sc.nextLine();
		System.out.println("이름");
		name = BankingSystemMain.sc.nextLine();
		System.out.println("잔액");
		money = BankingSystemMain.sc.nextInt();
		System.out.println("계좌개설이 완료되었습니다");
		Account ac = new Account(accountNumber, name, money);
		accounts[numOfaccounts++] = ac;
		
	}
	
	/*
	 자 입금을 해야되는건데 
	 계좌번호로 검색하고
	 돈 입력하면 기존 돈에 더하고
	 */
	public void depositMoney() {

		System.out.println("***입 금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");

		System.out.print("계좌번호:");
		String accNum = BankingSystemMain.sc.nextLine();

		System.out.print("입금액:");
		int money = BankingSystemMain.sc.nextInt();
		BankingSystemMain.sc.nextLine();

		for (int i = 0; i < numOfaccounts; i++) {

			if (accounts[i].getAccNum().equals(accNum)) {

				accounts[i].deposit(money);

				System.out.println("입금이 완료되었습니다.");
			}
		}
	}
	
	/*
	 계좌번호로 검색하고
	 돈 입력하면 빼기
	 */
	public void withdrawMoney() {

		System.out.println("***출 금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");

		System.out.print("계좌번호:");
		String accNum = BankingSystemMain.sc.nextLine();

		System.out.print("출금액:");
		int money = BankingSystemMain.sc.nextInt();
		BankingSystemMain.sc.nextLine();

		for (int i = 0; i < numOfaccounts; i++) {

			if (accounts[i].getAccNum().equals(accNum)) {

				accounts[i].withdraw(money);

				System.out.println("출금이 완료되었습니다.");
			}
		}
	}
	
	/*
	 전체 나열
	 */
	public void showAccInfo() {
		System.out.println("***계좌정보출력***");
		for(int i=0; i<numOfaccounts; i++) {
			accounts[i].showAccInfo();	
		}
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
		
	}
	
	
	
	

}
