package level_1;

/**
 * @codingTest <Problems> �̻��� ���� ����� [1-35]
 *
 */
public class CreateWeirdCharacters {

	
	public String createWeirdCharacters(String s) {
        String answer = "";
        return answer;
    }
	
	
	
	
	// [�ַ��1] ������ �迭�� �ְ�, ¦��Ȧ�� ������ ��ҹ��� �����ϴ� ���
	public String createWeirdCharacters_1(String s) {
		String answer = "";
	      
	      String str[] = s.split(""); // ""���� ������ ���� �迭�� �ֱ�
	      String space = " ";
	      int cnt = 0;
	      
	      for(int i = 0; i < str.length; i++){
	          if(str[i].equals(space)){ //�����̸� 0
	             cnt = 0;
	          }else{
	             if(cnt % 2 == 0){ //¦���̸�
	                cnt++;
	                str[i] = str[i].toUpperCase();
	             }else{ //Ȧ���̸�
	                 cnt++;
	                 str[i] = str[i].toLowerCase();
	             }
	          }
	          answer += str[i];
	      }
	      
	      System.out.println(answer);
	      
	      return answer;
	}
	
	
	
	
	// [�ַ��2] �ַ��1�� ���̽��� ���� for���� ���׿����ڸ� ����� ���
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
	
	
	
	
	// [�ַ��3] ���� �빮�ڷ� �ٲٰ�, �ҹ��ڷ� �����ϴ� ���
	public String createWeirdCharacters_3(String s) {
		String answer;
        answer = s.toUpperCase();
        char[] chars = answer.toCharArray();

        //�չ��ڰ� �빮�ڶ�� �ҹ��ڷ� ġȯ
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
