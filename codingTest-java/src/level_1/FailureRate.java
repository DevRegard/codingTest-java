package level_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @codingTest <실패율>
 *	머물러있거나 도달하지 못한 사람 수 / 이미 클리어한 수
 */
public class FailureRate {
	
	
	//ArrayList, Collections 활용한 솔루션
	public int[] failureRate_1(int N, int[] stages) {
		int[] answer = new int[N];

        double[] stage = new double[N+1];      // 스테이지마다 머물러 있는 사용자수를 담을 배열


        // stage배열에 머물러있는 사용자수를 담는다 , 인덱스값이 스테이지번호
        for(int i : stages){

            if(i == N+1){

                continue;

            }

            stage[i]++;

        }


        // 실패율을 계산해 담을 list
        ArrayList<Double> fail = new ArrayList<Double>();

        //스테이지에 도달한 명수
        double num =stages.length;
        //다음 스테이지로 올라갈때 줄어드는 사용자수를 계산하기 위해 사용
        double tmp = 0;


        //실패율을 구한 후 다시 stage배열에 담고, fail 리스트에도 담아준다.
        for(int i=1; i<stage.length; i++){

            tmp = stage[i];
            // 도달한 사용자 수가 0 일때, 실패율도 0
            if(num == 0){

                stage[i]=0;

            }else{

                stage[i] = stage[i]/num;

                num = num - tmp;

            }

            fail.add(stage[i]);

      }


     //  fail 리스트를 내림차순으로 정렬해준다.
     Collections.sort(fail,Collections.reverseOrder());


     //정렬된 fail리스트 값과 stage값을 비교해서 같으면 stage의 인덱스번호(스테이지번호)를 가져옴으로써
     //실패율이 높은 순으로 answer배열에 넣어준다.
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

	
	
	
	//ArrayList, Collections, List 까지 활용한 솔루션
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
	
	
	
	
	// import를 사용하지 않고, 직관성과 성능을 잡은 솔루션
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
