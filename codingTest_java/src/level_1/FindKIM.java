package level_1;

import java.util.Arrays;

/**
 * @codingTest <Problems> ���￡�� �輭�� ã�� [1-29]
 *
 *	Arrays.asList() : Arrays�� private ���� Ŭ���� ArrayList(util.ArrayList�� �ٸ���)
 *					  ���Ҹ� �߰��ϴ� �޼��带 ������ ���� �ʴ� -> ������ ���� �Ұ���
 *
 *	asList() : ���� �迭�� �ּҰ� ��������				 
 *	
 *	indexOf() : Ư�� ����,���ڿ� ã��
 */
public class FindKIM {

	
	public String findKIM(String[] seoul) {
        String answer = "";
        return answer;
    }
	
	
	
	
	// [�ַ��1] �迭���� ���ڿ��� ã�� ������ŭ i�� ���� �� ����ϴ� ���
	public String findKIM_1(String[] seoul) {
		String answer = ""; 
		
		for (int i = 0; i < seoul.length; i++){ 
			if ( seoul[i].equals("Kim")){ 
				answer = "�輭���� "+i+"�� �ִ�"; 
				} 
			} 
		return answer;
	}
	
	
	
	
	// [�ַ��2] Arrays.asList�� ����� ���
	public String findKIM_2(String[] seoul) {
		int x = Arrays.asList(seoul).indexOf("Kim");

        return "�輭���� "+ x + "�� �ִ�";
	}
	
	
	
	
	// [�ַ��3] ���� for���� ����� ���
	public String findKIM_3(String[] seoul) {
		int x = 0;
		
		for (String name : seoul) {
		      if(name.equals("Kim"))
		        break;
		      x++;
		    }
		        return "�輭���� "+ x + "�� �ִ�";
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
