package level_1;

/**
 * @codingTest <Problems> ���ڼ��ڼ��ڼ��ڼ��ڼ� [1-31]
 *
 *	replace("\0", "����") : �����ڵ� 0�� '����'���� ��ȯ (cf. �����ڵ�0 = null)
 *	substring(0,n) : 0��° ���ڿ����� n��°���� �ڸ��� �Լ�
 */
public class WatermelonClap {

	
	public String watermelonClap(int n) {
        String answer = "";
        return answer;
    }
	
	
	
	
	// [�ַ��1] ¦���̸� '��' Ȧ���̸� '��'�� �����ϴ� ���1
	public String watermelonClap_1(int n) {
		String answer = "";

		for (int i = 0; i < n; i++) {
			if(i%2 == 0) {
				answer += "��";
			}
			
			if(i%2 == 1) {
				answer += "��";
			}
		}

		return answer;
	}
	
	
	
	
	// [�ַ��2] for���� ������� �ʰ� ���Ͽ��� �����ϴ� ���, replace(), substring()
	public String watermelonClap_2(int n) {
		return new String(new char [n/2+1]).replace("\0", "����").substring(0,n);
	}
	
	
	
	
	// [�ַ��3] ¦���� ������ ��, �ƴϸ� ������ �Ͽ� ���׿����ڷ� ������ ǥ���ϴ� ���
	public String watermelonClap_3(int n) {
		 String result = "";
		    for (int i = 0; i < n; i++)
		      result += i % 2 == 0 ? "��" : "��";
		        return result;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
