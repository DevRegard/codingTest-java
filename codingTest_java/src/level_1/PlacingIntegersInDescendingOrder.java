package level_1;

import java.util.Arrays;

/**
 * @codingTest <Problems> 정수 내림차순으로 배치하기 [1-38]
 *
 *	버블정렬 : 인접한 두 개의 값을 비교하여 더 큰 값을 우측으로 보내는 정렬 알고리즘
 *				1. 수행속도가 매우 빠르다.
 *				2. 구현이 쉽다.
 *				3. 역으로 정렬되어 있는 배열은 시간 복잡도가 제곱수 배로 증가한다. = 효율 급감
 *
 *	toString() : String형으로 변환 (안전한 코딩, 유니코드변환 방지 효과)
 *	chars() : int값을 반환(char형이 아니다.)
 *	sorted() : 정렬하는 메서드
 *	forEach(변수 - > 반복처리(변수)) :
 */
public class PlacingIntegersInDescendingOrder {

	
	public long placingIntegersInDescendingOrder(long n) {
        long answer = 0;
        return answer;
    }
	
	
	
	
	// [솔루션1] 버블정렬을 활용한 해결 방법
	public long placingIntegersInDescendingOrder_1(long n) {
		// String.valueof() 메소드를 통하여 long타입을 String타입으로 변경 후,
        // String.toCharArray() 메소드를 통하여 String타입을 char[]로 변경한다.
        char[] arr = String.valueOf(n).toCharArray();
 
        // 임시 char변수
        char temp = 'a';
        // 버블정렬을 통한 숫자 재배치
        for(int i = arr.length - 1; i > -1; i--) {
            for(int j=0; j < i; j++) {
                if(arr[j] < arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        // char[] → String
        String str = "";
        for(char i : arr) {
            str += i;
        }
        // Long.parseLong()메소드를 통하여 String → Long타입 변환
        return Long.parseLong(str);
	}
	
	
	
	
	// [솔루션2] 람다식 forEach()을 활용한 방법
	String res = "";
	public int placingIntegersInDescendingOrder_2(int n) {
		res = "";
        Integer.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char)c) + res);
        return Integer.parseInt(res);
	}
	
	
	
	
	// [솔루션3] StringBuilder 클래스를 사용한 방법
	public long placingIntegersInDescendingOrder_3(int n) {
		String str = Integer.toString(n);
        char[] c = str.toCharArray();
        Arrays.sort(c);
        StringBuilder sb = new StringBuilder(new String(c,0,c.length));  
        return Integer.parseInt(((sb.reverse()).toString()));
	}
	
	
	
	
	// [버블정렬]
	public static void testArraySort2() {
        
        // 버블정렬(Bubble Srot) : 왼쪽(작은값) 오른쪽(큰값)으로 마지막까지 교차 교환
        // 인접한 두 개의 값을 비교하여
        // 더 큰값을 우측으로 보내는 정렬 알고리즘
        // 이미 정렬이 어느 정도 되어 있는 데이터에
        // 대한 수행속도가 매우 빠르며, 구현이 쉽다.
        // 단, 역으로 정렬되어 있는 배열을 정렬 할 때에는
        // 시간 복잡도가 제곱수 배로 증가하여 효율이 급격히 떨어진다.
    
        int[] array = {6,4,2,1,3,5}; //array.length = 6, []는 5까지
        // 4, 6, 2, 1, 3, 5
        // 4, 2, 6, 1, 3, 5
        // 4, 2, 1, 6, 3, 5
        // 4, 2, 1, 3, 6, 5
        // 4, 2, 1, 3, 5, 6
        
        // 2, 4, 1, 3, 5, 6
        // 2, 1, 4, 3, 5, 6
        // 2, 1, 3, 4, 5, 6
        // 2, 1, 3, 4, 5, 6
        
        // 1, 2, 3, 4, 5, 6
        int temp = 0; // 교환용 임시 변수
        
        // 배열의 길이 -1 (마지막 숫자 제외)
        for(int i = array.length - 1; i > -1; i--) {    // i = 5 → 4 → 3 → 2 → 1 → 0
            for(int j = 0; j < i; j++) {                 // i = 5 : j = 0 → 1 → 2 → 3 → 4 
                if(array[j] > array[j+1]) {             // 0 < 1 → 1 < 2 → 2 < 3 → 3 < 4 → 4 < 5
                    temp = array[j];                    // temp에 0을 넣어준다. temp = 6
                    array[j] = array[j+1];                // 0에 1을 넣어준다. array[0] = 4
                    array[j+1] = temp;                    // 1에 temp를 넣어준다. // array[1] = 6, 교환 성립.
                }
                
            }
        }
        
        System.out.println(Arrays.toString(array)); //arrays클래스의 toString메소드 : []형태로 뽑아서 처리해줌.        
                                                    //변수명.toString()를 하게 되면 hashcode값을 가져오게 된다.
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
