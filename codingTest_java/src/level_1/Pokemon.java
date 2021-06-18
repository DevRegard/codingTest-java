package level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @codingTest <폰켓몬>
 *
 *	contains() :
 *	util.HashSet : 
 *	stream.Collectors : 
 *	collectingAndThen() :
 *	toSet() :
 *	boxed() : 
 *	collect() :
 */
public class Pokemon {

	
	//
	public int pokemon(int[] nums) {
		int answer = 0;
		List<Integer> list = new ArrayList<Integer>();
		list.add(nums[0]);
        
		// nums[] 배열의 중복제거
		for(int i=1; i<nums.length; i++) 
			if(!list.contains(nums[i]))
				list.add(nums[i]);
        
		/* list.size(): 포켓몬의 종류, nums.length: 가질 수 있는 포켓몬의 수 */
		answer = (list.size() < nums.length/2) ? list.size() : nums.length/2;
		return answer;
    }
	
	
	
	
	//자료구조를 통해 중복제거, 수량비교한 솔루션
	public int pokemon_1(int[] nums) {
		int answer = 0;
		List<Integer> list = new ArrayList<Integer>();
		list.add(nums[0]);
        
		// nums[] 배열의 중복제거
		for(int i=1; i<nums.length; i++) 
			if(!list.contains(nums[i]))
				list.add(nums[i]);
        
		/* list.size(): 포켓몬의 종류, nums.length: 가질 수 있는 포켓몬의 수 */
		answer = (list.size() < nums.length/2) ? list.size() : nums.length/2;
		return answer;
	}
	
	
	
	
	//HashSet을 사용한 솔루션
	public int pokemon_2(int[] nums) {
		 HashSet<Integer> hs = new HashSet<>();

         for(int i =0; i<nums.length;i++) {
             hs.add(nums[i]);
         }

         if(hs.size()>nums.length/2)
             return nums.length/2;

         return hs.size();
	}
	
	
	
	
	//Arrays와 Collectors을 사용하여 람다식으로 구현한 솔루션
	public int pokemon_3(int[] nums) {
		return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
