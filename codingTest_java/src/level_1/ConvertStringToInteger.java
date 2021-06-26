package level_1;

/**
 * @codingTest <Problems> ���ڿ��� ������ �ٲٱ� [1-32]
 *
 *	"�ڵ��׽�Ʈ�� �˰���� �ڷᱸ���� �󸶳� ��� �����ϰ� �ִ°��� �Ǵ��ϴ� ô����� ���� ���ݰ� �Ǿ���."
 *
 *	matches() -> \\+? {0,4} :
 *	Integer.parseInt() : ���ڿ��� �Ű������� ������ Integer������ ��ȯ
 */
public class ConvertStringToInteger {

	
	public int convertStringToInteger(String s) {
        int answer = 0;
        return answer;
    }
	
	
	
	
	// [�ַ��1] ����ǥ������ ����ϴ� ���, ���׿����ڸ� ���� return���� �����ϰ� ǥ��
	public int convertStringToInteger_1(String s) {
		return s.matches("\\+?[1-9][0-9]{0,4}") ? 
			       Integer.parseInt(s) : Integer.parseInt(s.replace("-", ""))*-1;
			       
	}
	
	
	
	
	// [�ַ��2] Integer.parseInt�� ��ȯ�� ������ �״�� ����ϴ� ��� (��, ��ȣ�� �ٸ����� ���� ����)
	public int convertStringToInteger_2(String s) {
		int num=Integer.parseInt(s);
        return num;
	}
	
	
	
	
	// [�ַ��3] API ������� �ʰ�, ���� �˰������� ������ ���
	public int convertStringToInteger_3(String s) {
		 boolean Sign = true;
         int result = 0;

         for (int i = 0; i < s.length(); i++) {
             char ch = s.charAt(i);
             if (ch == '-')
                 Sign = false;
             else if(ch !='+')
                 result = result * 10 + (ch - '0');
         }
         return Sign?1:-1 * result;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
