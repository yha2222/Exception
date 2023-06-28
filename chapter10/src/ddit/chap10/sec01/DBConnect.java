package ddit.chap10.sec01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	//한 사람당 한번만 커넥트-싱글톤 패턴=>해당 클래스 타입 정적 변수로 instance 만들고 null값 설정
	//자원 할당 여러 개 => stack 모자라서 오류 발생 가능성 높음 => 방지 => 싱글톤
	private static DBConnect instance=null;
	private DBConnect() {}
	//외부에서 먼저 부를 부분 => static
	public static DBConnect getInstance() {
		if(instance == null) instance = new DBConnect(); //본인 클래스 타입
		return instance;
	}
	
	//상수 변수 다 가능
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "pc22";
	private String passwd = "java";
	
	//클래스 변수 선언
	 Connection conn = null;
	 Statement stmt = null;
	 ResultSet rs = null;
	
	public void connect() throws SQLException, Exception{
		//try {
			conn = DriverManager.getConnection(url, user, passwd); //getConnection=>싱글톤
			String sql = "select * from EMPP"; //쿼리 생성
			stmt = conn.createStatement(); //정적
			rs = stmt.executeQuery(sql); //sql 실행 결과 => rs
			while(rs.next()) {
				//컬럼 읽어와서 변수에 넣기
				//컬럼명-문자열(VARCHAR2...) => getString
				String empNo = rs.getString("EMPID");
				String eName = rs.getString("NAME");
				String dept = rs.getString("DEPT");
				String tel = rs.getString("JOB");
				int salary = rs.getInt("SALARY");
				String address = rs.getString("ADDRESS");
				
				//불러온 거 인쇄
				System.out.println(empNo+"  "+eName+"  "+
						dept+"\t"+tel+"\t"+salary+"\t"+address);
			}
		//}catch(SQLException e) {  //SQLException 오류 발생 시 
		//	e.printStackTrace();
		//}catch(Exception e) {     //두 개 안나와도 상관은 없음
		//	e.printStackTrace();
			//finally 오류 나든 안 나든 무조건 처리되어야 하는 거
		//}finally {  //null 아님 => 결과 들어와서 처리함
		//	if(rs != null) try {rs.close();}catch(Exception e) {} //close 오류 시
			//명령어 객체 생성 오픈된 거 닫기
		//	if(stmt != null) try {stmt.close();}catch(Exception e) {}
			//연결 설정 됐던 거 반드시 닫아주기 => 안 닫아주면 다음 DB 연결 안됨
		//	if(conn != null) try {conn.close();}catch(Exception e) {}
		//}
 }
}
