package level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @codingTest <Problems> ���� ���ڴ� �Ⱦ�
 *	
 *	stream() :
 *
 */
public class HateSameNumber {

	
	public int[] hateSameNumber(int []arr) {
        int[] answer = {};
        return answer;
    }
	
	
	
	
	// [�ַ��1] ArrayList���ٰ� ������ �����ؼ� ����ְ�, �� ��������  continue�� Ȱ���� ���
	public int[] hateSameNumber_1(int []arr) {
		int[] answer = {};
        
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i =0; i<arr.length-1; i++) {
            if(arr[i]==arr[i+1]) {
                if(i==arr.length-2) {
                    //������ i���
                    temp.add(arr[i+1]); //�������� �������� ���� ������ ���� �����ʵ� �߰�������Ѵ�.
                }
                continue; // ���� ��ҿ� ������ �ƹ� ó������ �ʰ� continue
            }else{ //�ٸ��� �ӽ� ArrayList�� ��´�.
                temp.add(arr[i]);
                if(i==arr.length-2) {
                    //������ i���
                    temp.add(arr[i+1]); //�������� �������� ���� ������ ���� �����ʵ� �߰�������Ѵ�.��
                }
            }
        }
        answer = new int[temp.size()];
        for(int i =0; i<temp.size();i++) {
            answer[i] = temp.get(i);
        }
        return answer;
	}
	
	
	
	
	// [�ַ��2] ���� for���� preNum ������ �������� �� Ȱ���� ���
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
	
	
	
	
	// [�ַ��3] LinkedList�� Arrays, stream�� ����� ���, �ξ� ���� ����ӵ��� ��°���
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
