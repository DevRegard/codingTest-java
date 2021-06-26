package level_1;

/**
 * @codingTest <Problems> 수박수박수박수박수박수 [1-31]
 *
 *	replace("\0", "수박") : 유니코드 0을 '수박'으로 변환 (cf. 유니코드0 = null)
 *	substring(0,n) : 0번째 문자열부터 n번째까지 자르는 함수
 */
public class WatermelonClap {

	
	public String watermelonClap(int n) {
        String answer = "";
        return answer;
    }
	
	
	
	
	// [솔루션1] 짝수이면 '수' 홀수이면 '박'을 리턴하는 방법1
	public String watermelonClap_1(int n) {
		String answer = "";

		for (int i = 0; i < n; i++) {
			if(i%2 == 0) {
				answer += "수";
			}
			
			if(i%2 == 1) {
				answer += "박";
			}
		}

		return answer;
	}
	
	
	
	
	// [솔루션2] for문을 사용하지 않고 리턴에서 연산하는 방법, replace(), substring()
	public String watermelonClap_2(int n) {
		return new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);
	}
	
	
	
	
	// [솔루션3] 짝수가 맞으면 수, 아니면 박으로 하여 삼항연산자로 간결히 표현하는 방법
	public String watermelonClap_3(int n) {
		 String result = "";
		    for (int i = 0; i < n; i++)
		      result += i % 2 == 0 ? "수" : "박";
		        return result;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
