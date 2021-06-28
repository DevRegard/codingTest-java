package level_1;

/**
 * @codingTest <Problems> 정수 제곱근 판별 [1-39]
 *
 *	<정수판별방법>
 *	Double 제곱근 = Math.sqrt(n);
 *	if(제곱근 == sqrt.intValue())
 *
 *	Math.sqrt() : 제곱근[루트] 구하는 메서드 (EX: 25의 제곱근은 5) 
 *	Math.pow(value, N승) : 거듭 제곱 구하는 메서드 (EX: 5의 제곱은 25, (5, 2))
 */
public class DetermineSquareRootOfInteger {

	
	public long determineSquareRootOfInteger(long n) {
        long answer = 0;
        return answer;
    }
	
	
	
	
	// [솔루션1] Math.sqrt() 메서드를 이용하여 제곱근을 구하고 판별하는 방법
	public long determineSquareRootOfInteger_1(long n) {
		Double sqrt = Math.sqrt(n);
	      
	      if(sqrt == sqrt.intValue()){ // Math.sqrt의 제곱근과 같은가?
	          return (long)Math.pow(sqrt + 1, 2); //같으면 제곱근의 1을 더하고 2의 제곱하기
	      } else return -1;
	}
	
	
	
	
	// [솔루션2] n의 제곱근의 제곱은 n과 같은지 판별하는 방법
	public long determineSquareRootOfInteger_2(long n) {
		if (Math.pow((int)Math.sqrt(n), 2) == n) { //n의 제곱근의 제곱 == n 인가?
            return (long) Math.pow(Math.sqrt(n) + 1, 2);
        }

        return -1;
	}
	
	
	
	
	// [솔루션3] Math클래스를 사용하지 않고 계산식으로만 해결한 방법
	public long determineSquareRootOfInteger_3(long n) {
		if(n==1){ 
	          return 4;
	      }
	      for(long i=2;i<n;i++){ //n이 2 이상이면
	          if(n/i == i && n%i == 0){ //제곱근 판별식
	              return (i+1)*(i+1); //제곱근의 각각 1을 더하고, 서로 더하기 == (제곱근+1)^2
	          }
	      }
	      return -1;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
