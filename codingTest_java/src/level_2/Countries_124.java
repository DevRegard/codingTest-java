package level_2;

/**
 * @codingTest <Problems> 124 나라의 숫자 [2-4]
 *
 */
public class Countries_124 {

	
	public String countries_124(int n) {
        String answer = "";
        return answer;
    }
	
	
	
	
	
	// [솔루션 1]
	public String countries_124_1(int n) {
		  String[] numbers = {"4", "1", "2"};
	      String answer = "";
	      
	      int num = n;
	      
	      while(num > 0){
	          int remainder = num % 3;
	          num /= 3;
	          
	          if(remainder == 0) num--;
	          
	          answer = numbers[remainder] + answer;
	      }
	      
	      return answer;
	}
	
	
	
	
	
	// [솔루션 2]
	public String countries_124_2(int n) {
		String[] num = {"4","1","2"};
	      String answer = "";

	      while(n > 0){
	          answer = num[n % 3] + answer;
	          n = (n - 1) / 3;
	      }
	      return answer;
	}
	
	
	
	
	
	// [솔루션 3]
	public String countries_124_3(int n) {
		String answer = "";
        int k = 0;

        while (n > 0) {
            k = n % 3; //나머지  - 자릿수 (낮은자리부터)
            n = n / 3; //몫        - 다음루프의 피제수
            if (k == 0) {
                n = n-1; //자리올림을 안 하는 효과
                k = 4;
            }
            answer = k + answer;
        }
        return answer;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
