package level_1;

/**
 * @codingTest <가운데 글자 가져오기>
 *	
 *	substring(int a1) : a1 부터 끝까지 가져오기
 *	substring(int a1, int a2) : a1 부터 a2까지 가져오기
 *
 *	indexOf(int n / String str) : n 이나 str이 있는 인덱스를 반환해주는 함수
 *	charAt(int n) : n번째 위치의 값을 반환해주는 함수
 */
public class GetMiddleLetter {

	
	    public String getMiddleLetter(String s) {
	        String answer = "";
	        return answer;
	    }
	
	
	
	
		// [솔루션1] substring(a, b)를 활용 , 문자열에서 길이의 절반을 나누고 계산
		public String getMiddleLetter_1(String s) {
			String answer = "";
	          
	          //짝수와 홀수인 경우로 나누어서 정리한다! 짝수면 2글자가 나오고 홀수면 1글자가 나올 것이다.
	          if(s.length()%2==0) { //짝수
	              answer = s.substring(s.length()/2-1, s.length()/2+1);
	          } else {  //짝수가 아니면 =홀수
	              answer = s.substring(s.length()/2,s.length()/2+1);
	          }
	          
	          return answer;
		}
	
	
	
	
		// [솔루션2] 오직 리턴문만 사용해서 한줄로 해결
		public String getMiddleLetter_2(String word) {
			
			return word.substring((word.length()-1) / 2, word.length()/2 + 1); 
		}
	
	
	
	
		// [솔루션3] 깔끔하고 가독성 좋은 코드 , 솔루션1과 유사한 방법
		public String getMiddleLetter_3(String word) {
			 int a = word.length();
			    String word1;
			    if ( a % 2 == 0 )
			            word1 = word.substring(a/2 - 1, (a/2) + 1);
			    else
			            word1 = word.substring((a/2), (a/2) + 1);
			    return word1;
		}
	
	
	
	
	
	public static void main(String[] args) {
		GetMiddleLetter gml = new GetMiddleLetter();
		System.out.println(gml.getMiddleLetter_1("superpower"));
		System.out.println(gml.getMiddleLetter_2("superpower"));
		System.out.println(gml.getMiddleLetter_3("superpower"));
		
	}

}
