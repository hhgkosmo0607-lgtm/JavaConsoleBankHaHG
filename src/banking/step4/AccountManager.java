package banking.step4;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;

public class AccountManager {
	
	private HashSet<Account> accounts;
	
	public AccountManager(int num) {
		accounts = new HashSet<Account>();
	}
	
	/*
	 입력받고 저장
	 */
	public void makeAccount(int sub) {
		String accountNumber, name, creditRating;
		int money;
		int normalRate;
		
		System.out.println("***신규계좌개설***");
		System.out.println("계좌번호: ");
		accountNumber = BankingSystemMain.sc.nextLine();
		System.out.println("이름: ");
		name = BankingSystemMain.sc.nextLine();
		System.out.println("잔액: ");
		money = BankingSystemMain.sc.nextInt();
		System.out.println("기본이자%(정수형태로입력):"  );
		normalRate = BankingSystemMain.sc.nextInt();
		BankingSystemMain.sc.nextLine(); 
		
		if(sub == 1) {
			NormalAccount normal = new NormalAccount(accountNumber, name, money, normalRate);
			accounts.add(normal);
		}
		
		else if(sub == 2) {
			System.out.println("신용등급(A,B,C등급):" );
			creditRating = BankingSystemMain.sc.nextLine();
			HighCreditAccount high = new HighCreditAccount
					(accountNumber, name, money, normalRate, creditRating);
			accounts.add(high);
		}
		System.out.println("계좌개설이 완료되었습니다");
		
		
	}
	
	/*
	문자입력 불가는 예외처리로 하고
	if money가 음수면 불가
	나누기 500일 때 0인것만 입금 가능
	일탠데 그걸 어캐 집어넣는데..
	 */
	public void depositMoney() throws MenuSelectException {

		System.out.println("***입 금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");

		System.out.print("계좌번호:");
		String accNum = BankingSystemMain.sc.nextLine();

		System.out.print("입금액:");
		try {
			int money = BankingSystemMain.sc.nextInt();
			BankingSystemMain.sc.nextLine();
			
			if(money <= 0) {
			    throw new MenuSelectException("0원 이하는 입금 불가");
			}
			
			if(money % 500 !=0) {
				throw new MenuSelectException("500원 단위로만 입금가능");
			}
			(accounts.contains(accNum) ? true : false)
	
					System.out.println("입금이 완료되었습니다.");
					return;
				}
			}
			 // 계좌 못 찾은 경우
	        throw new MenuSelectException("계좌가 없습니다.");
	    }
	    catch(InputMismatchException e) {

	        BankingSystemMain.sc.nextLine();
	        throw new MenuSelectException("숫자만 입력하세요.");
	    }
		
	}
	
	/*
	money가 0이하면 노출금
	잔고와 출금액 비교
	% 1000 != 0
	
	 */
	public void withdrawMoney() throws MenuSelectException{

	    System.out.println("***출 금***");

	    System.out.print("계좌번호:");
	    String accNum = BankingSystemMain.sc.nextLine();

	    System.out.print("출금액:");

	    try {
	        int money = BankingSystemMain.sc.nextInt();
	        BankingSystemMain.sc.nextLine();

	        if(money <= 0) {
	        	throw new MenuSelectException("0원 이하는 출금 불가");
	        }

	        if(money % 1000 != 0) {
	        	throw new MenuSelectException("1000원 단위만 출금 가능");
	        }

	        for(int i = 0; i < numOfaccounts; i++) {

	            if(accounts[i].getAccNum().equals(accNum)) {

	                int balance = accounts[i].getMoney();

	                if(balance < money) {

	                    System.out.println("잔고가 부족합니다.");
	                    System.out.println("금액전체를 출금할까요?");
	                    System.out.print("YES/NO:");

	                    String answer = BankingSystemMain.sc.nextLine();

	                    if(answer.equalsIgnoreCase("YES")) {

	                        accounts[i].withdraw(balance);

	                        System.out.println("전체금액 출금완료");
	                    }
	                    else {
	                        System.out.println("출금 취소");
	                    }

	                    return;
	                }

	                accounts[i].withdraw(money);

	                System.out.println("출금 완료");
	                return;
	            }
	        }

	        throw new MenuSelectException("계좌가 없습니다.");
	    }
	    catch(InputMismatchException e) {

	        BankingSystemMain.sc.nextLine();
	        throw new MenuSelectException("숫자만 입력하세요.");
	    }
	}
	
	/*
	 전체 나열
	 */
	public void showAccInfo() {

		System.out.println("***계좌정보출력***");

		for(Account acc : accounts) {

			acc.showAccInfo();
		}

		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
	
	public void deleteAccount() {
		
		
		
	
	}
}
