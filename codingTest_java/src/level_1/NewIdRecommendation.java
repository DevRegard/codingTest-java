package level_1;

/**
 * @codingTest �ű� ���̵� ��õ
 *
 *	����ǥ���� ��Ģ : 
 */
public class NewIdRecommendation {

	
	public String newIdRecommendation(String new_id) {
        String answer = "";
        return answer;
    }
	
	
	
	
	public String newIdRecommendation_1(String new_id) { //����ǥ����
		String answer = new_id.toLowerCase(); // 1�ܰ� 
		
		answer = answer.replaceAll("[^-_.a-z0-9]", ""); //2�ܰ�
		answer = answer.replaceAll("[.]{2,}", "."); //3�ܰ�
		answer = answer.replaceAll("^[.]|[.]$", ""); //4�ܰ�
		
		if (answer.equals("")) { //5�ܰ�
			answer += "a";
		}
		
		if (answer.length() >= 16) { //6�ܰ�
			answer = answer.substring(0,15); // ù���� �ε��� ���� 16��° �ε�������
			answer = answer.replaceAll("[.]$", "");
		}
		
		if (answer.length() <= 2) { //7�ܰ�
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
