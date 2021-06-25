package level_1;

/**
 * @codingTest <Problems> ���ڿ� �ٷ�� �⺻ [1-28]
 *
 *	matches() : ���ڷ� ����ǥ������ ����. ���ڿ��� ������ ��ġ�ϴ��� ����
 *	matches("^[0-9]*$") : ^�� ����, [0-9]�� ��� ����, $*�� 0�� �̻��� ���ڷ� ��
 *	
 */
public class StringHandingBasics {

	
	public boolean stringHandingBasics(String s) {
		boolean answer = true;
        return answer;
    }
	
	
	
	
	// [�ַ��1] ���Խ�ǥ���� ����� ���, matches()
	public boolean stringHandingBasics_1(String s) {
		 if (s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");
	        return false;
	}
	
	
	
	
	// [�ַ��2] try-catch���� ����� ���
	public boolean stringHandingBasics_2(String s) {
		if(s.length() == 4 || s.length() == 6){
			try{
				int x = Integer.parseInt(s);
				return true;
			} catch(NumberFormatException e){
				return false;
			}
		}
		else return false;
	}
	
	
	
	
	// [�ַ��3] ����ǥ������ ������� �ʴ� ���, ���׿����ڸ� ����Ͽ� ���ٷ� ������ ǥ��
	public boolean stringHandingBasics_3(String s) {
		return (s.length() != 4 && s.length() != 6) || (s.split("[0-9]").length > 0) ? false:true;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
