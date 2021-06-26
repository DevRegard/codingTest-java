package level_1;

import java.util.Arrays;

/**
 * @codingTest <Problems> 서울에서 김서방 찾기 [1-29]
 *
 *	Arrays.asList() : Arrays의 private 정적 클래스 ArrayList(util.ArrayList와 다른것)
 *					  원소를 추가하는 메서드를 가지고 있지 않다 -> 사이즈 변경 불가능
 *
 *	asList() : 원본 배열의 주소값 가져오기				 
 *	
 *	indexOf() : 특정 문자,문자열 찾기
 */
public class FindKIM {

	
	public String findKIM(String[] seoul) {
        String answer = "";
        return answer;
    }
	
	
	
	
	// [솔루션1] 배열에서 문자열을 찾고 갯수만큼 i에 저장 후 출력하는 방법
	public String findKIM_1(String[] seoul) {
		String answer = ""; 
		
		for (int i = 0; i < seoul.length; i++){ 
			if ( seoul[i].equals("Kim")){ 
				answer = "김서방은 "+i+"에 있다"; 
				} 
			} 
		return answer;
	}
	
	
	
	
	// [솔루션2] Arrays.asList를 사용한 방법
	public String findKIM_2(String[] seoul) {
		int x = Arrays.asList(seoul).indexOf("Kim");

        return "김서방은 "+ x + "에 있다";
	}
	
	
	
	
	// [솔루션3] 향상된 for문을 사용한 방법
	public String findKIM_3(String[] seoul) {
		int x = 0;
		
		for (String name : seoul) {
		      if(name.equals("Kim"))
		        break;
		      x++;
		    }
		        return "김서방은 "+ x + "에 있다";
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
