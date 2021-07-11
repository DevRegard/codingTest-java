package level_1;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @codingTest <Problems> 모의고사 [1-4]
 * 
 *	1. 수포자들이 답을 찍는 패턴이 담긴 배열과 수포자들의 정답을 저장할 배열(scores)를 생성
 *	2. 수포자들의 답과 실제 답을 비교해 맞은 개수를 배열(scores)에 저장
 *	3. scores배열을 새로운 배열인 arr로 복사
 *	4. 제일 많이 맞은 개수를 알기 위하여 arr를 오름차순으로 정렬 -> 가장 많이 맞은 정답 개수 arr[2]
 *	5. 수포자 1,2,3의 정답 개수가 순서대로 있는 배열 scores랑 arr[2]를 비교하여 같으면 
 *		scores배열의 인덱스+1값을 최종 답이 되는 answer 배열에 담기
 */

public class MockExam {

	
	public int[] mockExam(int[] answers) {
		int[] answer = {};
        return answer;
	}
	
	
	
	
	
	// [솔루션 1]
	public int[] mockExam_1(int[] answers) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int[] first = {1,2,3,4,5};
		int[] second = {2,1,2,3,2,4,2,5};
		int[] third	 = {3,3,1,1,2,2,4,4,5,5};
		
		int[] scores = {0,0,0}; //수포자들 답 맞은 개수
		
		//비교
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
	
	
	
	
	
	// [솔루션 2]
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
	
	
	
	
	
	// [솔루션 3]
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
		
		//결과값이 메모리값으로 나오는 현상 발생
		System.out.println(me.mockExam(answers)); 
		System.out.println(me.mockExam_1(answers2)); //[I@659e0bfd
		System.out.println(me.mockExam_2(answers)); 
		System.out.println(me.mockExam_3(answers)); 
		
	}

}
