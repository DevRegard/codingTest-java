package level_1;

/**
 * @codingTest <Problems> 소수 찾기 [1-30]
 *
 *	Math.sqrt() : 매개변수의 제곱근을 구하는 함수
 */
public class FindDecimals {

	
	public int findDecimals(int n) {
        int answer = 0;
        return answer;
    }
	
	
	
	
	// [솔루션1] 에라토스스테네스의 체를 활용한 소수찾기 코드, Math.sqrt() 활용으로 시간복잡도 대폭 낮춤
	public int findDecimals_1(int n) {
		int answer = 0; 
		boolean[] sosu =new boolean [n+1]; 
		
		for(int i=2; i<=n ; i++) 
			sosu[i]=true; //2~n번째수를 true로 초기화 
		
		//제곱근 구하기 
		int root=(int)Math.sqrt(n); 
		for(int i=2; i<=root; i++){ //2~루트n까지 검사 
			if(sosu[i]==true){ //i번째의 수가 소수일 때
			for(int j=i; i*j<=n; j++) //그 배수들을 다 false로 초기화(배수는 소수가 아니기 때문) 
				sosu[i*j]=false; 
			} 
		} 
	
		for(int i =2; i<=n; i++) { 
			if(sosu[i]==true) //소수의 개수 세기 
			answer++; 
			} 
		
		return answer;
	}
	
	
	
	
	// [솔루션2] 배수 지우기 방식으로 소수를 선별하는 방법
	public int findDecimals_2(int n) {
		int answer = 0; 
		
		for(int i = 2; i <= n; i++){ 
			boolean chk = true;
			for(int j = 2; j*j <= i; j++){ //배수 지우기 
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

	
	
	
	
	// [솔루션3] j=i 를 조건으로 해서 소수를 판별하는 방법
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
