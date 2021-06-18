package level_1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @codingTest �������� ���� ���� <HashMap>
 *	
 *	HashMap<> 
 *	getOrDefault() : ã�� Ű�� �����Ѵٸ� ã�� Ű�� ���� ��ȯ�ϰ�, ���ٸ� �⺻ ���� ��ȯ�ϴ� �޼���
 *	put() :
 *	set() :
 *	keySet() :
 */
public class PlayersNotFinish {
	
	// 
	public String playersNotFinish(String[] participant, String[] completion) { 
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();
		
		for (String player : participant) //������ ��ŭ �ݺ�
			hm.put(player, hm.getOrDefault(player, 0) + 1); //
		
		for (String player : completion) //������ ��ŭ �ݺ�
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
		while(i < completion.length) { //������ ���� ��ŭ �ݺ�
			if(!completion[i].equals(participant[i])) { //�����ڿ� �����ڰ� ���� �ʴٸ�
				temp = participant[i];
				break;
			} else {
				i++;
			}
		}
		
		if(!temp.equals("")) { //temp�� ������ ���°� �ƴ϶��
			answer = temp;
		} else {
			answer = participant[participant.length-1];
		}
		
		return answer;
	}
	
	
	
	
	public String playersNotFinish_2(String[] participant, String[] completion) {
		
		int i; // [3] ������ ���� ������ ����
		
		// [1] �� �迭�� ������������ ����
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		// [2] ���ĵ� �迭�� �տ������� ���ؼ�, �޶����� ����(�������� ���� ���� �߰�) ����
		// completion�� �� ��ŭ ���ؾ� index of ������ �ȳ���
		for (i = 0; i < completion.length; i++) {
			if (!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}
		
		return participant[i]; // [3] �������� ���� ������ ���� ���� �ִ� ���
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
