package level_1;

import java.util.ArrayList;

/**
 * @codingTest <3���� ������>
 *
 */
public class TernaryFlip {

	
	//N�� 3�������� �ٲٴ� ���� ���� -> �յڹ��� 3�������� temp�� �ٷ� ���� �ַ��
	public int ternaryFlip_1(int n) {
		int answer = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        
        // 10���� -> 3����(����)
        while(true){
            if(n<3){ temp.add(n); break; } //3���� ���� �� ���� �� �׳� �ֱ�
            temp.add(n%3); //3���� ���� ���� �ֱ�
            n = n/3;
        }
        // 3����(����) -> 10����
        for(int i=0; i<temp.size(); i++){
            answer += (Math.pow(3,temp.size()-i-1)*temp.get(i));
        }
        
        return answer;
    }
	
	
	
	
	//3�������� ��ȯ�ϰ� ���ڿ� ������ 10�������� ��ȯȯ �ַ��
	public int ternaryFlip_2(int n) {
		 String s = "";
		 
	        while(n != 0){
	 
	            //3���� ��ȯ
	            if( (n % 3) < 10 ) {
	 
	                s = (n % 3) + s;
	 
	                n /= 3;
	            }
	 
	        }
	 
	 
	        int res = 0;
	        int r = 1;
	        //���ڿ� ������ �� 10��������
	        for(int i=0; i<s.length(); i++) {
	            res += Integer.parseInt(s.charAt(i)+"")*r;
	            r*=3;
	        }
	 
	        return res;

	}
	
	
	
	//���� ������ ����Ʈ �ַ��
	public int ternaryFlip_3(int n) {
		String a = "";

        while(n > 0){
            a = (n % 3) + a;
            n /= 3;
        }
        a = new StringBuilder(a).reverse().toString();


        return Integer.parseInt(a,3);
	}
	
	
	
	//
	public int ternaryFlip(int n) {
		int answer = 0;
		return answer;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
