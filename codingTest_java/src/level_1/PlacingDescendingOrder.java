package level_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @codingTest <Problems> 문자열 내림차순으로 배치하기 [1-27]
 *
 *	toCharArray() : String(문자열)을 char형 배열로 바꾼다.
 *	StringBuilder() : 변경가능하지만 동가화가 적용되지 않는다. 멀티스레드환경에선 값 변경 못함 -> 속도는 비교적 조금 빠름
 *	StringBuffer() : thread-safe 환경에서 변경가능하지만, multiple thread 환경에서 안전한 클래스
 *					  즉, web이나 소켓환경과 같이 비동기로 작동하는 경우는 StringBuffer가 훨씬 안전하다.
 *
 *	<속도> StringBuilder() > StringBuffer()
 *	<안정성> StringBuilder() < StringBuffer(); 
 *	/// 단일 작업을 할때는 builder가 빠르고, 두 개 이상부터는 Buffer를 사용하는 것이 좋다.
 *
 *	reverse() : 문자열 뒤집기
 *	toString() : 기본 내장기능 해쉬코드 출력 (재정의해서 사용가능)
 *
 *	Stream :
 */
public class PlacingDescendingOrder {

	
	public String placingDescendingOrder(String s) {
        String answer = "";
        return answer;
    }
	
	
	
	
	// [솔루션1] Collections, Arrays 클래스 사용한 방법
	public String placingDescendingOrder_1(String s) {
		Character [] arr = new Character [s.length()];
		for(int i=0; i<arr.length; i++) {
			arr[i] = s.charAt(i);
		}
		Arrays.sort(arr,Collections.reverseOrder());
		s = "";
		for(int i=0; i<arr.length; i++) {
			s += arr[i];
		}
		return s;
	}
	
	
	
	
	// [솔루션2] 문자형 배열을 생성하고, 그대로 정렬하기
	public String placingDescendingOrder_2(String s) {
		char[] sol = s.toCharArray(); //문자형 배열
	    Arrays.sort(sol);
	    return new StringBuilder(new String(sol)).reverse().toString(); //**
	}
	
	
	
	
	// [솔루션3] Stream 클래스를 사용한 방법
	public String placingDescendingOrder_3(String s) {
		return Stream.of(s.split(""))
			    .sorted(Comparator.reverseOrder())
			    .collect(Collectors.joining());
	}
	
	
	
	
	
	public static void main(String[] args) {
		PlacingDescendingOrder pdo = new PlacingDescendingOrder();
		System.out.println(pdo.toString()); //기본 내장기능 해쉬코드 출력
	}

}
