package level_1;

/**
 * @codingTest 신규 아이디 추천
 *
 *	정규표현식
 *	replaceAll() :
 *	subString()	:
 *	charAt() :
 */
public class NewIdRecommendation {

	
	public String newIdRecommendation(String new_id) {
        String answer = "";
        return answer;
    }
	
	
	
	//정규표현식 사용 솔루션
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
	
	
	
	
	//클래스 1과 동일한 솔루션
	public String newIdRecommendation_2(String new_id) {
		 String answer = "";
	        String temp = new_id.toLowerCase();

	        temp = temp.replaceAll("[^-_.a-z0-9]","");
	        System.out.println(temp);
	        temp = temp.replaceAll("[.]{2,}",".");
	        temp = temp.replaceAll("^[.]|[.]$","");
	        System.out.println(temp.length());
	        if(temp.equals(""))
	            temp+="a";
	        if(temp.length() >=16){
	            temp = temp.substring(0,15);
	            temp=temp.replaceAll("^[.]|[.]$","");
	        }
	        if(temp.length()<=2)
	            while(temp.length()<3)
	                temp+=temp.charAt(temp.length()-1);

	        answer=temp;
	        return answer;
	}
	
	
	
	//비정규표션식 솔루션
	public String newIdRecommendation_3(String new_id) {
		String s = new KAKAOID(new_id)
                .replaceToLowerCase()
                .filter()
                .toSingleDot()
                .noStartEndDot()
                .noBlank()
                .noGreaterThan16()
                .noLessThan2()
                .getResult();


        return s;
	}
	
	
	
	//솔루션 3번째에서 사용하는 클래스 (비정규표현식)
	private static class KAKAOID {
		private String s;

        KAKAOID(String s) {
            this.s = s;
        }

        private KAKAOID replaceToLowerCase() {
            s = s.toLowerCase();
            return this;
        }

        private KAKAOID filter() {
            s = s.replaceAll("[^a-z0-9._-]", "");
            return this;
        }

        private KAKAOID toSingleDot() {
            s = s.replaceAll("[.]{2,}", ".");
            return this;
        }

        private KAKAOID noStartEndDot() {
            s = s.replaceAll("^[.]|[.]$", "");
            return this;
        }

        private KAKAOID noBlank() {
            s = s.isEmpty() ? "a" : s;
            return this;
        }

        private KAKAOID noGreaterThan16() {
            if (s.length() >= 16) {
                s = s.substring(0, 15);
            }
            s = s.replaceAll("[.]$", "");
            return this;
        }

        private KAKAOID noLessThan2() {
            StringBuilder sBuilder = new StringBuilder(s);
            while (sBuilder.length() <= 2) {
                sBuilder.append(sBuilder.charAt(sBuilder.length() - 1));
            }
            s = sBuilder.toString();
            return this;
        }

        private String getResult() {
            return s;
        }
	}
	
	
	
	
	public static void main(String[] args) {
		NewIdRecommendation nic = new NewIdRecommendation();
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		
//		System.out.println(nic.newIdRecommendation(new_id));
//		System.out.println(nic.newIdRecommendation_1(new_id));
		System.out.println(nic.newIdRecommendation_2(new_id));
//		System.out.println(nic.newIdRecommendation_3(new_id));

	}

}
