package level_1;

/**
 * @codingTest <Problems> ���� ������ �Ǻ� [1-39]
 *
 *	<�����Ǻ����>
 *	Double ������ = Math.sqrt(n);
 *	if(������ == sqrt.intValue())
 *
 *	Math.sqrt() : ������[��Ʈ] ���ϴ� �޼��� (EX: 25�� �������� 5) 
 *	Math.pow(value, N��) : �ŵ� ���� ���ϴ� �޼��� (EX: 5�� ������ 25, (5, 2))
 */
public class DetermineSquareRootOfInteger {

	
	public long determineSquareRootOfInteger(long n) {
        long answer = 0;
        return answer;
    }
	
	
	
	
	// [�ַ��1] Math.sqrt() �޼��带 �̿��Ͽ� �������� ���ϰ� �Ǻ��ϴ� ���
	public long determineSquareRootOfInteger_1(long n) {
		Double sqrt = Math.sqrt(n);
	      
	      if(sqrt == sqrt.intValue()){ // Math.sqrt�� �����ٰ� ������?
	          return (long)Math.pow(sqrt + 1, 2); //������ �������� 1�� ���ϰ� 2�� �����ϱ�
	      } else return -1;
	}
	
	
	
	
	// [�ַ��2] n�� �������� ������ n�� ������ �Ǻ��ϴ� ���
	public long determineSquareRootOfInteger_2(long n) {
		if (Math.pow((int)Math.sqrt(n), 2) == n) { //n�� �������� ���� == n �ΰ�?
            return (long) Math.pow(Math.sqrt(n) + 1, 2);
        }

        return -1;
	}
	
	
	
	
	// [�ַ��3] MathŬ������ ������� �ʰ� �������θ� �ذ��� ���
	public long determineSquareRootOfInteger_3(long n) {
		if(n==1){ 
	          return 4;
	      }
	      for(long i=2;i<n;i++){ //n�� 2 �̻��̸�
	          if(n/i == i && n%i == 0){ //������ �Ǻ���
	              return (i+1)*(i+1); //�������� ���� 1�� ���ϰ�, ���� ���ϱ� == (������+1)^2
	          }
	      }
	      return -1;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
