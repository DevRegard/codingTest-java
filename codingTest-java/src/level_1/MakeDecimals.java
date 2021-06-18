package level_1;

/**
 * @codingTest <�Ҽ� �����>
 *
 */
public class MakeDecimals {

	
	//3�� for�� ��, �Ҽ� �Ǻ��� �ַ��
    public int makeDecimals_1(int[] nums) {
    	int answer = 0;

        for(int i=0;i<=nums.length-3;i++){
            for(int j=i+1;j<=nums.length-2;j++){
                for(int k=j+1;k<=nums.length-1;k++){
                    if(calc(nums[i]+nums[j]+nums[k])){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
	    
	    
	//�ַ��1  �޼���
    public static boolean calc(int sum){

        int cnt=0;

        for(int i=1;i<=sum;i++){
            if(sum%i==0){
                cnt++;
            }
        }
        if(cnt==2){
            return true;
        }else{
            return false;
        }
    
    }
	
	
    
	
	//ù��° �ַ�ǰ� ����� �ַ�� (�񱳹������)
	public int makeDecimals_2(int[] nums) {
		int ans = 0;

        for(int i = 0; i < nums.length - 2; i ++){
            for(int j = i + 1; j < nums.length - 1; j ++){
                for(int k = j + 1; k < nums.length; k ++ ){
                    if(isPrime(nums[i] + nums[j] + nums[k])){
                        ans += 1;  
                    } 
                }
            }
        }
        return ans;
	}
	
	
	//�ַ��2 �޼���
	public Boolean isPrime(int num){
        int cnt = 0;
        for(int i = 1; i <= (int)Math.sqrt(num); i ++){
            if(num % i == 0) cnt += 1; 
        }
        return cnt == 1;
    }
	
	
	
	
	//�޼��� �ϳ��� ����� �ַ��
	public int makeDecimals_3(int[] nums) {
		int answer = 0;
        int sum =0;
        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    if(i!=j&&i!=k&&j!=k) {
                        sum= nums[i]+nums[j]+nums[k];
                        for(int l=2; l<sum; l++) {
                            if(sum%l==0) {
                                break;
                            }
                            if(l==sum-1) {
                                answer++;
                            }
                        }
                    }
                }
            }
        }

        return answer;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
	
