package level_1;

/**
 * @codingTest ���� ���ϱ�
 *
 */
public class AddYinYang {

	
    public int addYinYang(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for (int i = 0; i < signs.length; i++) {
			if (signs[i]) { //true(���)�̸�
				answer += absolutes[i]; //�״�� ���ϱ�
			} else { //false(����)�̸�
				answer -= absolutes[i];
			}
		}
        return answer;
    }
    
    
    
    
    public int addYinYang_1(int[] absolutes, boolean[] signs) {
    	int answer = 0;
    	
    	for (int i = 0; i < signs.length; i++) { //��ȣ ������ŭ �ݺ�
			if (signs[i]) { //���̸� ���ϱ�
				answer += absolutes[i]; 
			} else { //�����̸� ����
				answer -= absolutes[i];
			}
		}
    	return answer;
    }
    
    
    
    
    public int addYinYang_2(int[] absolutes, boolean[] signs) {
    	int answer = 0;
    	for (int i = 0; i < signs.length; i++) { //signs �迭 ���̸�ŭ �ݺ�
			answer += absolutes[i] * (signs[i] ? 1:-1); //���̸� ����� ���ϰ�, �����̸� ������ answer�� ���Ѵ�.
		}
    	return answer;
    }
    
    
    
    
    public int addYinYang_3(int[] absolutes, boolean[] signs) {
    	int answer = 0;
    	
    	for (int i = 0; i < absolutes.length; i++) { //���ڹ迭 ���̸�ŭ �ݺ�
			if (signs[i] == false) { //��ȣ�� �����̸�
				absolutes[i] *= -1; //���ڹ迭�� ������ �ٲ۴�.
			} 
			answer += absolutes[i]; //����� ������ ���� �迭�� ���� ���Ѵ�.
		}
    	return answer;
    }
    
    
    
    
	public static void main(String[] args) {
		AddYinYang ayy = new AddYinYang();
		int[] absolutes = {4,7,12};
		boolean[] signs = {true,false,true};
		
		System.out.println(ayy.addYinYang(absolutes, signs));
		System.out.println(ayy.addYinYang_1(absolutes, signs));
		System.out.println(ayy.addYinYang_2(absolutes, signs));
		System.out.println(ayy.addYinYang_3(absolutes, signs));
	}

}
