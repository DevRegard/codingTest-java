package level_1;

import java.util.HashSet;

/**
 * @codingTest <Problems> 체육복 [1-3]
 * 
 * 	HashSet : Set 인터페이스의 구현 클래스 (= Set성질 )
 * 			  
 * 
 * 	Set : 객체를 중복해서 저장할 수 없고, 하나의 null값만 저장할 수 있다. 또한 저장 순서가 유지되지 않는다.
 * 		  (순서가 보장되는 클래스는 LinkedHashSet)	
 * 		  (= 주머니 형태, 비선형 구조-> 순서없고 인덱스 없다)		
 *  
 *  
 * 	contains() : 대상 문자열에 특정 문자열이 포함되어 있는지 확인하는 클래스 (boolean값)
 * 
 */
public class GymSuit {

	public int gymSuit(int n, int[] lost, int[] reserve) {
        int answer = n;
        return answer;
    }
	
	
	
	
	
	// [솔루션 1]
	public int gymSuit_1(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length; //잃어버린애들 전체 수에서 빼주기
		
		//잃어버린애가 두벌가져온애인지 확인 (참 : -10, reserve자격박탈
		for (int i = 0; i < reserve.length; i++) {
			for (int j = 0; j < lost.length; j++) {
				//자격박탈 된 애들 빼주기
				if (lost[j] == -10 && reserve[i] == -10) {
					continue;
				}
				
				//reserve 자격박탈
				if (lost[j] == reserve[i]) {
					lost[j] = -10;
					reserve[i] = -10;
					answer++;
				}
			}
		}
		
		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] == -10 || reserve[j] == -10) {
					continue;
				}
				
				//바로
				if (Math.abs(lost[i] - reserve[j]) == 1) {
					answer++;
					reserve[j] = -10;
					break;
				}
			}
		}
		return answer;
	}
	
	
	
	
	
	// [솔루션 2]  
	public int gymSuit_2(int n, int[] lost, int[] reserve) {
		int[] people = new int[n];
		int answer = n;
		
		for (int l : lost)
			people[l-1]--;
		for (int r : reserve)
			people[r-1]++;
		
		for (int i = 0; i < people.length; i++) {
			if (people[i] == -1) {
				if (i - 1 >= 0 && people[i-1] == 1) {
					people[i]++;
					people[i-1]--;
				} else if (i + 1 < people.length && people[i+1] == 1) {
					people[i]++;
					people[i+1]--;
				} else 
					answer--;
			}
		}
		
		return answer;
	}
	
	
	
	
	
	// [솔루션 3][BEST] HashSet을 활용해서 해결한 방법
	public int gymSuit_3(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;
		HashSet<Integer> ko = new HashSet<Integer>();
		for (int k : reserve) {
			ko.add(k);
		}
		
		for (int i = 0; i < lost.length; i++) {
			if (ko.contains(lost[i])) {
//				System.out.println("내껀 내가 입지");
				answer++;
				ko.remove(lost[i]);
				lost[i] = -1;
			}
		}
		
		for (int i = 0; i < lost.length; i++) {
//			System.out.println(i);
			
			if (ko.contains(lost[i] - 1)) {
				System.out.println("있다");
				answer++;
				ko.remove(lost[i]-1);
			} else if (ko.contains(lost[i] + 1)) {
				System.out.println("있다");
				answer++;
				ko.remove(lost[i] + 1);
			}
//			System.out.println("없다");
		}
		
		
		return answer;
	}
	
	
	
	
	
	// [솔루션 4] 간결하지만 오답되는 답안 (일부만 정답)
	/*
	 * public int gymSuit_4(int n, int[] lost, int[] reserve) { int answer = n;
	 * 
	 * for (int i = 0; i < lost.length; i++) { boolean rent = false; int j = 0;
	 * 
	 * while(!rent) { if (j == reserve.length) break; if (lost[i] == reserve[j]) {
	 * reserve[j] = -1; rent = true; } else if (lost[i] - reserve[j] == 1) {
	 * reserve[j] = -1; rent = true; } else if (lost[i] - reserve[j] == -1) {
	 * reserve[j] = -1; rent = true; } else { j++; } if (!rent) answer--;
	 * 
	 * } } return answer; }
	 */
	
	
	
	
	
	
	public static void main(String[] args) {
		int n = 5;
		int lost[] = {2,3};
		int reserve[] = {1,3,5};
		
		//메서드 하나만 실행해야 에러 없이 테스트 가능
		GymSuit gs = new GymSuit();
//		System.out.println(gs.gymSuit(n, lost, reserve));
		System.out.println(gs.gymSuit_1(n, lost, reserve)); //5
//		System.out.println(gs.gymSuit_2(n, lost, reserve)); //5
//		System.out.println(gs.gymSuit_3(n, lost, reserve)); //5
		
//		System.out.println(gs.gymSuit_4(n, lost, reserve)); // X
		
	}

}
