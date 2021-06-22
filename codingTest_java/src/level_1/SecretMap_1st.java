package level_1;

/**
 * @codingTest <[1차] 비밀지도>
 *
 */
public class SecretMap_1st {

	
	public String[] secretMap_1st(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        return answer;
    }
	
	
	
	
	// [솔루션1] 2진수를 직접 계산해서 적용한 방법 
	public String[] secretMap_1st_1(int n, int[] arr1, int[] arr2) {
		 String[] answer = new String[n]; 
	        
	        // 2. 배열의 크기만큼 반복.
	        for(int i =0;i<n;i++){
	            // 2-1. 변환한 이진수 저장 변수 및 논리연산 결과 저장 변수.
	            String str_x,str_y,str="";
	            // 2-2. 각 배열에서 정수 저장.
	            int x = arr1[i];
	            int y = arr2[i];
	            // 2-3. 이진수로 변환 및 자릿수 채우기.
	            str_x = cal(x,n);
	            str_y = cal(y,n);
	            // 2-4. 조건에 맞게 문자열 포맷 변경.
	            for(int j = 0;j<n;j++){
	                if(str_x.charAt(j) == '1' || str_y.charAt(j) == '1') str+="#";
	                else str+=" ";
	            }
	            // 2-5. 한 줄 완성.
	            answer[i] = str;
	        }
	        
	        return answer;
	}
	
	
	// [솔루션1]
	// 1. 이진수 변환 메소드 및 자리수 n에 맞게 0을 채우기.
    public static String cal(int n,int len){
        String str="";
        
        // 1-1. 이진수 변환.
        while(n != 0){
            str = n%2 + str;
            n/=2;
        }
        
        // 1-2. n 자릿수 채우기.
        while(str.length() != len){
            str = "0"+str;
        }
        
        return str;
    }
	
	
	
	
	// [솔루션2] 이진수변환 메서드 toBinaryString(), format(), replaceALL()를 활용한 방법
	public String[] secretMap_1st_2(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n]; 
        
        for(int i =0;i<n;i++){
            // 1. arr1과 arr2의 원소들을 이진수로 바꾼 뒤, or 비트 논리연산 수행.
            String str=Integer.toBinaryString(arr1[i] | arr2[i]);
            // 2. 5자리의 문자열 형태로 포맷변경, 5자리가 안되는 이진수의 나머지는 공백으로 채운다.
            str = String.format("%"+n+"s",str);
            // 3. 1->#, 0 -> 공백 으로 바꾼다.
            str = str.replaceAll("1" , "#");
            str = str.replaceAll("0" , " ");
            // 4. 한 줄 완성.
            answer[i] = str;
        }
        
        return answer;
	}
	
	
	
	
	// [솔루션3] 재귀함수를 사용한 방법
	public String[] secretMap_1st_3(int n, int[] arr1, int[] arr2) {
		 String [] answer = new String[n];
	        int [] secretMap = new int[n];
	        for(int i = 0; i < n; i++) {
	            secretMap[i] = arr1[i] | arr2[i];
	            answer[i] = makeSharp(secretMap[i], n);
	        }
	        return answer;
	}
	
	
	// [솔루션3] 재귀함수
	public String makeSharp(int n, int m) {
        if(n == 0) {
            if( m > 0) {
                String str = "";
                for(int i = 0; i < m; i++) {
                    str += " ";
                }
                return str;
            }
            else return "";
        }
        else {
            return n % 2 == 0 ? makeSharp(n/2, m-1) + " " : makeSharp(n/2, m-1) + "#"; 
        }
    }
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
