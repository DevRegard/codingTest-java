package level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @codingTest <Problems> ��� ���� [2-6]
 *
 */
public class FeatureDevelopment {

	
	public int[] featureDevelopment_(int[] progresses, int[] speeds) {
        int[] answer = {};
        return answer;
    }
	
	
	
	
	
	// [�ַ�� 1] Stack, List, ArrayList�� ����ؼ� �ذ��� ���
	public int[] featureDevelopment_1(int[] progresses, int[] speeds) {
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = progresses.length - 1; i >= 0; i--)
			stack.add((100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] > 0 ? 1 : 0));

		List<Integer> s = new ArrayList<Integer>();

		while (!stack.isEmpty()) {
			int cnt = 1;

			int top = stack.pop();

			while (!stack.isEmpty() && stack.peek() <= top) {
				cnt++;
				stack.pop();
			}

			s.add(cnt);
		}

		int[] answer = new int[s.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = s.get(i);
		}

		return answer;
	}
	
	
	
	
	
	// [�ַ�� 2] Arrays�� ���ٽ����� �����ϰ� �ڵ�� �ذ��� ���
	public int[] featureDevelopment_2(int[] progresses, int[] speeds) {
		int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
	}
	
	
	
	
	
	// [�ַ�� 3] ������ �ϳ��� ���ȭ �ؼ� �ذ��� ���
	int progressesCount;
    int[] needDays; 

    ArrayList<Integer> workCountStorage;
    
    
	public int[] featureDevelopment_3(int[] progresses, int[] speeds) {
		//Init
        progressesCount = progresses.length;
        needDays = new int[progressesCount];
        workCountStorage = new ArrayList<>();


        //�ʿ��� �۾��� ���
        this.calcNeedDays(progresses, speeds);

        //this.viewAll(needDays, 0);


        //���ÿ� ����� ���μ��� ���
        for(int step=0; step<progressesCount;)
        {
            int stepNeedDay = needDays[step];

            //��¥ ���ÿ� ���
            for(int remainStep=step; remainStep<progressesCount; remainStep++)
            {
                needDays[remainStep] -= stepNeedDay;
            }

            //this.viewAll(needDays, step);

            //�Ϸ��� �۾������� ����
            int workCount = 1;
            for(;step+workCount<progressesCount; workCount++)
            {
                if(needDays[step+workCount] > 0)
                {
                    break;
                }
            }

            System.out.println("workCount:"+workCount);

            //�Ϸ��� �۾� ���� ����
            workCountStorage.add(workCount);

            //�۾� ������ŭ step ����
            step += workCount;    

        }

        //int[] answer = {};
        int[] answer = FeatureDevelopment.convertIntegers(workCountStorage);
        return answer;
	}
	
	
	private void calcNeedDays(int[] progresses, int[] speeds)
    {
        for(int i=0; i<progressesCount; i++)
        {
            double remainProgress = 100 - progresses[i];
            double fNeedDay = remainProgress / speeds[i];

            needDays[i] = (int)Math.ceil(fNeedDay);
        }
    }

	
    public static int[] convertIntegers(ArrayList<Integer> integers)
    {
        int size = integers.size();
        int[] ret = new int[size];
        for (int i=0; i<size; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    
    private void viewAll(int[] array, int startIdx)
    {
        System.out.print("viewAll:");

        int arrayCount = array.length;
        for(int i=startIdx; i<arrayCount; i++)
        {
            System.out.print(array[i]+",");
        }

        System.out.println();
    }
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
