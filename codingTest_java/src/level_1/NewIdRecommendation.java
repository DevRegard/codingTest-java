package level_1;

/**
 * @codingTest 신규 아이디 추천
 *
 *	정규표현식 규칙 : 
 */
public class NewIdRecommendation {

	
	public String newIdRecommendation(String new_id) {
        String answer = "";
        return answer;
    }
	
	
	
	
	public String newIdRecommendation_1(String new_id) { //정규표현식
		String answer = new_id.toLowerCase(); // 1단계 
		
		answer = answer.replaceAll("[^-_.a-z0-9]", ""); //2단계
		answer = answer.replaceAll("[.]{2,}", "."); //3단계
		answer = answer.replaceAll("^[.]|[.]$", ""); //4단계
		
		if (answer.equals("")) { //5단계
			answer += "a";
		}
		
		if (answer.length() >= 16) { //6단계
			answer = answer.substring(0,15); // 첫뻔재 인덱스 부터 16번째 인덱스까지
			answer = answer.replaceAll("[.]$", "");
		}
		
		if (answer.length() <= 2) { //7단계
			while (answer.length() < 3) {
				answer += answer.charAt(answer.length() - 1);
			}
		}
		
		return answer;
	}
	
	
	
	
	public String newIdRecommendation_2(String new_id) {
		String answer = "";
		return answer;
	}
	
	
	
	
	public String newIdRecommendation_3(String new_id) {
		String answer = "";
		return answer;
	}
	
	
	
	
	public static void main(String[] args) {
		NewIdRecommendation nic = new NewIdRecommendation();
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		
		System.out.println(nic.newIdRecommendation(new_id));
		System.out.println(nic.newIdRecommendation_1(new_id));
		System.out.println(nic.newIdRecommendation_2(new_id));
		System.out.println(nic.newIdRecommendation_3(new_id));
	}

}
