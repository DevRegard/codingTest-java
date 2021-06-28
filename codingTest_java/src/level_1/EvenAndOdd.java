package level_1;

/**
 * @codingTest <Problems> 짝수와 홀수 [1-41]
 *
 */
public class EvenAndOdd {

	
	public String evenAndOdd(int num) {
        String answer = "";
        return answer;
    }
	
	
	
	
	// [솔루션1] N%2==0을 if문으로 구현한 일반적인 방법
	public String evenAndOdd_1(int num) {
		String answer = "";
        
        if(num%2==0){
            answer = "Even";
        } else {
            answer = "Odd";
        }
        return answer;
	}
	
	
	
	
	
	// [솔루션2] 리턴문에서 삼항연산자를 사용한 방법
	public String evenAndOdd_2(int num) {
		return num % 2 == 0 ? "Even": "Odd";
	}
	
	
	
	
	
	// [솔루션3] 'N % 2'식을 변수로 사용한 방법 
	public String evenAndOdd_3(int num) {
		String result = "";
        int val = num % 2;

        if(val == 0){
          result = "Even";
        }else if(val == 1){
          result = "Odd";
        }

        return result;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
