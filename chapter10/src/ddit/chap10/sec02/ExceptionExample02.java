package ddit.chap10.sec02;
//����� ���� ����Ŭ���� ����
// �Ϲݿ���Ŭ���� - Exception Ŭ���� ���
// ���࿹��Ŭ���� - RuntimeException Ŭ���� ���
public class ExceptionExample02 {

	public static void main(String[] args) {
		new ExceptionExample02().start();
	}
	
	void start() {
		try {
			throw new MyException("���� ���� ����Ŭ����");
		}catch(Exception e) {
			e.printStackTrace(); //ȣ�� ���� ����
		}
	}

}

class MyException extends Exception{
	MyException(){}
	
	MyException(String message){
		super(message);
	}
}
