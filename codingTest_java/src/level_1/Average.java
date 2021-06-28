package level_1;

import java.util.Arrays;

/**
 * @codingTest <Problems> ��� ���ϱ� [1-44]
 *
 *	API �̿��ϸ� �ӵ��� �����ϰ� ��������. -> �˰����� �ð����⵵�� ���ߴ°� �ٽ� ����
 *
 *
 *	Arrays.stream() : ���� ��Ҹ� �ϳ��� �����ؼ� ���ٽ����� ó���� �� �ֵ��� ���ִ� �ݺ���
 *					  (Iterator�� ����, -> ���ٽ��� �� �����ϰ� ����ó������)
 *
 *	stream().average() : ��Ʈ������ ��ձ��ϴ� �޼���
 *
 *	orElse(0) : ���� null�� �ƴϿ���  ȣ�� �� ���� ���� 
 *				-> 0 != null ? 0 : other;
 *				== ���� ������ 0�� �����Ѵ�.				
 *
 *	orElseGet() : null �̿��� ȣ�� -> value != null ? value : other.get();
 */
public class Average {

	
	public double average(int[] arr) {
        double answer = 0;
        return answer;
    }
	
	
	
	
	// [�ַ��1] ������ ���ϰ�, ���տ��� �迭�� ���̸�ŭ ������ �⺻���� ���
	public double average_1(int[] arr) {
		double answer = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		answer = (double) sum / arr.length;
		return answer;
	}
	
	
	
	
	// [�ַ��2] Arrays.stream(), Average()�� Ȱ���� ���
	public double average_2(int[] arr) {
		return (int) Arrays.stream(arr).average().orElse(0);
	}
	
	
	
	
	// [�ַ��3] �迭�� null�� ��츦 ����� ��� <Ư����Ȳ �������� �ڵ�>
	public double average_3(int[] arr) {
		if(arr == null){
	        return 0;
	      }

	      int ret = 0;
	      if(arr != null){
	        for(int n : arr){
	            ret += n;
	        }
	      }
	        return ret / arr.length;
	    }
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
