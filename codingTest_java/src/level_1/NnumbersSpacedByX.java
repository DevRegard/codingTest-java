package level_1;

/**
 * @codingTest <Problems> x만큼 간격이 있는 n개의 숫자 [1-48]
 *
 */
public class NnumbersSpacedByX {

	
	public long[] n_numbersSpacedByX(int x, int n) {
        long[] answer = {};
        return answer;
    }
	
	
	
	
	// [솔루션1] x * (i+1) 로 해결한 방법
	public long[] n_numbersSpacedByX_1(int x, int n) {
		 long[] answer = new long[n];
	     long temp = x;
	                     
	     for(int i = 0; i < n; i++){ //n만큼 반복
	         answer[i] = temp * (i+1); //
	     }
	            
	     return answer;
	}
	
	
	
	
	// [솔루션2] 배열에서 연산하는 방법
	public long[] n_numbersSpacedByX_2(int x, int n) {
		long[] answer = new long[n];
        answer[0] = x;

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + x; //이전 배열값 + x값
        }

        return answer;
	}
	
	
	
	
	// [솔루션3] 솔루션2와 유사, 반복은 result[n].length 로 하는 방법
	public long[] n_numbersSpacedByX_3(int x, int n) {
		long[] result = new long[n];
        result[0] = x;
        for (int i = 1; i < result.length; ++i) {
            result[i] = result[i-1] + x;
        }
        return result;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
