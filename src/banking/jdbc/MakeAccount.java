package banking.jdbc;

import java.sql.SQLException;

public class MakeAccount extends MyConnection{

	public MakeAccount(String user, String pass) {
		super(user, pass);
	}
	
	String query;
	int result;
	
	@Override
	public void dbExecute() {
		try {
			query = "INSERT INTO banking VALUE "
					+ "(?,?,?,?,?) ";
			psmt = con.prepareStatement(query);
			psmt.setString(1, inputValue("일련번호"));
			psmt.setString(2, inputValue("계좌번호"));
			psmt.setString(3, inputValue("이름"));
			psmt.setString(4, inputValue("잔액"));
			psmt.setString(5, inputValue("이자율"));
			result = psmt.executeUpdate();
			System.out.println("[psmt]" + result + "행 입력됨");
		} 
		catch (SQLException e) {
			System.out.println("입력오류");
			e.printStackTrace();
		}
	}
	

}
