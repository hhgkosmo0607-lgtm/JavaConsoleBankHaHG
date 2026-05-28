package banking.step4T;

import java.util.HashSet;
import java.util.InputMismatchException;


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
		/*
		 자 계좌번호 입력받고
		 원래 있던 계좌 쫙 돌리고 검색하고
		 y or n 에 따른 기능 만들면 될듯?
		 덮어쓴다는게 뭘까..
		 지우고 새로 생성과 같은거 아닐까
		 그러면 지우는걸 먼저 만들자
		 어쩌다보니 했는데 return을 저렇게 쓰는게 맞나
		 그냥 허전하니 쓰긴 했는데
		 자 다음
		 계좌번호 13자리수로 정해놓고 나머지는 다 오류로 처리해보자
		 근데 자리수를 어캐 정함? 모르겠다 다음기회에
		 문자입력시에는 숫자로 입력하세요 추가
		 아니 잠만 그러면 하나하나에 다 저 if를 달아야함? 한번에 못하나
		 */
		System.out.println("계좌번호: ");
		accountNumber = BankingSystemMain.sc.nextLine();
//		Account findAcc = searchAccount(accountNumber);
//		if(findAcc != null) {
//			System.out.println("중복계좌발견됨. 덮어쓸까요?(Y or N)");
//			String answer = BankingSystemMain.sc.nextLine();
//			if(answer.equalsIgnoreCase("y")) {
//				accounts.remove(findAcc);
//			}else if(answer.equalsIgnoreCase("n")){
//				return;
//			}else {
//				System.out.println("잘못된 입력입니다.");
//				return;
//			}
//		}
		System.out.println("이름: ");
		name = BankingSystemMain.sc.nextLine();
		System.out.println("잔액: ");
		money = BankingSystemMain.sc.nextInt();
		System.out.println("기본이자%(정수형태로입력):"  );
		normalRate = BankingSystemMain.sc.nextInt();
		BankingSystemMain.sc.nextLine(); 
		
		if(sub == 1) {
			NormalAccount normal = new NormalAccount(accountNumber, name, money, normalRate);
			//System.out.println("추가결과:"+accounts.add(normal));
			boolean addYN = accounts.add(normal);
			if(addYN==false) {
				//질문?
				System.out.println("중복되었다? 어떻게하까?");
				//입력받음 
				String answer = BankingSystemMain.sc.nextLine();
				if(answer.equalsIgnoreCase("y")) { 
					//Y를 입력하면 덮어쓰기
					accounts.remove(normal);
					accounts.add(normal);
				}
			}
		}		
		else if(sub == 2) {
			System.out.println("신용등급(A,B,C등급):" );
			creditRating = BankingSystemMain.sc.nextLine();
			HighCreditAccount high = new HighCreditAccount
					(accountNumber, name, money, normalRate, creditRating);
			
			System.out.println("추가결과:"+accounts.add(high));
		}
		
		System.out.println("계좌개설이 완료되었습니다");
	}
	
	/*
	자 컬렉션을 돌려서 검색하고 일치하면 입금
	나머지는 뭐 그대로
	근데 어캐하는건데
	근데 순서가 계좌번호 비교가 먼저되야되지 않나
	검색 메소드를 따로 빼놓고 불러와서 사용하기만 
	 */
	public Account searchAccount(String accNum) {

	    for(Account acc : accounts) {

	        if(acc.getAccNum().equals(accNum)) {
	            return acc;
	        }
	    }

	    return null;
	}
	
	public void depositMoney() throws MenuSelectException {

	    System.out.println("***입 금***");

	    System.out.print("계좌번호:");
	    String accNum = BankingSystemMain.sc.nextLine();

	    Account findAcc = searchAccount(accNum);

	    if(findAcc == null) {
	        throw new MenuSelectException("계좌가 없습니다.");
	    }

	    System.out.print("입금액:");

	    try {
	        int money = BankingSystemMain.sc.nextInt();
	        BankingSystemMain.sc.nextLine();

	        if(money <= 0) {
	            throw new MenuSelectException("0원 이하는 입금 불가");
	        }

	        if(money % 500 != 0) {
	            throw new MenuSelectException("500원 단위만 입금 가능");
	        }

	        findAcc.deposit(money);

	        System.out.println("입금 완료");
	    }
	    catch(InputMismatchException e) {

	        BankingSystemMain.sc.nextLine();

	        System.out.println("숫자만 입력하세요.");
	        return;
	    }
	}
	
	/*
	입금과 동일한데 Account에서 money를 받아오는것만 추가하면되는데
	컬렉션으로 어캐하는데
	 */
	public void withdrawMoney() throws MenuSelectException{

	    System.out.println("***출 금***");

	    System.out.print("계좌번호:");
	    String accNum = BankingSystemMain.sc.nextLine();
	    
	    Account findAcc = searchAccount(accNum);
	    if(findAcc == null) { 
	    	throw new MenuSelectException("계좌가 없습니다.");
	    }

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

	        int balance = findAcc.getMoney();

	        if(balance < money) {
	        	System.out.println("잔고가 부족합니다.");
	        	System.out.println("금액전체를 출금할까요?");
	        	System.out.print("YES/NO:");

	        	String answer = BankingSystemMain.sc.nextLine();

	        	if(answer.equalsIgnoreCase("YES")) {
		        	findAcc.withdraw(balance);
		        	System.out.println("전체금액 출금완료");
            	}
        		else {
                   System.out.println("출금 취소");
                }
            	//return;
        	}
	        else {
	        	findAcc.withdraw(money);
	        	System.out.println("출금 완료");
	        	//return;
	        }
	    }
	    catch(InputMismatchException e) {
	        BankingSystemMain.sc.nextLine();
	        System.out.println("숫자만 입력하세요");
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
	
	//삭제하라
	public void deleteAccount() {
		System.out.println("계좌번호를 입력해주세요");
		String accNum = BankingSystemMain.sc.nextLine();
		Account findAcc = searchAccount(accNum);
		if(findAcc == null) {
			System.out.println("존재하지 않는 계좌번호입니다");
		}
		else {
			System.out.println("삭제합니다");
			accounts.remove(findAcc);
		}
	}
}
