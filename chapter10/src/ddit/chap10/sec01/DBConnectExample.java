package ddit.chap10.sec01;

import java.sql.SQLException;

public class DBConnectExample {

	public static void main(String[] args) {
		DBConnect dbconn = DBConnect.getInstance();
		//dbconn.connect();
		
		//예외 미루기
		try {
			dbconn.connect();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(dbconn.rs != null) try {dbconn.rs.close();} catch(Exception e) {}
			if(dbconn.stmt != null) try {dbconn.stmt.close();} catch(Exception e) {}
			if(dbconn.conn != null) try {dbconn.conn.close();} catch(Exception e) {}
		}
	}

}
