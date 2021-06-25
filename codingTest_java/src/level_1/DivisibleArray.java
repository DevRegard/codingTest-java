package level_1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @codingTest <Problems> 나누어 떨어지는 숫자 배열 [1-23]
 *
 *	isEmpty() : 비어있는가?
 *	Arrays.stream() : 
 *	stream().filter(요쇼 -> 조건) :
 *	toArrays() : 배열로 변경
 */
public class DivisibleArray {

	
	public int[] divisibleArray(int[] arr, int divisor) {
        int[] answer = {};
        return answer;
    }
	
	
	
	
	// [솔루션1] ArrayList, 
	public int[] divisibleArray_1(int[] arr, int divisor) {
		 int[] answer = {};
         ArrayList<Integer> a1 = new ArrayList<Integer>();
         
         for(int i=0; i<arr.length; i++) {
             if(arr[i]%divisor==0) a1.add(arr[i]); //나누어 떨어지면 ArrayList에 추가
         }
         
         if(a1.isEmpty()) { // 비어있으면
             a1.add(-1);
         }
         
         answer = new int[a1.size()];
         
         for(int i=0; i<a1.size(); i++) {
             answer[i] = a1.get(i);
         }
         
         Arrays.sort(answer); //Arrays를 순서대로 정렬
         
         return answer;
	}
	
	
	
	
	// [솔루션2] Arrays.stream().filter() 한 줄로 끝내버리는 방법
	public int[] divisibleArray_2(int[] arr, int divisor) {
		return Arrays.stream(arr).filter(element -> element%divisor==0).toArray();
		// 테스트케이스 1과 2 추가로 
		// sort()와 반환값 -1이 없어서 테스트로는 통과되지 않는다.
	}
	
	
	
	
	// [솔루션3] 솔루션2에서 테스트케이스 2,3을 만족할 수 있도록 보완된 방법
	public int[] divisibleArray_3(int[] arr, int divisor) {
		int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
        if(answer.length == 0) answer = new int[] {-1};
        java.util.Arrays.sort(answer);
        return answer;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
