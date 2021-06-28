package level_1;

/**
 * @codingTest <Problems> 자연수 뒤집어 배열로 만들기 [1-37]
 *
 *	reverse() : 내용물의 순서를 뒤집는다.
 */
public class FlipNaturalNumbersToFormArray {

	
	public int[] flipNaturalNumbersToFormArray_(long n) {
        int[] answer = {};
        return answer;
    }
	
	
	
	
	// [솔루션1] 숫자를 문자열로 바꾸고 길이만큼 'n%10'과 'n/=10'을 반복하는 방법 <뒤집어서 배열저장>
	public int[] flipNaturalNumbersToFormArray_1(long n) {
		String str = ""+n; // long타입을 스트링으로 변환하기 ("")
		int number = str.length(); 
		int[] answer = new int[number]; //n의 길이만큼의 배열로 answer배열 변수 초기화
		
		for(int index=0; index<number;index++) { //문자 길이 만큼
			answer[index] = (int)(n%10); 
			n/=10; 
			} 
		return answer;

	}
	
	
	
	
	// [솔루션2] StringBuilder클래스와 reverse() 메서드를 사용한 방법
	public int[] flipNaturalNumbersToFormArray_2(long n) {
		String s = String.valueOf(n);
	      StringBuilder sb = new StringBuilder(s);
	      sb = sb.reverse();
	      String[] ss = sb.toString().split("");

	      int[] answer = new int[ss.length];
	      for (int i=0; i<ss.length; i++) {
	          answer[i] = Integer.parseInt(ss[i]);
	      }
	      return answer;
	}
	
	
	
	
	// [솔루션3] 솔루션1에서 변수를 줄여서 간결성 좋게 표현한 방법
	public int[] flipNaturalNumbersToFormArray_3(long n) {
		int length = Long.toString(n).length();
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            answer[i] = (int) (n % 10);
            n /= 10;
        }

        return answer;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
