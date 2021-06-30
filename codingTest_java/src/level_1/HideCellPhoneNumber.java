package level_1;

/**
 * @codingTest <Problems> �ڵ��� ��ȣ ������ [1-46]
 *
 *	toCharArray() : String(���ڿ�)�� char�� �迭�� �ٲ۴�.
 *
 *	����ǥ������ �˰��� ��� ȿ���� : '��Ʈ��ŷ' ���� ��ȿ����
 *
 *	replaceAll(".(?=.{4})", "*")
 *	.(?=.{4}) :
 *	. : ������ �� ���� (�� \�� ���� �� ����)
 *	() : �Ұ�ȣ ���� ���ڸ� �ϳ��� ���ڷ� �ν�
 *	? : �� ���ڰ� ���ų� �ϳ� ����
 *	{} : Ƚ�� �Ǵ� ����
 */
public class HideCellPhoneNumber {

	
	public String hideCellPhoneNumber(String phone_number) {
        String answer = "";
        return answer;
    }
	
	
	
	
	// [�ַ��1] split���� �и��ϰ� ���ǹ��� ���� �ذ��ϴ� ���
	public String hideCellPhoneNumber_1(String phone_number) {
		String answer = "";
        String[] a = phone_number.split(""); //���ڸ� �ڸ���, ���� �迭 a�� �ֱ�
        for(int i= 0; i<a.length; i++){
            if(i < (a.length-4)) { //���ڸ����� �ƴ϶��
                answer += "*";
            } else {
                answer += a[i];
            }
        }
        return answer;
	}
	
	
	
	
	// [�ַ��2] toCharArray()�� ���ڹ迭 ���� �� �ݺ������� �ٷ� �ذ��ϴ� ���
	public String hideCellPhoneNumber_2(String phone_number) {
		char[] ch = phone_number.toCharArray();
	     for(int i = 0; i < ch.length - 4; i ++){
	         ch[i] = '*';
	     }
	     return String.valueOf(ch);
	}
	
	
	
	
	// [�ַ��3] ����ǥ�������� �� ���� �ذ��ϴ� ���
	public String hideCellPhoneNumber_3(String phone_number) {
		return phone_number.replaceAll(".(?=.{4})", "*");
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
