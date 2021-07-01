package level_1;

/**
 * @codingTest <Problems> ����� ���� [1-47]
 *
 *	Math.max(a,b) : �� �� ���� ū ���� �����ؼ� ��ȯ�ϴ� �޼���
 */
public class AdditionOfMatrices {

	
	public int[][] additionOfMatrices_(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        return answer;
    }
	
	
	
	
	// [�ַ��1] arr1.length�� arr1[0].length�� �޸� �Ҵ��ϴ� ���
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
	
	
	
	
	// [�ַ��2] Math Ŭ������ ����� ��� (�������� ���� ����, �˰������δ� ���ʿ��� ���)
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
	
	
	
	
	// [�ַ��3] arr1 �� �޸� �Ҵ��ؼ� �ذ��� ���
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
