package level_1;

import java.util.Arrays;

/**
 * @codingTest <Problems> 평균 구하기 [1-44]
 *
 *	API 이용하면 속도는 현저하게 낮아진다. -> 알고리즘은 시간복잡도를 낮추는게 핵심 목적
 *
 *
 *	Arrays.stream() : 저장 요소를 하나씩 참조해서 람다식으로 처리할 수 있도록 해주는 반복자
 *					  (Iterator와 유사, -> 람다식은 더 간결하고 병렬처리가능)
 *
 *	stream().average() : 스트림에서 평균구하는 메서드
 *
 *	orElse(0) : 값이 null이 아니여도  호출 및 리턴 지정 
 *				-> 0 != null ? 0 : other;
 *				== 값이 없으면 0을 리턴한다.				
 *
 *	orElseGet() : null 이여야 호출 -> value != null ? value : other.get();
 */
public class Average {

	
	public double average(int[] arr) {
        double answer = 0;
        return answer;
    }
	
	
	
	
	// [솔루션1] 총합을 구하고, 총합에서 배열의 길이만큼 나누는 기본적인 방법
	public double average_1(int[] arr) {
		double answer = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		answer = (double) sum / arr.length;
		return answer;
	}
	
	
	
	
	// [솔루션2] Arrays.stream(), Average()를 활용한 방법
	public double average_2(int[] arr) {
		return (int) Arrays.stream(arr).average().orElse(0);
	}
	
	
	
	
	// [솔루션3] 배열이 null인 경우를 대비한 방법 <특정상황 에러방지 코드>
	public double average_3(int[] arr) {
		if(arr == null){
	        return 0;
	      }

	      int ret = 0;
	      if(arr != null){
	        for(int n : arr){
	            ret += n;
	        }
	      }
	        return ret / arr.length;
	    }
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
