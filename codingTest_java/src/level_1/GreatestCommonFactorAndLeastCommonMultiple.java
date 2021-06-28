package level_1;

/**
 * @codingTest <Problems> �ִ������� �ּҰ���� [1-42]
 *
 *	GCD : Greatest Common divisor == �ִ�����
 *
 *	��Ŭ���� ȣ���� <Euclidean algorithm> : (a,b)�� �ִ������� (b,r)�� �ִ������� ����.
 *		GCD(a,b) == GCD(b,r) 
 *
 *		EX) (581,322)
 *		GCD(581, 322) = GCD(322, 259) = GCD(259, 63) =  GCD(63, 7) = GCD(7, 0) = 7
 *	
 */
public class GreatestCommonFactorAndLeastCommonMultiple {

	
	public int[] greatestCommonFactorAndLeastCommonMultiple_(int n, int m) {
        int[] answer = {};
        return answer;
    }
	
	
	
	
	// [��Ŭ���� ȣ����]
	public static int gcd(int a, int b) {
		
		while (b != 0) {
			int r = a % b; // �������� �����ش�.
			
			// GCD(a, b) = GCD(b, r)�̹Ƿ� ��ȯ�Ѵ�.
			a = b;
			b = r;
		}
		return a;
	}
	
	
	
	
	// [�ַ��1] ��Ŭ���� ȣ������ ����Լ��� ����� ���
	public int[] greatestCommonFactorAndLeastCommonMultiple_2(int n, int m) {
		int[] answer = new int[2];
		answer[0] = gcd(n, m);
		answer[1] = n * m / answer[0];
		return answer;
	}
	
	
	
	
	
	// [�ַ��2] ��Ŭ���� ȣ������ �޼��� �ȿ��� �����ϰ� �ٷ� �ִ������� �ִ������� ���ϴ� ���
	public int[] greatestCommonFactorAndLeastCommonMultiple_1(int a, int b) {
		int[] answer = new int[2];
	      int temp=1;
	      int gcd=a*b;
	      while(temp!=0){
	      temp=b%a;
	        b=a;
	        a=temp;
	      }
	      answer[0]=b;
	      answer[1]=gcd/b;
	        return answer;
	}
	
	
	
	
	// [�ַ��3] ȣ������ ������� �ʰ� �ִ������� �ִ������� ���ϴ� ��� (�ð����⵵�� ����)
	public int[] greatestCommonFactorAndLeastCommonMultiple_3(int a, int b) {
		int[] answer = new int[2];
        int mini = 0;
        int maxi = 1;

        //�ִ�����
        for(int i = 1; i<=a; i++) 
            if(a%i==0 && b%i==0)
                maxi = i;

        //�ִ�����
        for(int i = a*b; i>0; i--)
            if(i%a==0 && i%b==0)
                mini = i;

        answer[0] = maxi;
        answer[1] = mini;

        return answer;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
