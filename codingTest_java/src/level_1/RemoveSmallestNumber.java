package level_1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @codingTest <Problems> 제일 작은 수 제거하기 [1-40]
 * 
 *	한 메서드에 return이 여러개 있을 수 있다. (지역의 지역)
 *
 *	getAsInt() : 저장된 값을 Int형으로 얻는 메서드
 *	stream.min() : stream으로 최솟값 구하는 메서드
 *	toArray() : List의 인스턴스를 배열(array)로 만드는 메서드
 *
 *	<최솟값구하기>
 *	int min = (int)Arrays.stream(a).min().getAsInt(); 
 *
 *	<최댓값구하기>
 *	int max = (int)Arrays.stream(b).max().getAsInt();
 */
public class RemoveSmallestNumber {

	
	public int[] removeSmallestNumber(int[] arr) {
        int[] answer = {};
        return answer;
    }
	
	
	
	
	// [솔루션1]
	public int[] removeSmallestNumber_1(int[] arr) {
		int min = arr[0];
	      int[] answer = new int[arr.length - 1];

	      if (arr.length <= 1) { //배열의 길이가 1이거나 없으면 
	         int[] answer2 = { -1 };
	         return answer2;
	      }


	         for (int i = 0; i < arr.length; i++) { 

	            if (min > arr[i]) { //최솟값보다 수가 작으면
	            	// 3 > 5 (최솟값보다 큼)
	            	// 5 > 3 (최솟값보다 작으므로 최솟값은 5에서 3으로 변경)
	               min = arr[i]; 
	            }	

	         }
	           int index = 0;
	         for (int j = 0; j < arr.length; j++) {
	            if (min == arr[j]) { //최솟값이면
	               continue; //제외 하고 계속 진행 -> 작은수 분류
	            } else { 
	               answer[index++] = arr[j];
	            }

	         }


	      return answer;
	}
	
	
	
	
	// [솔루션2] Array와 ArrayList 클레스를 사용한 방법
	public int[] removeSmallestNumber_2(int[] arr) {
		// sort를 이용해서 최솟값 가져오기    
				int[] temp = arr.clone(); //복사
				Arrays.sort(temp); //정렬
				int min = temp[0];
				//ArrayList를 이용하여 최솟값과 같지 않은 수만 추가
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int i = 0; i < arr.length; i++) {
					if(arr[i] != min) { //최솟값이 아니면 넣기
						list.add(arr[i]);
					}
				}
				
				int[] answer;
				// 경우를 나눠서 배열에 값을 저장하기		
				if(list.size() == 0) { //list 크기가 0이면
					answer = new int[1];
					answer[0] = -1;
				} else { // 내용이 있으면
					answer = new int[list.size()];
					for (int i = 0; i < list.size(); i++) {
						answer[i] = list.get(i);
					}
				}
				
		        return answer;        
	}
	
	
	
	
	// [솔루션3] 스트림과 Array클래스를 활용한 방법
	public int[] removeSmallestNumber_3(int[] arr) {
		if (arr.length <= 1) return new int[]{ -1 }; //1보다 작거나 같으면 -1 리턴
	      int min = Arrays.stream(arr).min().getAsInt();
	      return Arrays.stream(arr).filter(i -> i != min).toArray();
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
