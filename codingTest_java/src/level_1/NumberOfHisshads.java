package level_1;

import java.io.IOException;

/**
 * @codingTest <Problems> 하샤드 수 [1-45]
 *
 *	io.IOException : 입출력 처리의 실패, 또는 인터럽트의 발생에 의해 작성되는 예외의 일반적인 클래스 
 *					  어떠한 입출력 예외의 발생을 통지하는 시그널을 발생
 *
 *	sum += a % 10 : x를 나눈 나머지 값 sum애 저장
 *	a /= 10 : 10나눠서 자릿수 바꾸기(while문 in)
 */
public class NumberOfHisshads {

	
	public boolean numberOfHisshads(int x) {
        boolean answer = true;
        return answer;
    }
	
	
	
	
	// [솔루션1] 'a%10'과 'a/=10'으로 연산하는 방법
	public boolean numberOfHisshads_1(int x) throws IOException {
		int sum = 0;
		int a = x;
      
		while (a >= 1) {
			sum += a % 10; //x를 나눈 나머지 값 sum애 저장
			a /= 10; // 10나눠서 자릿수 바꾸기
		}
 
		if (x % sum == 0) {
			return true;
		} else
			return false;
	}
	
	
	
	
	// [솔루션2] valueOf().split("")으로 분리해서 연산하는 방법
	public boolean numberOfHisshads_2(int x) {
		String[] temp = String.valueOf(x).split("");

	    int sum = 0;
	    for (String s : temp) {
	        sum += Integer.parseInt(s);
	    }

	    if (x % sum == 0) {
	            return true;
	    } else {
	      return false;
	    }
	}
	
	
	
	
	// [솔루션3] 람다식을 이용해서 문자를 나누고 연산하는 방법
	public boolean numberOfHisshads_3(int x) {
		sum = 0;
        Integer.toString(x).chars().forEach(c -> sum += c - '0');
        return x % sum == 0;
	}
	private int sum = 0;
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
