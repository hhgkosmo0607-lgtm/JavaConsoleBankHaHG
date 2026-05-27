package banking.step1;

import java.util.Scanner;

public class BankingSystemMain {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("ver01");
		System.out.println("-----Menu------");
		System.out.println("1.계좌계설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.프로그램종료");
	}
	
	
	public static void main(String[] args) {
		
		AccountManager manager = new AccountManager(50);
		while(true) {
			showMenu();
			int sel = sc.nextInt();
			sc.nextLine();
			switch(sel) {
			case 1:
				manager.makeAccount();
				break;
			case 2:
				manager.depositMoney();
				break;
			case 3:
				manager.withdrawMoney();
				break;
			case 4:
				manager.showAccInfo();
				break;
			case 5:
				System.out.println("프로그램종료");
				return;
			}
		}
	}
}
