package level_1;

/**
 * @codingTest <Problems> �Ҽ� ã�� [1-30]
 *
 *	Math.sqrt() : �Ű������� �������� ���ϴ� �Լ�
 */
public class FindDecimals {

	
	public int findDecimals(int n) {
        int answer = 0;
        return answer;
    }
	
	
	
	
	// [�ַ��1] �����佺���׳׽��� ü�� Ȱ���� �Ҽ�ã�� �ڵ�, Math.sqrt() Ȱ������ �ð����⵵ ���� ����
	public int findDecimals_1(int n) {
		int answer = 0; 
		boolean[] sosu =new boolean [n+1]; 
		
		for(int i=2; i<=n ; i++) 
			sosu[i]=true; //2~n��°���� true�� �ʱ�ȭ 
		
		//������ ���ϱ� 
		int root=(int)Math.sqrt(n); 
		for(int i=2; i<=root; i++){ //2~��Ʈn���� �˻� 
			if(sosu[i]==true){ //i��°�� ���� �Ҽ��� ��
			for(int j=i; i*j<=n; j++) //�� ������� �� false�� �ʱ�ȭ(����� �Ҽ��� �ƴϱ� ����) 
				sosu[i*j]=false; 
			} 
		} 
	
		for(int i =2; i<=n; i++) { 
			if(sosu[i]==true) //�Ҽ��� ���� ���� 
			answer++; 
			} 
		
		return answer;
	}
	
	
	
	
	// [�ַ��2] ��� ����� ������� �Ҽ��� �����ϴ� ���
	public int findDecimals_2(int n) {
		int answer = 0; 
		
		for(int i = 2; i <= n; i++){ 
			boolean chk = true;
			for(int j = 2; j*j <= i; j++){ //��� ����� 
				if(i % j == 0){ 
					chk = false; 
					break; 
					} 
				} 
				if(chk){ 
					answer++; 
					} 
				} 
			return answer;
		}

	
	
	
	
	// [�ַ��3] j=i �� �������� �ؼ� �Ҽ��� �Ǻ��ϴ� ���
	public int findDecimals_3(int n) {
		 int result = 0;
	        for(int i=2; i<=n; i++){
	        for(int j=2; j<=i; j++){
	        if(j == i){
	            ++result;
	        } else if(i%j == 0){
	            break;
	        }
	      }
	    }

	        return result;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
