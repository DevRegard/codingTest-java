package level_1;

import java.util.HashSet;

/**
 * @codingTest ü����
 *	1. ���������� ü�������� ���� �� �ִ� �л��� ��ü �л���{n]���� 
 *	   lost�迭�� ����(�л���)��ŭ �� �� + ������ �����Դµ� ���ϸ��� ��� ��
 *	2. ������ �ִ� �л��� ���� 1�� ���ϰ�, ������ lost�迭�� �ִ°� �˻�
 *	3. �˻��ؼ� ������ ������, ������ reserve �迭�� ���� -10���� ���� (������ ������ ����)
 *	4. ���� �� �ִ� �л��� ++ �ϰ� ���� reserve ����
 */
public class GymSuit {

	public int gymSuit(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] people = new int[n];

        for (int l : lost)
			people[l-1]--;
        
        for (int r : reserve)
			people[r-1]++;
        
        for (int i = 0; i < people.length; i++) {
			if (people[i] == -1) {
				if (i - 1 >= 0 && people[i-1] == 1) {
					people[i]++;
					people[i-1]--;
				}else if (i + 1 < people.length && people[i+1] == 1) {
					people[i]++;
					people[i+1]--;
				}else 
					answer--;
			}
		}
        return answer;
    }
	
	
	
	public int gymSuit_1(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length; //�Ҿ�����ֵ� ��ü ������ ���ֱ�
		
		//�Ҿ�����ְ� �ι������¾����� Ȯ�� (�� : -10, reserve�ڰݹ�Ż
		for (int i = 0; i < reserve.length; i++) {
			for (int j = 0; j < lost.length; j++) {
				//�ڰݹ�Ż �� �ֵ� ���ֱ�
				if (lost[j] == -10 && reserve[i] == -10) {
					continue;
				}
				
				//reserve �ڰݹ�Ż
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
				
				//�ٷ�
				if (Math.abs(lost[i] - reserve[j]) == 1) {
					answer++;
					reserve[j] = -10;
					break;
				}
			}
		}
		return answer;
	}
	
	
	
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
	
	
	
	public int gymSuit_3(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;
		HashSet<Integer> ko = new HashSet<Integer>();
		for (int k : reserve) {
			ko.add(k);
		}
		
		for (int i = 0; i < lost.length; i++) {
			if (ko.contains(lost[i])) {
//				System.out.println("���� ���� ����");
				answer++;
				ko.remove(lost[i]);
				lost[i] = -1;
			}
		}
		
		for (int i = 0; i < lost.length; i++) {
//			System.out.println(i);
			
			if (ko.contains(lost[i] - 1)) {
				System.out.println("�ִ�");
				answer++;
				ko.remove(lost[i]-1);
			} else if (ko.contains(lost[i] + 1)) {
				System.out.println("�ִ�");
				answer++;
				ko.remove(lost[i] + 1);
			}
//			System.out.println("����");
		}
		
		
		return answer;
	}
	
	
	
	// ���������� ����Ǵ� ���
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
		
		//�޼��� �ϳ��� �����ؾ� ���� ���� �׽�Ʈ ����
		GymSuit gs = new GymSuit();
		System.out.println(gs.gymSuit(n, lost, reserve));
//		System.out.println(gs.gymSuit_1(n, lost, reserve)); //5
//		System.out.println(gs.gymSuit_2(n, lost, reserve)); //5
//		System.out.println(gs.gymSuit_3(n, lost, reserve)); //5
//		System.out.println(gs.gymSuit_4(n, lost, reserve)); // X
		
	}

}
