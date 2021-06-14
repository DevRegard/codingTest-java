package level_1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @codingTest 완주하지 못한 선수 <HashMap>
 *	
 *	HashMap<> 
 *	getOrDefault() : 찾는 키가 존재한다면 찾는 키의 값을 반환하고, 없다면 기본 값을 반환하는 메서드
 *	put() :
 *	set() :
 *	keySet() :
 */
public class PlayersNotFinish {
	
	// 
	public String playersNotFinish(String[] participant, String[] completion) { 
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();
		
		for (String player : participant) //참가자 만큼 반복
			hm.put(player, hm.getOrDefault(player, 0) + 1); //
		
		for (String player : completion) //완주자 만큼 반복
			hm.put(player, hm.get(player) - 1); //
		
		for (String key : hm.keySet()) {
			if (hm.get(key) != 0) {
				answer = key;
			}
		}
		
		return answer;
	}
	
	
	
	
	public String playersNotFinish_1(String[] participant, String[] completion) {
		String answer = "";
		String temp = "";
		
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		int i = 0;
		while(i < completion.length) { //완주자 길이 만큼 반복
			if(!completion[i].equals(participant[i])) { //완주자와 참가자가 같지 않다면
				temp = participant[i];
				break;
			} else {
				i++;
			}
		}
		
		if(!temp.equals("")) { //temp의 내용이 없는게 아니라면
			answer = temp;
		} else {
			answer = participant[participant.length-1];
		}
		
		return answer;
	}
	
	
	
	
	public String playersNotFinish_2(String[] participant, String[] completion) {
		
		int i; // [3] 때문에 전역 변수로 선언
		
		// [1] 각 배열을 오름차순으로 정렬
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		// [2] 정렬된 배열을 앞에서부터 비교해서, 달라지는 순간(완주하지 못한 선수 발견) 참가
		// completion의 수 만큼 비교해야 index of 에러가 안난다
		for (i = 0; i < completion.length; i++) {
			if (!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}
		
		return participant[i]; // [3] 완주하지 못한 선수가 가장 끝에 있는 경우
	}
	
	
	
	
	public String playersNotFinish_3(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();
		for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
		for (String player : completion) hm.put(player, hm.get(player) - 1);
		
		for (String key : hm.keySet()) {
			if (hm.get(key) != 0) {
				answer = key;
			}
		}
		return answer;
	}
	
	
	
	
	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		PlayersNotFinish pnf = new PlayersNotFinish();
		
		System.out.println(pnf.playersNotFinish(participant, completion));
		System.out.println(pnf.playersNotFinish_1(participant, completion));
		System.out.println(pnf.playersNotFinish_2(participant, completion));
		System.out.println(pnf.playersNotFinish_3(participant, completion));
		
	}

}
