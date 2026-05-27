package banking.step4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystemMain implements ICustomDefine {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("ver05");
		System.out.println("-----Menu------");
		System.out.println("1.계좌계설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.계좌정보삭제");
		System.out.println("6.프로그램종료");
	}
	
	//github 연동
	//연동완료 후 커밋&푸시
	public static void main(String[] args) {
		
		AccountManager manager = new AccountManager(50);
		
		while(true) {
			
			try {
				showMenu();
				int sel = sc.nextInt();
				if(sel < 1 || sel >5) {
					throw new MenuSelectException("1~5까지의 숫자만 입력하세요");
				}
				sc.nextLine();
				switch(sel) {
				case MAKE:
					System.out.println("-----계좌선택-----");
					System.out.println("1.보통계좌");
					System.out.println("2.신용신뢰계좌");
					int sub = sc.nextInt();
					sc.nextLine();
					switch(sub) {
					case 1:
						manager.makeAccount(sub);
						break;
					case 2:
						manager.makeAccount(sub);
						break;
					}
					break;
				case DEPOSIT:
					manager.depositMoney();
					break;
				case WITHDRAW:
					manager.withdrawMoney();
					break;
				case INQUIRE:
					manager.showAccInfo();
					break;
				case DELETE:
					manager.deleteAccount();
				case EXIT:
					System.out.println("프로그램종료");
					return;
				
				}
			}
			catch(MenuSelectException e) {
	            System.out.println(e.getMessage());
	        }
	        catch(InputMismatchException e) {

	            System.out.println("숫자만 입력하세요.");
	            sc.nextLine();
		
	        }
			
		}
		
		
	}
}

