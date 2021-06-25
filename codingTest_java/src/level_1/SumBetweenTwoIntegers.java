package level_1;

/**
 * @codingTest <Problems> 두 정수 사이의 합
 *
 */
public class SumBetweenTwoIntegers {

	
	public long sumBetweenTwoIntegers(int a, int b) {
        long answer = 0;
        return answer;
    }
	
	
	
	
	// [솔루션1] 
	public long sumBetweenTwoIntegers_1(int a, int b) {
		long answer = 0;
		
		if(a<b) {
			for (int i = a; i <= b; i++) {
				answer += i;
			}
		} else {
			for (int i=b; i<=a; i++) {
				answer += i;
			}
		}
			
		return answer;
	}
	
	
	
	
	// [솔루션2] 삼항연산자 사용
	public long sumBetweenTwoIntegers_2(int a, int b) {
		long answer = 0;
	      for (int i = ((a < b) ? a : b); i <= ((a < b) ? b : a); i++) 
	          answer += i;

	      return answer;
	}
	
	
	
	
	// [솔루션3] 등차수열의 합 공식을 메서드로 만들고 사용
	public long sumBetweenTwoIntegers_3(int a, int b) {
		return sumAtoB(Math.min(a, b), Math.max(b, a)); //최댓값, 최솟값 대입
	}
	
	// [솔루션3] 등차수열 공식
	private long sumAtoB(long a, long b) {
	    return (b - a + 1) * (a + b) / 2;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}