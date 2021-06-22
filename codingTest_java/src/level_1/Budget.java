package level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @codingTest <예산>
 *
 */
public class Budget {

	
	public int budget(int[] d, int budget) {
		int answer = 0;
		return answer;
	}
	
	
	
	
	//오름차순 정렬 후 작은 수 부터 더해서 가장 최대의 값을 내며 예산 도출하는 [솔루션1]
	public int budget_1(int[] d, int budget) {
        int answer = 0;
        int result = 0;
        Arrays.sort(d);
        
        for (int i = 0; i < d.length; i++) {
			result += d[i];
			if (result > budget) { //예산보다 커지면
				answer = i; //부서 갯수인 i를 리턴
				break; //중지
			}
		}
        if (result <= budget) { //예산보다 작거나 같으면
			answer = d.length;  //부서의 갯수만큼 리턴
		}
        
        return answer;
    }
	
	
	
	
	//예산을 하나씩 빼고 0보다 작아지면 리턴 = 최댓값을 지나서 리턴 [솔루션2]
	public int budget_2(int[] d, int budget) {
		int answer = 0;
		Arrays.sort(d);
		
		for (int i = 0; i < d.length; i++) { 
			budget -= d[i]; //*** "예산 - 작은 순서대로 예산금 빼기"
			if (budget < 0) break;
			answer++; //부서 갯수
				
		}
		
		return answer;
	}
	
	
	
	// ArrayList와 Collections을 활용한 [술루션3]
	public int budget_3(int[] d, int budget) {
		int answer = 0;

        int money = 0;

        ArrayList<Integer> budgetList = new ArrayList<Integer>();

        for(int i=0; i<d.length; i++)
        {
            budgetList.add(d[i]);
        }

        //오름차순 정렬
        Collections.sort(budgetList);

        for(int i=0; i<budgetList.size(); i++)
        {
            int currentBudget = budgetList.get(i);

            money += currentBudget;

            //현재 팀의 예산을 추가하면 전체예산을 초과하는 경우
            if(money > budget)
            {
                break;
            }
            else
            {
                answer++;
            }
        }

        return answer;
	}

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
