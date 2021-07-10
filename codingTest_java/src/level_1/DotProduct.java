package level_1;

/**
 * @codingTest <Problems> 내적 [1-5]
 * a,b 배열의 동일한 인덱스의 요소를 더하고 그 값들을 더해준다.
 */
public class DotProduct {
	
	public int dotProduct(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
			answer += a[i] * b[i];
		}
        return answer;
    }
	
	

	
	public int dotProduct_1(int[] a, int[] b) {
		int answer = 0;
		for (int i = 0; i < a.length; i++) {
			answer += a[i]*b[i];
		}
		return answer;
	}
	
	
	
	
	public int dotProduct_2(int[] a, int[] b) {
		int total = 0;
		
		for (int i = 0; i < a.length; i++) {
			int multiple = a[i] * b[i];
			total += multiple;
		}
//		System.out.println(total);
		return total;
	}
	
	
	
	
	public int dotProduct_3(int[] a, int[] b) {
		int answer = dotProductFv(a,b);
		return answer;
	}
	
	
	private static int dotProductFv(int[] a, int[] b) {
		int dp = 0;
		
		for (int i = 0; i < a.length; i++) {
			dp += a[i] * b[i];
		}
		return dp;
	}
	
	
	
	public static void main(String[] args) {
		DotProduct dp = new DotProduct();
		int[] a = {1,2,3,4};
		int[] b = {-3,-1,0,2};
		
		int[] a2 = {-1,0,1};
		int[] b2 = {1,0,-1};
		
		System.out.println(dp.dotProduct(a, b));
		System.out.println(dp.dotProduct(a2, b2));
		System.out.println(dp.dotProduct_1(a, b));
		System.out.println(dp.dotProduct_1(a2, b2));
		System.out.println(dp.dotProduct_2(a, b));
		System.out.println(dp.dotProduct_2(a2, b2));
		System.out.println(dp.dotProduct_3(a, b));
		System.out.println(dp.dotProduct_3(a2, b2));
	}

}
