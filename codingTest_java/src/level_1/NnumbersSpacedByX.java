package level_1;

/**
 * @codingTest <Problems> x��ŭ ������ �ִ� n���� ���� [1-48]
 *
 */
public class NnumbersSpacedByX {

	
	public long[] n_numbersSpacedByX(int x, int n) {
        long[] answer = {};
        return answer;
    }
	
	
	
	
	// [�ַ��1] x * (i+1) �� �ذ��� ���
	public long[] n_numbersSpacedByX_1(int x, int n) {
		 long[] answer = new long[n];
	     long temp = x;
	                     
	     for(int i = 0; i < n; i++){ //n��ŭ �ݺ�
	         answer[i] = temp * (i+1); //
	     }
	            
	     return answer;
	}
	
	
	
	
	// [�ַ��2] �迭���� �����ϴ� ���
	public long[] n_numbersSpacedByX_2(int x, int n) {
		long[] answer = new long[n];
        answer[0] = x;

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + x; //���� �迭�� + x��
        }

        return answer;
	}
	
	
	
	
	// [�ַ��3] �ַ��2�� ����, �ݺ��� result[n].length �� �ϴ� ���
	public long[] n_numbersSpacedByX_3(int x, int n) {
		long[] result = new long[n];
        result[0] = x;
        for (int i = 1; i < result.length; ++i) {
            result[i] = result[i-1] + x;
        }
        return result;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
