package level_1;

import java.io.IOException;

/**
 * @codingTest <Problems> �ϻ��� �� [1-45]
 *
 *	io.IOException : ����� ó���� ����, �Ǵ� ���ͷ�Ʈ�� �߻��� ���� �ۼ��Ǵ� ������ �Ϲ����� Ŭ���� 
 *					  ��� ����� ������ �߻��� �����ϴ� �ñ׳��� �߻�
 *
 *	sum += a % 10 : x�� ���� ������ �� sum�� ����
 *	a /= 10 : 10������ �ڸ��� �ٲٱ�(while�� in)
 */
public class NumberOfHisshads {

	
	public boolean numberOfHisshads(int x) {
        boolean answer = true;
        return answer;
    }
	
	
	
	
	// [�ַ��1] 'a%10'�� 'a/=10'���� �����ϴ� ���
	public boolean numberOfHisshads_1(int x) throws IOException {
		int sum = 0;
		int a = x;
      
		while (a >= 1) {
			sum += a % 10; //x�� ���� ������ �� sum�� ����
			a /= 10; // 10������ �ڸ��� �ٲٱ�
		}
 
		if (x % sum == 0) {
			return true;
		} else
			return false;
	}
	
	
	
	
	// [�ַ��2] valueOf().split("")���� �и��ؼ� �����ϴ� ���
	public boolean numberOfHisshads_2(int x) {
		String[] temp = String.valueOf(x).split("");

	    int sum = 0;
	    for (String s : temp) {
	        sum += Integer.parseInt(s);
	    }

	    if (x % sum == 0) {
	            return true;
	    } else {
	      return false;
	    }
	}
	
	
	
	
	// [�ַ��3] ���ٽ��� �̿��ؼ� ���ڸ� ������ �����ϴ� ���
	public boolean numberOfHisshads_3(int x) {
		sum = 0;
        Integer.toString(x).chars().forEach(c -> sum += c - '0');
        return x % sum == 0;
	}
	private int sum = 0;
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
