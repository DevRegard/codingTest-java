package level_1;

/**
 * @codingTest <Problems> ����� �� [1-34]
 * 	
 * 	n % i == 0 �̸� ���
 */
public class SumOfFactors {

	
	public int sumOfFactors(int n) {
        int answer = 0;
        return answer;
    }
	
	
	
	
	// [�ַ��1] n/2 �� ������ ���ڸ� �����ؼ� �ذ��ϴ� ��� (����Ʈ�� ��� ����� ���� ����)
	public int sumOfFactors_1(int num) {
			int answer = 0;
        
        for (int i = 1; i <= num/2; i++) {
			if (num % i == 0) answer += i;
		}
        return answer + num;
	}
	
	
	
	
	// [�ַ��2] ��� ���ڸ�ŭ �ݺ��ؼ� �����ϴ� ��� (���� 2��� ����)
	public int sumOfFactors_2(int num) {
		int answer = 0;
        for(int i = 1; i<= num ; i++){
	    if(num % i ==0){
	        answer += i;
	    }
	  }
	    return answer;
	}
	
	
	
	
	// [�ַ��3]
	public int sumOfFactors_3(int num) {
		int answer = 0;    
        int count = 1;
        int i = 1;

        while(num>i){
            if(num%i==0){
                count++;
                i++;
            }else{
                i++;
            }
        }

        int[] numDiv = new int[count];

        i=1;
        int count2=0;
        while(num>i+1){
            if(num%i==0){
                numDiv[count2] = i;
                i++;
                count2++;
            }else{
                i++;
            }
        }
    if(numDiv[numDiv.length-1]==0){
            numDiv[numDiv.length-1] = num;
        }
        for(int j=0; j<numDiv.length;j++){
            answer += numDiv[j];
        }


        return answer;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
