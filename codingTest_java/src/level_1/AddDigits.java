package level_1;

/**
 * @codingTest <Problems> 자릿수 더하기 [1-36]
 *
 *	String.valueOf() : 매개변수의 값을 String으로 반환한다. [래퍼(wrapper) 객체로 필요시]
 *	Integer.parseInt() : 문자열 매개변수로 받고  Integer형으로 반환한다. [원시데이터 int 타입필요시]
 *	str.substring(시작 인덱스, 종료 인덱스) : 시작 부터 종료 인덱스를 자른다
 */
public class AddDigits {

	
	public int addDigits(int n) {
        int answer = 0;
        return answer;
    }
	
	
	
	
	// [솔루션1] 'n % 10' 으로 각 자리의 나머지를 구하고 더하는 방법 <정수 나눗셈>
	public int addDigits_1(int n) {
		int sum = 0 ; // @1
		while(n != 0) {
			sum += n%10; // @2
			n /= 10; // @3
		}
		
		return sum;
	}
	
	
	
	
	
	// [솔루션2] 변수를 문자열 객체로 변환하고, 한 글자씩  Integer형으로 반환하며 더하는 방법 <문자열 변환>
	public int addDigits_2(int n) {
		String s = String.valueOf(n);
        int answer = 0;
        
        for (int i = 0; i < s.length() ; i++) {
            answer += Integer.parseInt(s.substring(i, i+1)); 
            //첫번째 인덱스부터 두번째 인덱스를 자른 값을 더하기 == 하나씩 자르고 Integer형으로 변환해서 더하기
        }
 
        return answer;

	}
	
	
	
	
	
	// [솔루션3] Math함수의 log10메서드를 활용한 방법
	public int addDigits_3(int n) {
		int answer = 0;
        int len = (int)Math.log10(n)+1;
        for(int i = 0; i < len; i++) {
            answer += n%10;
            n = n/10;   
        }
        return answer;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
