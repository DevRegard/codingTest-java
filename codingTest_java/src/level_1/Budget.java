package level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @codingTest <����>
 *
 */
public class Budget {

	
	public int budget(int[] d, int budget) {
		int answer = 0;
		return answer;
	}
	
	
	
	
	//�������� ���� �� ���� �� ���� ���ؼ� ���� �ִ��� ���� ���� ���� �����ϴ� [�ַ��1]
	public int budget_1(int[] d, int budget) {
        int answer = 0;
        int result = 0;
        Arrays.sort(d);
        
        for (int i = 0; i < d.length; i++) {
			result += d[i];
			if (result > budget) { //���꺸�� Ŀ����
				answer = i; //�μ� ������ i�� ����
				break; //����
			}
		}
        if (result <= budget) { //���꺸�� �۰ų� ������
			answer = d.length;  //�μ��� ������ŭ ����
		}
        
        return answer;
    }
	
	
	
	
	//������ �ϳ��� ���� 0���� �۾����� ���� = �ִ��� ������ ���� [�ַ��2]
	public int budget_2(int[] d, int budget) {
		int answer = 0;
		Arrays.sort(d);
		
		for (int i = 0; i < d.length; i++) { 
			budget -= d[i]; //*** "���� - ���� ������� ����� ����"
			if (budget < 0) break;
			answer++; //�μ� ����
				
		}
		
		return answer;
	}
	
	
	
	// ArrayList�� Collections�� Ȱ���� [�����3]
	public int budget_3(int[] d, int budget) {
		int answer = 0;

        int money = 0;

        ArrayList<Integer> budgetList = new ArrayList<Integer>();

        for(int i=0; i<d.length; i++)
        {
            budgetList.add(d[i]);
        }

        //�������� ����
        Collections.sort(budgetList);

        for(int i=0; i<budgetList.size(); i++)
        {
            int currentBudget = budgetList.get(i);

            money += currentBudget;

            //���� ���� ������ �߰��ϸ� ��ü������ �ʰ��ϴ� ���
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
