package level_1;

/**
 * @codingTest <Problems> ¦���� Ȧ�� [1-41]
 *
 */
public class EvenAndOdd {

	
	public String evenAndOdd(int num) {
        String answer = "";
        return answer;
    }
	
	
	
	
	// [�ַ��1] N%2==0�� if������ ������ �Ϲ����� ���
	public String evenAndOdd_1(int num) {
		String answer = "";
        
        if(num%2==0){
            answer = "Even";
        } else {
            answer = "Odd";
        }
        return answer;
	}
	
	
	
	
	
	// [�ַ��2] ���Ϲ����� ���׿����ڸ� ����� ���
	public String evenAndOdd_2(int num) {
		return num % 2 == 0 ? "Even": "Odd";
	}
	
	
	
	
	
	// [�ַ��3] 'N % 2'���� ������ ����� ��� 
	public String evenAndOdd_3(int num) {
		String result = "";
        int val = num % 2;

        if(val == 0){
          result = "Even";
        }else if(val == 1){
          result = "Odd";
        }

        return result;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
