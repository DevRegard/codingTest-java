package level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @codingTest <�� �� �̾Ƽ� ���ϱ�>
 * 
 */
public class TakeTwoAdd {

	
	public int[] takeTwoAdd(int[] numbers) {
        int[] answer = {};
        System.out.println(answer);
        return answer;
        
    }
	
	
	
	
	// [�ַ��1] ArrayList�� Ȱ���Ͽ� �ߺ��� ���� ����� �����ؼ� ������ ���
	public int[] takeTwoAdd_1(int[] numbers) {
		 ArrayList<Integer> list = new ArrayList<Integer>();
	        
	        for(int i=0; i<numbers.length; i++){ 
	            for(int j=i+1;j<numbers.length; j++){ 
	                int a = numbers[i]+numbers[j]; //i��° �ε��� ������ i+1��° �ε����� ���� ����
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
	
	
	
	
	// [�ַ��2] HashSet, Set�� Ȱ���Ͽ� �ߺ��� ���� ������� �ʰ� ����� ���
	public int[] takeTwoAdd_2(int[] numbers) {
		 Set<Integer> set = new HashSet<>();

	        for(int i=0; i<numbers.length; i++) {
	            for(int j=i+1; j<numbers.length; j++) {
	                set.add(numbers[i] + numbers[j]);
	            }
	        }

	        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
		
	        /*
	         * HashSet�� Ư¡
	         * 1. �ߺ��� ���� ���X
	         * 2. ������ ���� X
	         * 3. null���� ���� ����
	         * 4. ���������� HashMap�� ����Ͽ� �����͸� ����
	         * 
	         */
	}
	
	
	
	
	// [�ַ��3] ArrayList,Collections,HashSet,Iterator�� ���� Ȱ�� �� ���ϰ� ������ ���
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
