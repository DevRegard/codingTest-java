package level_1;

/**
 * @codingTest <Problems> �ڿ��� ������ �迭�� ����� [1-37]
 *
 *	reverse() : ���빰�� ������ �����´�.
 */
public class FlipNaturalNumbersToFormArray {

	
	public int[] flipNaturalNumbersToFormArray_(long n) {
        int[] answer = {};
        return answer;
    }
	
	
	
	
	// [�ַ��1] ���ڸ� ���ڿ��� �ٲٰ� ���̸�ŭ 'n%10'�� 'n/=10'�� �ݺ��ϴ� ��� <����� �迭����>
	public int[] flipNaturalNumbersToFormArray_1(long n) {
		String str = ""+n; // longŸ���� ��Ʈ������ ��ȯ�ϱ� ("")
		int number = str.length(); 
		int[] answer = new int[number]; //n�� ���̸�ŭ�� �迭�� answer�迭 ���� �ʱ�ȭ
		
		for(int index=0; index<number;index++) { //���� ���� ��ŭ
			answer[index] = (int)(n%10); 
			n/=10; 
			} 
		return answer;

	}
	
	
	
	
	// [�ַ��2] StringBuilderŬ������ reverse() �޼��带 ����� ���
	public int[] flipNaturalNumbersToFormArray_2(long n) {
		String s = String.valueOf(n);
	      StringBuilder sb = new StringBuilder(s);
	      sb = sb.reverse();
	      String[] ss = sb.toString().split("");

	      int[] answer = new int[ss.length];
	      for (int i=0; i<ss.length; i++) {
	          answer[i] = Integer.parseInt(ss[i]);
	      }
	      return answer;
	}
	
	
	
	
	// [�ַ��3] �ַ��1���� ������ �ٿ��� ���Ἲ ���� ǥ���� ���
	public int[] flipNaturalNumbersToFormArray_3(long n) {
		int length = Long.toString(n).length();
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            answer[i] = (int) (n % 10);
            n /= 10;
        }

        return answer;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
