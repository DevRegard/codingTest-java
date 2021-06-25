package level_1;

/**
 * @codingTest <Problems> �� ���� ������ ��
 *
 */
public class SumBetweenTwoIntegers {

	
	public long sumBetweenTwoIntegers(int a, int b) {
        long answer = 0;
        return answer;
    }
	
	
	
	
	// [�ַ��1] 
	public long sumBetweenTwoIntegers_1(int a, int b) {
		long answer = 0;
		
		if(a<b) {
			for (int i = a; i <= b; i++) {
				answer += i;
			}
		} else {
			for (int i=b; i<=a; i++) {
				answer += i;
			}
		}
			
		return answer;
	}
	
	
	
	
	// [�ַ��2] ���׿����� ���
	public long sumBetweenTwoIntegers_2(int a, int b) {
		long answer = 0;
	      for (int i = ((a < b) ? a : b); i <= ((a < b) ? b : a); i++) 
	          answer += i;

	      return answer;
	}
	
	
	
	
	// [�ַ��3] ���������� �� ������ �޼���� ����� ���
	public long sumBetweenTwoIntegers_3(int a, int b) {
		return sumAtoB(Math.min(a, b), Math.max(b, a)); //�ִ�, �ּڰ� ����
	}
	
	// [�ַ��3] �������� ����
	private long sumAtoB(long a, long b) {
	    return (b - a + 1) * (a + b) / 2;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}