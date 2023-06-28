package ddit.chap10.sec02;
//사용자 정의 예외클래스 생성
// 일반예외클래스 - Exception 클래스 상속
// 실행예외클래스 - RuntimeException 클래스 상속
public class ExceptionExample02 {

	public static void main(String[] args) {
		new ExceptionExample02().start();
	}
	
	void start() {
		try {
			throw new MyException("나의 전용 예외클래스");
		}catch(Exception e) {
			e.printStackTrace(); //호출 스택 예외
		}
	}

}

class MyException extends Exception{
	MyException(){}
	
	MyException(String message){
		super(message);
	}
}
