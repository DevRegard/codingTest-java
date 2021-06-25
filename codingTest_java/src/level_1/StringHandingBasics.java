package level_1;

/**
 * @codingTest <Problems> 문자열 다루기 기본 [1-28]
 *
 *	matches() : 인자로 정규표현식을 받음. 문자열과 패턴이 일치하는지 리턴
 *	matches("^[0-9]*$") : ^는 시작, [0-9]는 모든 숫자, $*은 0개 이상의 글자로 끝
 *	
 */
public class StringHandingBasics {

	
	public boolean stringHandingBasics(String s) {
		boolean answer = true;
        return answer;
    }
	
	
	
	
	// [솔루션1] 정규식표현을 사용한 방법, matches()
	public boolean stringHandingBasics_1(String s) {
		 if (s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");
	        return false;
	}
	
	
	
	
	// [솔루션2] try-catch문을 사용한 방법
	public boolean stringHandingBasics_2(String s) {
		if(s.length() == 4 || s.length() == 6){
			try{
				int x = Integer.parseInt(s);
				return true;
			} catch(NumberFormatException e){
				return false;
			}
		}
		else return false;
	}
	
	
	
	
	// [솔루션3] 정규표현식을 사용하지 않는 방법, 삼항연산자를 사용하여 한줄로 간결히 표현
	public boolean stringHandingBasics_3(String s) {
		return (s.length() != 4 && s.length() != 6) || (s.split("[0-9]").length > 0) ? false:true;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
