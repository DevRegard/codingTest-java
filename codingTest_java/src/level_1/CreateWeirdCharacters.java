package level_1;

/**
 * @codingTest <Problems> 이상한 문자 만들기 [1-35]
 *
 */
public class CreateWeirdCharacters {

	
	public String createWeirdCharacters(String s) {
        String answer = "";
        return answer;
    }
	
	
	
	
	// [솔루션1] 변수를 배열로 넣고, 짝수홀수 나눠서 대소문자 변경하는 방법
	public String createWeirdCharacters_1(String s) {
		String answer = "";
	      
	      String str[] = s.split(""); // ""으로 구분한 것을 배열로 넣기
	      String space = " ";
	      int cnt = 0;
	      
	      for(int i = 0; i < str.length; i++){
	          if(str[i].equals(space)){ //공백이면 0
	             cnt = 0;
	          }else{
	             if(cnt % 2 == 0){ //짝수이면
	                cnt++;
	                str[i] = str[i].toUpperCase();
	             }else{ //홀수이면
	                 cnt++;
	                 str[i] = str[i].toLowerCase();
	             }
	          }
	          answer += str[i];
	      }
	      
	      System.out.println(answer);
	      
	      return answer;
	}
	
	
	
	
	// [솔루션2] 솔루션1을 베이스로 향상된 for문과 삼항연산자를 사용한 방법
	public String createWeirdCharacters_2(String s) {
		String answer = "";
        int cnt = 0;
        String[] array = s.split("");

        for(String ss : array) {
            cnt = ss.contains(" ") ? 0 : cnt + 1;
            answer += cnt%2 == 0 ? ss.toLowerCase() : ss.toUpperCase(); 
        }
      return answer;
	}
	
	
	
	
	// [솔루션3] 전부 대문자로 바꾸고, 소문자로 변경하는 방법
	public String createWeirdCharacters_3(String s) {
		String answer;
        answer = s.toUpperCase();
        char[] chars = answer.toCharArray();

        //앞문자가 대문자라면 소문자로 치환
        for (int i = 1; i < chars.length; i++) {
            if (62 <= chars[i - 1] && chars[i - 1] <= 90) {
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
        answer = String.valueOf(chars);
        return answer;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
