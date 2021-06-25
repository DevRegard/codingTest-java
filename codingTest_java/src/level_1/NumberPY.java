package level_1;

/**
 * @codingTest <Problems> ���ڿ� �� p�� y�� ���� [1-26]
 *
 *	toUpperCase() : ��� ���ڿ��� ��� �빮�ڷ� ��ȯ
 */
public class NumberPY {

	
	boolean numberPY(String s) {
        boolean answer = true;
        return answer;
    }
	
	
	
	
	// [�ַ��1] pP ������ŭ ���ϰ�, yY ������ŭ ���� 0�̸� true, 0�� �ƴϸ� false �����ϴ� ���
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
	
	
	
	
	// [�ַ��2] ���ٽ��� �̿��� ���, ��ҹ��� ���о��� ���� �빮�ڷ� ��ȯ�ϰ� ����
	boolean numberPY_2(String s) {
		s = s.toUpperCase(); //���� �빮�ڷ� ��ȯ

        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
        //return���� ������ 
	}
	
	
	
	
	// [�ַ��3] �ҹ��ڷ� ���� ��ȯ�ϰ�, �ַ��1�� ������ ���
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
