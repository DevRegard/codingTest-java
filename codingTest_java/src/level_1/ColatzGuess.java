package level_1;

/**
 * @codingTest <Problems> �ݶ��� ���� [1-43]
 *	�ݶ��� ���� : ¦���� 2n, Ȧ���� 3n+1 �� �ݺ��ؼ� ��� ���ڰ� 1�� �ȴ�.
 *	�ݶ��� ������ ���� : ���� ��� �ڿ����� �������� �������� ���ؼ��̴�. ��ǻ�ͷ� 2^68 ���� ���� [21-06-29]
 *				  27�� �����Ϸ��� 111���� ���ľ� �ϰ�, 77��°�� 9232�� ������ �ȴ�.
 */
public class ColatzGuess {

	
	public int colatzGuess(int num) {
        int answer = 0;
        return answer;
    }
	
	
	
	
	// [�ַ��1] for���� Ƚ���� 500������ �����ϰ�, long���� ����ȯ, ���׿����ڸ� ������ ���
	public int colatzGuess_1(int num) {
		long n = (long)num;
	    for(int i =0; i<500; i++){ //�ڿ��� 626331�� �����Ϸ��� 500�� �ʰ� (����� ����� -1�� ���ϵǾ���)
	      if(n==1) return i;
	      n = (n%2==0) ? n/2 : n*3+1;            
	    }
	    return -1;
	}
	
	
	
	
	// [�ַ��2] ���ǹ��� ����� ���
	int answer = 0;
	public int colatzGuess_2(int num) {
		
		if(num == 1){ //����� 1�� �Ǹ�
            return answer;
        }
        if(answer==500){ //����� 500ȸ�� �Ǹ�
            return -1;
        }
        answer++; //����� 1�� �����ϸ� 1�� ����
        if (num % 2 == 1) {
            // Ȧ��
            return colatzGuess_2(num * 3 + 1);
        } else{
            // ¦��
            return colatzGuess_2(num / 2);
        }
	}
	
	
	
	
	// [�ַ��3] While���� ���ϰ� ���ǹ��� ����� ���
	public int colatzGuess_3(int num) {
		int answer = 0;
        int cnt = 0;

        while (cnt <= 501) {

            if (num % 2 == 0) {
                if (num != 1) {
                    num = num / 2;
                    cnt++;
                    answer = cnt;
                } else {
                    break;
                }
            } else {
                if (num != 1) {
                    num = (num * 3) + 1;
                    cnt++;
                    answer = cnt;
                } else {
                    break;
                }
            }

            if (cnt > 500) {
                answer = -1;
            } else if (cnt <= 500 && num == 1) {
                break;
            } else
                continue;
        }

        return answer;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
