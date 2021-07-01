package level_1;

/**
 * @codingTest <Problems> 행렬의 덧셈 [1-47]
 *
 *	Math.max(a,b) : 둘 중 가장 큰 수를 선택해서 반환하는 메서드
 */
public class AdditionOfMatrices {

	
	public int[][] additionOfMatrices_(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        return answer;
    }
	
	
	
	
	// [솔루션1] arr1.length와 arr1[0].length로 메모리 할당하는 방법
	public int[][] additionOfMatrices_1(int[][] arr1, int[][] arr2) {
		int[][] answer = {};
	      answer = new int[arr1.length][arr1[0].length];
	      for(int i =0; i<arr1.length; i++ ){
	          for(int j =0; j<arr1[i].length; j++){
	              answer[i][j] = arr1[i][j] + arr2[i][j];
	          }
	      }
	      return answer;
	}
	
	
	
	
	// [솔루션2] Math 클래스를 사용한 방법 (현업에서 사용시 적합, 알고리즘으로는 불필요한 요소)
	public int[][] additionOfMatrices_2(int[][] A, int[][] B) {
		int row = Math.max(A.length, B.length);
	    int col = Math.max(A[0].length, B[0].length);
	        //int[][] answer = {{0, 0}, {0, 0}};
	    int[][] answer = new int[row][col];
	    for(int i=0; i<row ; i++){
	      for(int j=0; j<col; j++){
	        answer[i][j] = A[i][j] + B[i][j];
	      }
	    }

	        return answer;
	}
	
	
	
	
	// [솔루션3] arr1 만 메모리 할당해서 해결한 방법
	public int[][] additionOfMatrices_3(int[][] arr1, int[][] arr2) {
		int[][] answer = {};
        answer = arr1;
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr1[0].length; j++){
                answer[i][j] += arr2[i][j];
            }
        }
        return answer;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
