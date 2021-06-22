package level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @codingTest <두 개 뽑아서 더하기>
 * 
 */
public class TakeTwoAdd {

	
	public int[] takeTwoAdd(int[] numbers) {
        int[] answer = {};
        System.out.println(answer);
        return answer;
        
    }
	
	
	
	
	// [솔루션1] ArrayList를 활용하여 중복된 값을 허용을 감안해서 구현한 방법
	public int[] takeTwoAdd_1(int[] numbers) {
		 ArrayList<Integer> list = new ArrayList<Integer>();
	        
	        for(int i=0; i<numbers.length; i++){ 
	            for(int j=i+1;j<numbers.length; j++){ 
	                int a = numbers[i]+numbers[j]; //i번째 인덱스 정수와 i+1번째 인덱스와 더한 변수
	                if (list.indexOf(a) < 0){ //***
	                	list.add(a);
	                }
	            }
	        }
	        
	        int[] answer = new int[list.size()];
	        for (int i = 0; i < list.size(); i++) {
	            answer[i] = list.get(i);
	        }
	        Arrays.sort(answer);

	        return answer;
		
	}
	
	
	
	
	// [솔루션2] HashSet, Set을 활용하여 중복된 값을 허용하지 않고 계산한 방법
	public int[] takeTwoAdd_2(int[] numbers) {
		 Set<Integer> set = new HashSet<>();

	        for(int i=0; i<numbers.length; i++) {
	            for(int j=i+1; j<numbers.length; j++) {
	                set.add(numbers[i] + numbers[j]);
	            }
	        }

	        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
		
	        /*
	         * HashSet의 특징
	         * 1. 중복된 값을 허용X
	         * 2. 순서를 보장 X
	         * 3. null값을 저장 가능
	         * 4. 내부적으로 HashMap을 사용하여 데이터를 저장
	         * 
	         */
	}
	
	
	
	
	// [솔루션3] ArrayList,Collections,HashSet,Iterator를 동시 활용 및 리턴값 변경한 방법
	 public static ArrayList<Integer> takeTwoAdd_3(int[] numbers) {
		ArrayList<Integer> answer = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()) {
            answer.add(iter.next());
        }

        Collections.sort(answer);
        return answer;
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
