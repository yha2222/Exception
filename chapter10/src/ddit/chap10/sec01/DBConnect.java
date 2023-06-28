package ddit.chap10.sec01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	//�� ����� �ѹ��� Ŀ��Ʈ-�̱��� ����=>�ش� Ŭ���� Ÿ�� ���� ������ instance ����� null�� ����
	//�ڿ� �Ҵ� ���� �� => stack ���ڶ� ���� �߻� ���ɼ� ���� => ���� => �̱���
	private static DBConnect instance=null;
	private DBConnect() {}
	//�ܺο��� ���� �θ� �κ� => static
	public static DBConnect getInstance() {
		if(instance == null) instance = new DBConnect(); //���� Ŭ���� Ÿ��
		return instance;
	}
	
	//��� ���� �� ����
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "pc22";
	private String passwd = "java";
	
	//Ŭ���� ���� ����
	 Connection conn = null;
	 Statement stmt = null;
	 ResultSet rs = null;
	
	public void connect() throws SQLException, Exception{
		//try {
			conn = DriverManager.getConnection(url, user, passwd); //getConnection=>�̱���
			String sql = "select * from EMPP"; //���� ����
			stmt = conn.createStatement(); //����
			rs = stmt.executeQuery(sql); //sql ���� ��� => rs
			while(rs.next()) {
				//�÷� �о�ͼ� ������ �ֱ�
				//�÷���-���ڿ�(VARCHAR2...) => getString
				String empNo = rs.getString("EMPID");
				String eName = rs.getString("NAME");
				String dept = rs.getString("DEPT");
				String tel = rs.getString("JOB");
				int salary = rs.getInt("SALARY");
				String address = rs.getString("ADDRESS");
				
				//�ҷ��� �� �μ�
				System.out.println(empNo+"  "+eName+"  "+
						dept+"\t"+tel+"\t"+salary+"\t"+address);
			}
		//}catch(SQLException e) {  //SQLException ���� �߻� �� 
		//	e.printStackTrace();
		//}catch(Exception e) {     //�� �� �ȳ��͵� ����� ����
		//	e.printStackTrace();
			//finally ���� ���� �� ���� ������ ó���Ǿ�� �ϴ� ��
		//}finally {  //null �ƴ� => ��� ���ͼ� ó����
		//	if(rs != null) try {rs.close();}catch(Exception e) {} //close ���� ��
			//��ɾ� ��ü ���� ���µ� �� �ݱ�
		//	if(stmt != null) try {stmt.close();}catch(Exception e) {}
			//���� ���� �ƴ� �� �ݵ�� �ݾ��ֱ� => �� �ݾ��ָ� ���� DB ���� �ȵ�
		//	if(conn != null) try {conn.close();}catch(Exception e) {}
		//}
 }
}
