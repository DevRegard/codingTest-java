package level_1;

/**
 * @codingTest <Problems> 문자열 내 p와 y의 개수 [1-26]
 *
 *	toUpperCase() : 대상 문자열을 모두 대문자로 변환
 */
public class NumberPY {

	
	boolean numberPY(String s) {
        boolean answer = true;
        return answer;
    }
	
	
	
	
	// [솔루션1] pP 갯수만큼 더하고, yY 갯수만큼 빼서 0이면 true, 0이 아니면 false 리턴하는 방법
	boolean numberPY_1(String s) {
		int cnt = 0;
		char ch = ' ';
		
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if (ch =='p' || ch == 'P') {
				cnt++;
			} else if (ch == 'y' || ch == 'Y')
				cnt--;
		}
		if (cnt != 0) {
			return false;
		}
		
		return true;
	}
	
	
	
	
	// [솔루션2] 람다식을 이용한 방법, 대소문자 구분없이 전부 대문자로 변환하고 시작
	boolean numberPY_2(String s) {
		s = s.toUpperCase(); //전부 대문자로 변환

        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
        //return값이 값으면 
	}
	
	
	
	
	// [솔루션3] 소문자로 전부 변환하고, 솔루션1과 유사한 방법
	boolean numberPY_3(String s) {
		 s = s.toLowerCase();
	        int count = 0;

	        for (int i = 0; i < s.length(); i++) {

	            if (s.charAt(i) == 'p')
	                count++;
	            else if (s.charAt(i) == 'y')
	                count--;
	        }

	        if (count == 0)
	            return true;
	        else
	            return false;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
