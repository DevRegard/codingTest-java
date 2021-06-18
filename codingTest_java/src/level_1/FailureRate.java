package level_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @codingTest <������>
 *	�ӹ����ְų� �������� ���� ��� �� / �̹� Ŭ������ ��
 */
public class FailureRate {
	
	
	//ArrayList, Collections Ȱ���� �ַ��
	public int[] failureRate_1(int N, int[] stages) {
		int[] answer = new int[N];

        double[] stage = new double[N+1];      // ������������ �ӹ��� �ִ� ����ڼ��� ���� �迭


        // stage�迭�� �ӹ����ִ� ����ڼ��� ��´� , �ε������� ����������ȣ
        for(int i : stages){

            if(i == N+1){

                continue;

            }

            stage[i]++;

        }


        // �������� ����� ���� list
        ArrayList<Double> fail = new ArrayList<Double>();

        //���������� ������ ���
        double num =stages.length;
        //���� ���������� �ö󰥶� �پ��� ����ڼ��� ����ϱ� ���� ���
        double tmp = 0;


        //�������� ���� �� �ٽ� stage�迭�� ���, fail ����Ʈ���� ����ش�.
        for(int i=1; i<stage.length; i++){

            tmp = stage[i];
            // ������ ����� ���� 0 �϶�, �������� 0
            if(num == 0){

                stage[i]=0;

            }else{

                stage[i] = stage[i]/num;

                num = num - tmp;

            }

            fail.add(stage[i]);

      }


     //  fail ����Ʈ�� ������������ �������ش�.
     Collections.sort(fail,Collections.reverseOrder());


     //���ĵ� fail����Ʈ ���� stage���� ���ؼ� ������ stage�� �ε�����ȣ(����������ȣ)�� ���������ν�
     //�������� ���� ������ answer�迭�� �־��ش�.
     for(int i=0; i<fail.size(); i++){

         for(int j=1; j<stage.length; j++){

             if(fail.get(i) == stage[j]){

                 answer[i] = j;

                 stage[j] = -1;

                 break;

            }

        }

    }

    return answer;
    }

	
	
	
	//ArrayList, Collections, List ���� Ȱ���� �ַ��
	public int[] failureRate_2(int N, int[] lastStages) {
		int nPlayers = lastStages.length;
        int[] nStagePlayers = new int[N + 2];
        for (int stage : lastStages) {
            nStagePlayers[stage] += 1;
        }

        int remainingPlayers = nPlayers;
        List<Stage> stages = new ArrayList<>();
        for (int id = 1 ; id <= N; id++) {
            double failure = (double) nStagePlayers[id] / remainingPlayers;
            remainingPlayers -= nStagePlayers[id];

            Stage s = new Stage(id, failure);
            stages.add(s);
        }
        Collections.sort(stages, Collections.reverseOrder());

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stages.get(i).id;
        }
        return answer;
    }

	    class Stage implements Comparable<Stage> {
	        public int id;
	        public double failure;
	
	        public Stage(int id_, double failure_) {
	            id = id_;
	            failure = failure_;
	        }
	
	        @Override
	        public int compareTo(Stage o) {
	            if (failure < o.failure ) {
	                return -1;
	            }
	            if (failure > o.failure ) {
	                return 1;
	            }
	            return 0;
		}
        
    }
	
	
	
	
	// import�� ������� �ʰ�, �������� ������ ���� �ַ��
	public int[] failureRate_3(int N, int[] stages) {
		int[] answer = new int[N];
        double[] tempArr = new double[N];
        int arrLength = stages.length;
        int idx = arrLength;
        double tempD = 0;
        int tempI = 0;
        
        for (int i = 0; i < arrLength; i++) {
            int stage = stages[i];
            if (stage != N + 1)
                answer[stage - 1] += 1;
        }
        
        for (int i = 0; i < N; i++) {
            int personNum = answer[i];
            tempArr[i] = (double) personNum / idx;
            idx -= personNum;
            answer[i] = i + 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N - i; j++) {
                if (tempArr[j - 1] < tempArr[j]) {
                    tempD = tempArr[j - 1];
                    tempArr[j - 1] = tempArr[j];
                    tempArr[j] = tempD;

                    tempI = answer[j - 1];
                    answer[j - 1] = answer[j];
                    answer[j] = tempI;
                }
            }
        }
        return answer;
	}
	
	
	
	
	public int[] failureRate(int N, int[] stages) {
		int[] answer = {};
		return answer;
	}
	
	
	
	
	public static void main(String[] args) {

	}

}
