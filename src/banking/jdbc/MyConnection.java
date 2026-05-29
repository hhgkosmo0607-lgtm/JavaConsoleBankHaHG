package banking.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MyConnection implements IConnect {
	
	static Scanner sc = new Scanner(System.in);
	
	private static final String USER = "education";
	private static final String PASS = "1234";
	
	public Connection con; 
	public ResultSet rs; 
	public PreparedStatement psmt; 
	public CallableStatement csmt; 
		
	public MyConnection() {
		try {
			Class.forName(ORACLE_DRIVER);
			con = DriverManager.getConnection(ORACLE_URL, USER, PASS);
		} catch (Exception e) {
			System.out.println("DB커넥션 에러");
			e.printStackTrace();
		}
	}
	
	@Override
	public void dbExecute() {}
	
	@Override
	public void dbClose() {
		try {
			if(con!=null) con.close();
			if(rs!=null) rs.close();
			if(psmt!=null) psmt.close();
			if(csmt!=null) csmt.close();
			System.out.println("DB 자원 반납");
		} catch (Exception e) {
			System.out.println("DB 자원 반납시 에러발생");
			e.printStackTrace();
		}
	}
	
	@Override
	public String inputValue(String title) {
		System.out.print(title + "을(를) 입력(exit->종료):");
		String inputStr = sc.nextLine();
		if("EXIT".equalsIgnoreCase(inputStr)) {
			System.out.println("프로그램을 종료합니다.");
			dbClose();
			System.exit(0);
		}
		return inputStr;
	}		
}
