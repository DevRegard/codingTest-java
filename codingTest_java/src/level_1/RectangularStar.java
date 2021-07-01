package level_1;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @codingTest <Problems> 직사각형 별찍기 [1-49]
 *
 *	System.out.print와 
 *	System.out.prIntln 사용 유의
 *
 *	IntStream : range와 forEach를 통해 반복문을 표현한 람다식 클래스
 *	range(a,b) : a값 부터 b직전까지 (== a ~ b-1)
 *	forEach(변수 -> 반복처리(변수)) : 변수를 생성하고 -> 반복할 내용과 변수를 넣는다. 
 *	append() : 해당 문자열의 마지막에 인수값을 추가해주는 메서드 (내부적인 처리 속도 빠름)
 */
public class RectangularStar {

	// [솔루션1] 2중 for문으로 사용한 방법
	/*public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); //가로[행]
        int b = sc.nextInt(); //세로[열]
        
        for (int i=0; i<b; i++) { //가로 방향
            for (int j=0; j<a; j++) { //세로 방향
                System.out.print("*");
            }
            System.out.println(); 
        }*/
        
        
        
        
        
    // [솔루션2] IntStream 클래스 사용한 방법, forEach()
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int a = sc.nextInt(); //가로[행]
    	int b = sc.nextInt(); //세로[열]
    	
    	StringBuilder sb = new StringBuilder();
        IntStream.range(0, a).forEach(s -> sb.append("*"));
        IntStream.range(0, b).forEach(s -> System.out.println(sb.toString()));
        
        	
    }
}
