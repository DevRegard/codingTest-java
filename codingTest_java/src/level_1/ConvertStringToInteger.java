package level_1;

/**
 * @codingTest <Problems> 문자열을 정수로 바꾸기 [1-32]
 *
 *	"코딩테스트는 알고리즘과 자료구조를 얼마나 깊게 이해하고 있는가를 판단하는 척도라는 것을 깨닫게 되었다."
 *
 *	matches() -> \\+? {0,4} :
 *	Integer.parseInt() : 문자열을 매개변수로 받으면 Integer형으로 반환
 */
public class ConvertStringToInteger {

	
	public int convertStringToInteger(String s) {
        int answer = 0;
        return answer;
    }
	
	
	
	
	// [솔루션1] 정규표현식을 사용하는 방법, 삼항연산자를 통해 return에서 간결하게 표현
	public int convertStringToInteger_1(String s) {
		return s.matches("\\+?[1-9][0-9]{0,4}") ? 
			       Integer.parseInt(s) : Integer.parseInt(s.replace("-", ""))*-1;
			       
	}
	
	
	
	
	// [솔루션2] Integer.parseInt로 반환한 변수를 그대로 출력하는 방법 (단, 부호가 다른것이 들어가면 오류)
	public int convertStringToInteger_2(String s) {
		int num=Integer.parseInt(s);
        return num;
	}
	
	
	
	
	// [솔루션3] API 사용하지 않고, 순수 알고리즘으로 구현한 방법
	public int convertStringToInteger_3(String s) {
		 boolean Sign = true;
         int result = 0;

         for (int i = 0; i < s.length(); i++) {
             char ch = s.charAt(i);
             if (ch == '-')
                 Sign = false;
             else if(ch !='+')
                 result = result * 10 + (ch - '0');
         }
         return Sign?1:-1 * result;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
