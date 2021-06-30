package level_1;

/**
 * @codingTest <Problems> 핸드폰 번호 가리기 [1-46]
 *
 *	toCharArray() : String(문자열)을 char형 배열로 바꾼다.
 *
 *	정규표현식의 알고리즘 사용 효율성 : '백트래킹' 으로 비효율적
 *
 *	replaceAll(".(?=.{4})", "*")
 *	.(?=.{4}) :
 *	. : 임의의 한 문자 (단 \은 넣을 수 없다)
 *	() : 소괄호 안의 문자를 하나의 문자로 인식
 *	? : 앞 문자가 없거나 하나 있음
 *	{} : 횟수 또는 범위
 */
public class HideCellPhoneNumber {

	
	public String hideCellPhoneNumber(String phone_number) {
        String answer = "";
        return answer;
    }
	
	
	
	
	// [솔루션1] split으로 분리하고 조건문을 통해 해결하는 방법
	public String hideCellPhoneNumber_1(String phone_number) {
		String answer = "";
        String[] a = phone_number.split(""); //글자를 자르고, 문자 배열 a에 넣기
        for(int i= 0; i<a.length; i++){
            if(i < (a.length-4)) { //뒷자리수가 아니라면
                answer += "*";
            } else {
                answer += a[i];
            }
        }
        return answer;
	}
	
	
	
	
	// [솔루션2] toCharArray()로 문자배열 생성 후 반복문에서 바로 해결하는 방법
	public String hideCellPhoneNumber_2(String phone_number) {
		char[] ch = phone_number.toCharArray();
	     for(int i = 0; i < ch.length - 4; i ++){
	         ch[i] = '*';
	     }
	     return String.valueOf(ch);
	}
	
	
	
	
	// [솔루션3] 정규표현식으로 한 번에 해결하는 방법
	public String hideCellPhoneNumber_3(String phone_number) {
		return phone_number.replaceAll(".(?=.{4})", "*");
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
