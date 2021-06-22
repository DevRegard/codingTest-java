package level_1;

/**
 * @codingTest <����� ������ ����>
 *
 */
public class AdditionOfFactors {

	
	public int additionOfFactors(int left, int right) {
        int answer = 0;
        return answer;
    }
	
	
	
	
	// [�ַ��1] ����� ���� ����=temp �� 1�� �ϰ�, ����� ������ �Ǻ��ϸ� ����� ���
	public int additionOfFactors_1(int left, int right) {
		// 1.
        int answer = 0;
        // 2.
        for(int i=left; i<=right;i++){ // ������ŭ �ݺ�
        	// 3. 
            int temp = 1;
            // 4.
            for (int j=1; j<=i/2;j++){ //***
            	// 5.
                if(i%j==0){ //***
                    temp++;
                }
            }
            // 6. 
            answer += temp%2 == 0 ? i : -i; //¦���̸� ����� ���ϰ�, Ȧ���̸� ������ ���Ѵ�. 
        }
        return answer;
	}
	
	
	
	
	// [�ַ��2] ����� ���� ������ 0���� �ϰ� ����� ���
	public int additionOfFactors_2(int left, int right) {
		int answer = 0, count = 0; // ���� ����, ����� ī��Ʈ�� ����
        for(int i = left; i <= right; i++) { // left���� right���� �ݺ�
            for(int j = 1; j <= i/2; j++) // ���� �̻��� ����� �ڱ� �ڽ� �ۿ� �������� �����Ƿ� ��ŵ
                if(i%j == 0) // j�� i�� ����̸�
                    count++;

            answer = (++count%2 == 0) ? answer + i : answer - i; // ī��Ʈ ������ ¦���̸� ���ϰ� Ȧ���̸� ��
            count = 0; // ī��Ʈ �ʱ�ȭ
        }
        return answer;
	}
	
	
	
	
	// [�ַ��3] Ŭ���� Math�� Ȱ���� ���
	public int additionOfFactors_3(int left, int right) {
		int answer = 0;
        int s = (int)Math.ceil(Math.sqrt(left));
        int ss = s * s;
        for (int i = left; i <= right; i++) {
            if (i == ss) {
                answer -= i;
                s++;
                ss = s * s;
            } else {
                answer += i;
            }
        }
        return answer;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
