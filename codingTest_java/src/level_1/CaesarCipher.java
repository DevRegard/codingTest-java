package level_1;

/**
 * @codingTest <Problems> 시저 암호 [1-33]
 *
 *	toCharArray(문자열시작인덱스,문자열길이) : 인스턴스의 지정된 부분 문자열에 있는 문자를 유니코드 문자 배열에 복사
 *
 *	isLowerCase() : 소문자이면 true
 *	isUpperCase() : 대문자이면 true
 *	charAt() : 유니코드 단일 문자 반환
 *
 *	람다식(람다함수) : 익명 함수 (Anonymous functions) 를 지칭하는 용어, 함수를 보다 단순하게 표현하는 방법
 *				     코드가 간결해지고, 불필요한 연산을 최소화하며, 멀티쓰레디를 활용하여 병렬처리
 *
 *	Stream : 다양한 데이터를 표준화된 방법으로 다루기 위한 라리브러리 (java 8)
 *	.map() : 요소들을 특정조건에 해당하는 값으로 변환해주기
 *	.mapToObj() : 원시 스트림을 '객체 스트림'으로 변환
 *	.reduce() : stream의 요소를 하나씩 줄여가며 계산
 *	.orElse("") : null이 아니여도 객체를 불러온다. (orElseGet은 null이여야만 불러온다.) 
 *	
 */
public class CaesarCipher {

	
	public String caesarCipher(String s, int n) {
        String answer = "";
        return answer;
    }
	
	
	
	
	// [솔루션1] 문자배열을 생성하고 "배열변수+n" 이 z 보다 큰 경우와 작은 경우로 나누어서 연산하는 방법
	public String caesarCipher_1(String s, int n) {
		 String answer = "";
	      int z = (int)'z';
	      int Z = (int)'Z';
	      int a = (int)'a';
	      int A = (int)'A';
	      char[] temp = s.toCharArray(); //a부터 z까지 있는 문자 배열 생성
	      
	      for(int i =0; i<temp.length; i++){
	          if(temp[i]>=a&& temp[i]<=z){
	              //소문자인경우
	              temp[i] = (int)temp[i]+n > z ? (char)(a+(int)temp[i]+n-z-1) : (char)((int)temp[i]+n);
	              // z보다 작으면 그냥 더하기 z보다 크면 전체 더한 값에서 z값을 빼고 남은 값을 a에서부터 더하기 (단, a는 이미 +1 상태이므로 -1해주기)
	          }else if(temp[i]>=A&& temp[i]<=Z){
	              //대문자인경우
	              temp[i] = (int)temp[i]+n > Z ? (char)(A+(int)temp[i]+n-Z-1) : (char)((int)temp[i]+n);
	          }else{
	              //공백
	              temp[i]=temp[i];
	          }
	      }
	      answer = new String(temp); //String안에 char배열 넣기
	      return answer;
	}
	
	
	
	
	// [솔루션2] n을 알파벳길이인 26만큼 나눈 나머지를 유니코드로 변환한 수를 연산하는 방법
	public String caesarCipher_2(String s, int n) {
		String result = "";
	    n = n % 26; // n 나누기 26 의 나머지
	    for (int i = 0; i < s.length(); i++) {
	      char ch = s.charAt(i); //유니코드 단일 문자 반환
	      if (Character.isLowerCase(ch)) {
	        ch = (char) ((ch - 'a' + n) % 26 + 'a');
	      } else if (Character.isUpperCase(ch)) {
	        ch = (char) ((ch - 'A' + n) % 26 + 'A');
	      }
	      result += ch;
	    }
	        return result;
	}
	
	
	
	
	// [솔루션3] 람다식과 스트림을 활용한 방법
	public String caesarCipher_3(String s, int _n) {
		return s.chars().map(c -> {
            int n = _n % 26;
            if (c >= 'a' && c <= 'z') {
                return 'a' + (c - 'a' + n) % 26;
            } else if (c >= 'A' && c <= 'Z') {
                return 'A' + (c - 'A' + n) % 26;
            } else {
                return c;
            }
        }).mapToObj(c -> String.valueOf((char)c))
        .reduce((a, b) -> a + b).orElse("");
//		.reduce(1, (x,y) -> x * y);
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
