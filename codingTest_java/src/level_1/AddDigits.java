package level_1;

/**
 * @codingTest <Problems> �ڸ��� ���ϱ� [1-36]
 *
 *	String.valueOf() : �Ű������� ���� String���� ��ȯ�Ѵ�. [����(wrapper) ��ü�� �ʿ��]
 *	Integer.parseInt() : ���ڿ� �Ű������� �ް�  Integer������ ��ȯ�Ѵ�. [���õ����� int Ÿ���ʿ��]
 *	str.substring(���� �ε���, ���� �ε���) : ���� ���� ���� �ε����� �ڸ���
 */
public class AddDigits {

	
	public int addDigits(int n) {
        int answer = 0;
        return answer;
    }
	
	
	
	
	// [�ַ��1] 'n % 10' ���� �� �ڸ��� �������� ���ϰ� ���ϴ� ��� <���� ������>
	public int addDigits_1(int n) {
		int sum = 0 ; // @1
		while(n != 0) {
			sum += n%10; // @2
			n /= 10; // @3
		}
		
		return sum;
	}
	
	
	
	
	
	// [�ַ��2] ������ ���ڿ� ��ü�� ��ȯ�ϰ�, �� ���ھ�  Integer������ ��ȯ�ϸ� ���ϴ� ��� <���ڿ� ��ȯ>
	public int addDigits_2(int n) {
		String s = String.valueOf(n);
        int answer = 0;
        
        for (int i = 0; i < s.length() ; i++) {
            answer += Integer.parseInt(s.substring(i, i+1)); 
            //ù��° �ε������� �ι�° �ε����� �ڸ� ���� ���ϱ� == �ϳ��� �ڸ��� Integer������ ��ȯ�ؼ� ���ϱ�
        }
 
        return answer;

	}
	
	
	
	
	
	// [�ַ��3] Math�Լ��� log10�޼��带 Ȱ���� ���
	public int addDigits_3(int n) {
		int answer = 0;
        int len = (int)Math.log10(n)+1;
        for(int i = 0; i < len; i++) {
            answer += n%10;
            n = n/10;   
        }
        return answer;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
