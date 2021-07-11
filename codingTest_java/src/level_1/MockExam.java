package level_1;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @codingTest <Problems> ���ǰ�� [1-4]
 * 
 *	1. �����ڵ��� ���� ��� ������ ��� �迭�� �����ڵ��� ������ ������ �迭(scores)�� ����
 *	2. �����ڵ��� ��� ���� ���� ���� ���� ������ �迭(scores)�� ����
 *	3. scores�迭�� ���ο� �迭�� arr�� ����
 *	4. ���� ���� ���� ������ �˱� ���Ͽ� arr�� ������������ ���� -> ���� ���� ���� ���� ���� arr[2]
 *	5. ������ 1,2,3�� ���� ������ ������� �ִ� �迭 scores�� arr[2]�� ���Ͽ� ������ 
 *		scores�迭�� �ε���+1���� ���� ���� �Ǵ� answer �迭�� ���
 */

public class MockExam {

	
	public int[] mockExam(int[] answers) {
		int[] answer = {};
        return answer;
	}
	
	
	
	
	
	// [�ַ�� 1]
	public int[] mockExam_1(int[] answers) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int[] first = {1,2,3,4,5};
		int[] second = {2,1,2,3,2,4,2,5};
		int[] third	 = {3,3,1,1,2,2,4,4,5,5};
		
		int[] scores = {0,0,0}; //�����ڵ� �� ���� ����
		
		//��
		for (int i = 0; i < answers.length; i++) {
			if (first[i % 5] == answers[i]) {scores[0]++;} //***
			if (second[i % 8] == answers[i]) {scores[1]++;}
			if (third[i % 10] == answers[i]) {scores[2]++;}
		}
		
		int[] arr = new int[scores.length];
		for (int i = 0; i < scores.length; i++) {
			arr[i] = scores[i];
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			if (scores[i] == arr[2]) {
				list.add(i + 1);
			}
		}
		
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }
	
	
	
	
	
	// [�ַ�� 2]
	public int[] mockExam_2(int[] answers) {
		int[] answer = {};
		
		int[] a = {1,2,3,4,5};
		int[] b = {2,1,2,3,2,4,2,5};
		int[] c = {3,3,1,1,2,2,4,4,5,5};
		int[] score = new int[3];
		for (int i = 0; i < answer.length; i++) {
			if(answer[i] == a[i%a.length]) {score[0]++;} 
			if(answer[i] == b[i%b.length]) {score[1]++;} 
			if(answer[i] == c[i%c.length]) {score[2]++;} 
		}
		
		int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
		ArrayList<Integer> list = new ArrayList<>();
		if(maxScore == score[0]) {list.add(1);}
		if(maxScore == score[1]) {list.add(2);}
		if(maxScore == score[2]) {list.add(3);}
		
		return list.stream().mapToInt(i->i.intValue()).toArray();
	}
	
	
	
	
	
	// [�ַ�� 3]
	public int[] mockExam_3(int[] answers) {
		int[][] patterns = {
				{1, 2, 3, 4, 5},
				{2, 1, 2, 3, 2, 4, 2, 5},
				{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
		};
		
		int[] hit = new int[3];
		for (int i = 0; i < hit.length; i++) {
			for (int j = 0; j < answers.length; j++) {
				if (patterns[i][j % patterns[i].length] == answers[j]) 
					hit[i]++;
			}
		}
		
		int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < hit.length; i++)
			if (max == hit[i]) list.add(i + 1);
				
		int[] answer = new int[list.size()];
		int cnt = 0;
		for (int num : list) 
			answer[cnt++] = num;
		
		return answer;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		MockExam me = new MockExam();
		int answers[] = {1,2,3,4,5}; //1
		int[] answers2 = {1,3,2,4,2}; //1,2,3
		
		//������� �޸𸮰����� ������ ���� �߻�
		System.out.println(me.mockExam(answers)); 
		System.out.println(me.mockExam_1(answers2)); //[I@659e0bfd
		System.out.println(me.mockExam_2(answers)); 
		System.out.println(me.mockExam_3(answers)); 
		
	}

}
