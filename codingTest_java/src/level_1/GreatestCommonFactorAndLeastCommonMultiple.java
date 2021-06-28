package level_1;

/**
 * @codingTest <Problems> 최대공약수와 최소공백수 [1-42]
 *
 *	GCD : Greatest Common divisor == 최대공약수
 *
 *	유클리드 호제법 <Euclidean algorithm> : (a,b)의 최대공약수는 (b,r)의 최대공약수와 같다.
 *		GCD(a,b) == GCD(b,r) 
 *
 *		EX) (581,322)
 *		GCD(581, 322) = GCD(322, 259) = GCD(259, 63) =  GCD(63, 7) = GCD(7, 0) = 7
 *	
 */
public class GreatestCommonFactorAndLeastCommonMultiple {

	
	public int[] greatestCommonFactorAndLeastCommonMultiple_(int n, int m) {
        int[] answer = {};
        return answer;
    }
	
	
	
	
	// [유클리드 호제법]
	public static int gcd(int a, int b) {
		
		while (b != 0) {
			int r = a % b; // 나머지를 구해준다.
			
			// GCD(a, b) = GCD(b, r)이므로 변환한다.
			a = b;
			b = r;
		}
		return a;
	}
	
	
	
	
	// [솔루션1] 유클리드 호제법과 재귀함수를 사용한 방법
	public int[] greatestCommonFactorAndLeastCommonMultiple_2(int n, int m) {
		int[] answer = new int[2];
		answer[0] = gcd(n, m);
		answer[1] = n * m / answer[0];
		return answer;
	}
	
	
	
	
	
	// [솔루션2] 유클리드 호제법을 메서드 안에서 적용하고 바로 최대공약수와 최대공배수를 구하는 방법
	public int[] greatestCommonFactorAndLeastCommonMultiple_1(int a, int b) {
		int[] answer = new int[2];
	      int temp=1;
	      int gcd=a*b;
	      while(temp!=0){
	      temp=b%a;
	        b=a;
	        a=temp;
	      }
	      answer[0]=b;
	      answer[1]=gcd/b;
	        return answer;
	}
	
	
	
	
	// [솔루션3] 호제법을 사용하지 않고 최대공배수와 최대공약수를 구하는 방법 (시간복잡도는 증가)
	public int[] greatestCommonFactorAndLeastCommonMultiple_3(int a, int b) {
		int[] answer = new int[2];
        int mini = 0;
        int maxi = 1;

        //최대공배수
        for(int i = 1; i<=a; i++) 
            if(a%i==0 && b%i==0)
                maxi = i;

        //최대공약수
        for(int i = a*b; i>0; i--)
            if(i%a==0 && i%b==0)
                mini = i;

        answer[0] = maxi;
        answer[1] = mini;

        return answer;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
