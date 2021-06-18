package level_1;

import java.util.ArrayList;

/**
 * @codingTest <3진법 뒤집기>
 *
 */
public class TernaryFlip {

	
	//N을 3진법으로 바꾸는 과정 생략 -> 앞뒤반전 3진법수를 temp에 바로 넣은 솔루션
	public int ternaryFlip_1(int n) {
		int answer = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        
        // 10진법 -> 3진법(역순)
        while(true){
            if(n<3){ temp.add(n); break; } //3으로 나눌 수 없는 수 그냥 넣기
            temp.add(n%3); //3으로 나눈 수들 넣기
            n = n/3;
        }
        // 3진법(역순) -> 10진법
        for(int i=0; i<temp.size(); i++){
            answer += (Math.pow(3,temp.size()-i-1)*temp.get(i));
        }
        
        return answer;
    }
	
	
	
	
	//3진법으로 변환하고 문자열 뒤집고 10진법으로 변환환 솔루션
	public int ternaryFlip_2(int n) {
		 String s = "";
		 
	        while(n != 0){
	 
	            //3진법 변환
	            if( (n % 3) < 10 ) {
	 
	                s = (n % 3) + s;
	 
	                n /= 3;
	            }
	 
	        }
	 
	 
	        int res = 0;
	        int r = 1;
	        //문자열 뒤집은 후 10진법으로
	        for(int i=0; i<s.length(); i++) {
	            res += Integer.parseInt(s.charAt(i)+"")*r;
	            r*=3;
	        }
	 
	        return res;

	}
	
	
	
	//가장 간결한 베스트 솔루션
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
