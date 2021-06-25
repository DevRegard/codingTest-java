package level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @codingTest <Problems> 같은 숫자는 싫어
 *	
 *	stream() :
 *
 */
public class HateSameNumber {

	
	public int[] hateSameNumber(int []arr) {
        int[] answer = {};
        return answer;
    }
	
	
	
	
	// [솔루션1] ArrayList에다가 정보를 선별해서 집어넣고, 그 과정에서  continue를 활용한 방법
	public int[] hateSameNumber_1(int []arr) {
		int[] answer = {};
        
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i =0; i<arr.length-1; i++) {
            if(arr[i]==arr[i+1]) {
                if(i==arr.length-2) {
                    //마지막 i라면
                    temp.add(arr[i+1]); //마지막의 다음행은 없기 때문에 같든 같지않든 추가해줘야한다.
                }
                continue; // 다음 요소와 같으면 아무 처리하지 않고 continue
            }else{ //다르면 임시 ArrayList에 담는다.
                temp.add(arr[i]);
                if(i==arr.length-2) {
                    //마지막 i라면
                    temp.add(arr[i+1]); //마지막의 다음행은 없기 때문에 같든 같지않든 추가해줘야한다.ㄴ
                }
            }
        }
        answer = new int[temp.size()];
        for(int i =0; i<temp.size();i++) {
            answer[i] = temp.get(i);
        }
        return answer;
	}
	
	
	
	
	// [솔루션2] 향상된 for문과 preNum 변수를 논리적으로 잘 활용한 방법
	public int[] hateSameNumber_2(int []arr) {
		ArrayList<Integer> tempList = new ArrayList<Integer>();
        int preNum = 10;
        for(int num : arr) { //***
            if(preNum != num)
                tempList.add(num);
            preNum = num; //***
        }       
        
        int[] answer = new int[tempList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = tempList.get(i).intValue();
        }
        return answer;
	}
	
	
	
	
	// [솔루션3] LinkedList와 Arrays, stream을 사용한 방법, 훨씬 빠른 연산속도로 출력가능
	public int[] hateSameNumber_3(int []arr) {
		LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(arr[0]);
        for(int i=1; i<arr.length;i++){
            if(arr[i]!=list.getLast()){
                list.add(arr[i]);
            }

        }
        Integer[] listing = list.toArray(new Integer[list.size()]);
        int[] answer = Arrays.stream(listing).mapToInt(Integer::intValue).toArray();
        return answer;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
